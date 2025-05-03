package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class DeveloperMenu {

    private ArrayList<Developer> developers = new ArrayList<Developer>();

    public DeveloperMenu(ArrayList<Developer> developers) {
        this.developers = developers;
    }

    public DeveloperMenu() {

    }

    Scanner sc = new Scanner(System.in);

    public void developerStartMenu() {
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        Developer tempDeveloper = new Developer(username, password);
        System.out.println("----------------------------------------");
        if (developers.contains(tempDeveloper)) {
            developerMenu(tempDeveloper);
        } else {
            System.out.println("Username or Password is not correct.\n1:Try again\n2:Back");
            int option = sc.nextInt();
            if (option == 1) {
                developerStartMenu();
            } else {
                Main.welcomeMenu();
            }
        }
    }

    public void developerMenu(Developer developer) {
        System.out.println("---------------Developer Menu---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Games\n2:Back");
        int option = sc.nextInt();
        if (option == 1) {
            developerMenuGames(developer);
        } else {
            Main.welcomeMenu();
        }
    }

    public void developerMenuGames(Developer developer) {
        System.out.println("---------------Developer Games---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Add Game\n2:Delete Game\n3:Edit Game\n4:Back");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switchDeveloperOption(option, developer);
    }

    public void switchDeveloperOption(int option, Developer developer) {
        switch (option) {
            case 1:
                developerAddGame(developer);
                break;
            case 2:
                developerDeleteGame(developer);
                break;
            case 3:
                developerEditGame(developer);
                break;
            default:
                new DeveloperMenu().developerMenu(developer);
                break;
        }
    }

    public void developerAddGame(Developer developer) {
        System.out.println("----------------------------------------");
        System.out.print("Please input the name of the game you wanna add:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Please select the genre of the game you wanna add:");
        System.out.println("1:ACTION 2:RACING 3:STRATEGY 4:SIMULATION\n5:SHOOTER 6:SPORT 7:ADVENTURE 8:ETC");
        int optionGenre = sc.nextInt();
        Genre genre = new AdminMenuGames().switchGameGenre(optionGenre);
        System.out.println("----------------------------------------");
        System.out.print("Please input the price of the game you wanna add:");
        double price = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("Game " + name + " has been added successfully!");
        Game game = new Game(name, genre, price);

        game.addGameDeveloper(developer);
        game.addGame();

        developerMenuGames(developer);
    }

    public void developerDeleteGame(Developer developer) {
        System.out.println("----------------------------------------");
        int gameIndex = 0;
        boolean findMatch = false;
        ArrayList<Integer> targetGameIndexes = new ArrayList<Integer>();
        for (Game game : Main.games) {
            gameIndex++;
            if (game.getGameDevelopers().contains(developer)) {
                findMatch = true;
                targetGameIndexes.add(gameIndex);
            }
        }
        int regularCounter = 0;
        for (Integer integer : targetGameIndexes) {
            regularCounter++;
            System.out.println("#" + regularCounter + "\n" + Main.games.get(integer - 1).toString());
            System.out.println("----------------------------------------");
        }
        if (findMatch == false) {
            System.out.println("No game is developed by you!");
            developerMenuGames(developer);
            return;
        }
        System.out.println("Please select the game you wanna delete by number: (type 0 if you want to go back)");
        int deleteGameOption = sc.nextInt() - 1;
        if (deleteGameOption == -1) {
            developerMenuGames(developer);
            return;
        }
        Game targetGame = Main.games.get(targetGameIndexes.get(deleteGameOption) - 1);
        System.out.println("----------------------------------------");
        System.out.println("Game " + Main.games.get(targetGameIndexes.get(deleteGameOption) - 1).getName() +
                " has been deleted successfully!");
        targetGame.deleteGame();
        developerMenuGames(developer);

    }

    public void developerEditGame(Developer developer) {
        System.out.println("----------------------------------------");
        int gameIndex = 0;
        boolean findMatch = false;
        ArrayList<Integer> targetGameIndexes = new ArrayList<Integer>();
        for (Game game : Main.games) {
            gameIndex++;
            if (game.getGameDevelopers().contains(developer)) {
                findMatch = true;
                targetGameIndexes.add(gameIndex);
            }
        }
        int regularCounter = 0;
        for (Integer integer : targetGameIndexes) {
            regularCounter++;
            System.out.println("#" + regularCounter + "\n" + Main.games.get(integer - 1).toString());
            System.out.println("----------------------------------------");
        }
        if (findMatch == false) {
            System.out.println("No game is developed by you!");
            developerMenuGames(developer);
            return;
        }
        System.out.print("Please select the game you wanna edit by number: (type 0 if you want to go back)");
        int deleteGameOption = sc.nextInt() - 1;
        if (deleteGameOption == 0) {
            developerMenuGames(developer);
            return;
        }
        Game targetGame = Main.games.get(targetGameIndexes.get(deleteGameOption) - 1);
        System.out.println("----------------------------------------");
        developerEditGame2(targetGame);
        developerMenuGames(developer);

    }

    public void developerEditGame2(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("1:Edit Name\n2:Edit Genre\n3:Edit Price\n4:Edit Description\n6:Back");
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
            default:
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
    }

    public void editGameGenre(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Genre: " + game.getGenre());
        System.out.println("Please select the new Genre:");
        System.out.println("1:ACTION 2:RACING 3:STRATEGY 4:SIMULATION\n5:SHOOTER 6:SPORT 7:ADVENTURE 8:ETC");
        int optionGenre = sc.nextInt();
        Genre newGenre = new AdminMenuGames().switchGameGenre(optionGenre);
        System.out.println("----------------------------------------");
        System.out.println("Game genre has been changed successfully!");
        game.setGenre(newGenre);
    }

    public void editGamePrice(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Price: " + game.getPrice());
        System.out.print("Please input the new price:");
        double newPrice = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("Game price has been changed successfully!");
        game.setPrice(newPrice);
    }

    public void editGameDescription(Game game) {
        System.out.println("----------------------------------------");
        System.out.println("Previous Description: " + game.getDescription());
        System.out.print("Please input the new description:");
        String newDescription = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Game description has been changed successfully!");
        game.setDescription(newDescription);
    }

}
