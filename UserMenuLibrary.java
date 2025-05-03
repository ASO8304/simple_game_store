package ir.ac.kntu;

import java.util.Scanner;

public class UserMenuLibrary {

    public Scanner sc = new Scanner(System.in);

    public UserMenuLibrary() {
    }

    public void handleUserMenuLibrary(User targetUser) {
        System.out.println("----------------Library-----------------");
        System.out.println("1:Games\n2:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                showGames(targetUser);
                break;
            default:
                new UserMenu().signInUserMenu(targetUser);
        }
    }

    public void showGames(User targetUser) {
        System.out.println("----------------OwnedGames-----------------\n");
        if (targetUser.getUserGames().isEmpty()) {
            System.out.println("You don't have any games. You can buy games from store:)\n");
            System.out.println("----------------------------------------");
            new UserMenu().signInUserMenu(targetUser);
            return;
        }
        for (int i = 0; i < targetUser.getUserGames().size(); i++) {
            System.out.println("#" + (i + 1));
            System.out.println(targetUser.getUserGamesName(i));
            System.out.println("----------------------------------------");
        }
        System.out.println("#0\nType \"0\" for going back");
        System.out.println("----------------------------------------");
        System.out.println("Please select one of the games above by number:");
        int selectedGameIndex = sc.nextInt();
        if (selectedGameIndex == 0) {
            handleUserMenuLibrary(targetUser);
            return;
        }
        Game selectedGame = (Game) targetUser.getUserGames().get(selectedGameIndex - 1);
        System.out.println("----------------------------------------");
        showGameDetails(selectedGame, targetUser);
    }

    public void showGameDetails(Game selectedGame, User targetUser) {
        System.out.println(selectedGame.toString());
        System.out.println("----------------------------------------");
        System.out.println("1:Community\n2:Back");
        int option = sc.nextInt();
        if (option == 1) {
            gameCommunity(selectedGame, targetUser);
        } else {
            showGames(targetUser);
        }
    }

    public void gameCommunity(Game selectedGame, User targetUser) {
        System.out.println("----------------" + selectedGame.getName() + " Community-----------------\n");
        if (selectedGame.getComment().isEmpty()) {
            System.out.println("No comment submitted yet!\n");
            System.out.println("----------------------------------------");
        } else {
            showComments(selectedGame);
        }
        System.out.println("1:Add comment\n2:Add rating\n3:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("----------------------------------------");
                System.out.println("Please add your comment:");
                String comment = sc.next();
                selectedGame.addComment(targetUser, comment);
                System.out.println("----------------------------------------");
                System.out.println("Comment submitted successfully!");
                showGames(targetUser);
                break;
            case 2:
                System.out.println("----------------------------------------");
                System.out.println("Please add your rating:");
                Double rating = sc.nextDouble();
                selectedGame.addRating(targetUser, rating);
                System.out.println("----------------------------------------");
                System.out.println("Rating submitted successfully!");
                showGames(targetUser);
                break;
            default:
                showGames(targetUser);
                break;
        }
    }

    public void showComments(Game selectedGame) {
        for (User user : Main.users) {
            if (selectedGame.getComment().containsKey(user)) {
                System.out.println(user.getUsername() + ": \"" + selectedGame.getComment().get(user) + "\"");
                System.out.println("----------------------------------------");
            }
        }
    }
}
