package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenuGames {

    public Scanner sc = new Scanner(System.in);

    public AdminMenuGames() {
    }

    public void entrance() {
        System.out.println("-----------------Admin Games Menu------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Add Game\n2:Delete Game\n3:Edit Game\n4:Back");
        int option = sc.nextInt();
        switchEntrance(option);
    }

    public void switchEntrance(int option) {
        switch (option) {
            case 1:
                adminAddGame();
                break;
            case 2:
                adminDeleteGame();
                break;
            case 3:
                adminEditGame();
                break;
            default:
                new AdminMenu().adminMenu();
                break;
        }
    }

    public void adminAddGame() {
        System.out.println("----------------------------------------");
        System.out.print("Please input the name of the game you wanna add:");
        String name = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Please select the genre of the game you wanna add:");
        System.out.println("1:ACTION 2:RACING 3:STRATEGY 4:SIMULATION\n5:SHOOTER 6:SPORT 7:ADVENTURE 8:ETC");
        int optionGenre = sc.nextInt();
        Genre genre = switchGameGenre(optionGenre);
        System.out.println("----------------------------------------");
        System.out.print("Please input the price of the game you wanna add:");
        double price = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("Game " + name + " has been added successfully!");
        Game game = new Game(name, genre, price);
        game.addGame();
        entrance();
    }

    public Genre switchGameGenre(int optionGenre) {
        switch (optionGenre) {
            case 1:
                return Genre.ACTION;
            case 2:
                return Genre.RACING;
            case 3:
                return Genre.STRATEGY;
            case 4:
                return Genre.SIMULATION;
            case 5:
                return Genre.SHOOTER;
            case 6:
                return Genre.SPORT;
            case 7:
                return Genre.ADVENTURE;
            default:
                return Genre.ETC;
        }
    }

    public void adminDeleteGame() {
        System.out.println("----------------------------------------");
        System.out.print("Please search the name of the game you wanna delete: (type \"back\" if you want to go back)");
        String targetGameName = sc.next();
        if (targetGameName.equals("back")) {
            entrance();
            return;
        }
        int gameIndex = 0;
        boolean findMatch = false;
        ArrayList<Integer> targetGameIndexes = new ArrayList<Integer>();
        for (Game game : Main.games) {
            gameIndex++;
            if (game.getName().toLowerCase().startsWith(targetGameName.toLowerCase())) {
                findMatch = true;
                targetGameIndexes.add(gameIndex);
            }
        }
        if (findMatch == false) {
            System.out.println("No game found!");
            adminDeleteGame();
        }
        System.out.println("----------------------------------------");
        System.out.println("Search results:\n");
        int regularCounter = 0;
        for (Integer integer : targetGameIndexes) {
            regularCounter++;
            System.out.println("#" + regularCounter + "\n" + Main.games.get(integer - 1).toString());
            System.out.println("----------------------------------------");
        }
        System.out.print("Please select the game you wanna delete by number:");
        int deleteGame = sc.nextInt() - 1;
        System.out.println("----------------------------------------");
        System.out.println("Game " + Main.games.get(targetGameIndexes.get(deleteGame) - 1).getName() +
                " has been deleted successfully!");
        Game targetGame = Main.games.get(targetGameIndexes.get(deleteGame) - 1);
        targetGame.deleteGame();
        entrance();
    }

    public void adminEditGame() {
        System.out.println("----------------------------------------");
        System.out.print("Please search the name of the game you wanna edit: (type \"back\" if you want to go back)");
        String targetGameName = sc.next();
        if (targetGameName.equals("back")) {
            entrance();
            return;
        }
        int gameIndex = 0;
        boolean findMatch = false;
        ArrayList<Integer> targetGameIndexes = new ArrayList<Integer>();
        for (Game game : Main.games) {
            gameIndex++;
            if (game.getName().toLowerCase().startsWith(targetGameName.toLowerCase())) {
                findMatch = true;
                targetGameIndexes.add(gameIndex);
            }
        }
        if (findMatch == false) {
            System.out.println("No game found!");
            adminEditGame();
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("Search results:\n");
        int regularCounter = 0;
        for (Integer integer : targetGameIndexes) {
            regularCounter++;
            System.out.println("#" + regularCounter + "\n" + Main.games.get(integer - 1).toString());
            System.out.println("----------------------------------------");
        }
        System.out.print("Please select the game you wanna edit by number:");
        int editGame = sc.nextInt();
        Game targetGame = Main.games.get(targetGameIndexes.get(editGame - 1) - 1);
        editGame(targetGame);
        new AdminMenu().adminMenu();
    }

    public void editGame(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("1:Edit Name\n2:Edit Genre\n3:Edit Price\n4:Edit Description\n6:Edit Developers\n5:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                editGameName(game);
                break;
            case 2:
                editGameGenre(game);
                break;
            case 3:
                editGamePrice(game);
                break;
            case 4:
                editGameDescription(game);
                break;
            case 5:
                editGameDevelopers(game);
                break;
            default:
                entrance();
                break;
        }
    }

    public void editGameName(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Name: " + game.getName());
        System.out.print("Please input the new name:");
        String newName = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Game name has been changed successfully!");
        game.setName(newName);
        entrance();
    }

    public void editGameGenre(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Genre: " + game.getGenre());
        System.out.println("Please select the new Genre:");
        System.out.println("1:ACTION 2:RACING 3:STRATEGY 4:SIMULATION\n5:SHOOTER 6:SPORT 7:ADVENTURE 8:ETC");
        int optionGenre = sc.nextInt();
        Genre newGenre = switchGameGenre(optionGenre);
        System.out.println("----------------------------------------");
        System.out.println("Game genre has been changed successfully!");
        game.setGenre(newGenre);
        entrance();
    }

    public void editGamePrice(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Price: " + game.getPrice());
        System.out.print("Please input the new price:");
        double newPrice = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("Game price has been changed successfully!");
        game.setPrice(newPrice);
        entrance();
    }

    public void editGameDescription(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Description: " + game.getDescription());
        System.out.print("Please input the new description:");
        String newDescription = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Game description has been changed successfully!");
        game.setDescription(newDescription);
        entrance();
    }

    public void editGameDevelopers(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Please select one of the following options:");
        System.out.println("1:Add developer to this game\n2:Remove developer from this game\3:Back");
        int option = sc.nextInt();
        switch (option) {

            case 1:
                editGameDevelopersAddDeveloper();
                break;
            case 2:
                editGameDevelopersRemoveDeveloper();
                break;
            default:
                break;
        }
        System.out.println("Developers: ");
        int regularCounter = 0;
        for (Developer developer : game.getGameDevelopers()) {
            regularCounter++;
            System.out.println("#" + regularCounter);
            System.out.println(developer.getUsername());
            System.out.println("----------------------------------------");
        }
        System.out.print("Please select the developer you wanna delete by number:");
    }

    public void editGameDevelopersAddDeveloper() {

    }

    public void editGameDevelopersRemoveDeveloper() {

    }
}