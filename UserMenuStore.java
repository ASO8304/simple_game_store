package ir.ac.kntu;

import java.util.Scanner;

public class UserMenuStore {

    public UserMenuStore() {
    }

    public Scanner sc = new Scanner(System.in);

    public void handleUserMenuStore(User targetUser) {
        System.out.println("----------------Store-----------------");
        System.out.println("1:Games\n2:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                showGames(targetUser);
            default:
                new UserMenu().signInUserMenu(targetUser);
        }
    }

    public void showGames(User targetUser) {
        System.out.println("----------------Games-----------------\n");
        int regularCounter = 0;
        for (Game game : Main.games) {
            regularCounter++;
            System.out.println("#" + regularCounter);
            System.out.println(game.getName());
            System.out.println("----------------------------------------");
        }
        System.out.println("#0\nType \"0\" for going back");
        System.out.println("----------------------------------------");
        System.out.println("Please select one of the games above by number:");
        int selectedGameIndex = sc.nextInt();
        if (selectedGameIndex == 0) {
            handleUserMenuStore(targetUser);
        }
        Game selectedGame = Main.games.get(selectedGameIndex - 1);
        System.out.println("----------------------------------------");
        showGameDetails(selectedGame, targetUser);
    }

    public void showGameDetails(Game selectedGame, User targetUser) {
        System.out.println(selectedGame.toString());
        System.out.println("RealPrice:" + selectedGame.getPrice() + "    PriceWithDiscount:" + (int) (selectedGame.getPrice() * targetUser.getDiscountMultiplier()));
        System.out.println("----------------------------------------");
        if (targetUser.getUserGames().contains(selectedGame)) {
            System.out.println("You already have this game!");
            handleUserMenuStore(targetUser);
        } else {
            System.out.println("1:Buy\n2:Back");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    buyGame(selectedGame, targetUser);
                    break;
                default:
                    showGames(targetUser);
                    break;
            }
        }
    }

    public void buyGame(Game selectedGame, User targetUser) {
        if (targetUser.getWallet() >= selectedGame.getPrice()) {
            targetUser.setWallet(targetUser.getWallet() - (int) (selectedGame.getPrice() * targetUser.getDiscountMultiplier()));
            targetUser.addGame(selectedGame);
            System.out.println("----------------------------------------");
            System.out.println("Game " + selectedGame.getName() +
                    " is successfully added to your library!");
            handleUserMenuStore(targetUser);
        } else {
            System.out.println("----------------------------------------");
            System.out.println("You don't have enough balance to bay this game.\nPlease charge your account!");
            handleUserMenuStore(targetUser);
        }

    }
}
