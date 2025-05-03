package ir.ac.kntu;

import java.io.*;
import java.util.ArrayList;

public class DataBase {

    public DataBase() {
    }

    public ArrayList<User> loadUserInfo() {
        ArrayList<User> users = new ArrayList<User>();
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\user.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each user
                    User user = (User) input.readObject();
                    users.add(user);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the user data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for users has been saved.");
        }
        return users;
    }

    public void saveUserInfos(ArrayList<User> users) {
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\user.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (User user : users) {
                try {
                    output.writeObject(user);
                } catch (IOException e) {
                    System.out.println("(User::saveUserInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(User::saveUserInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Admin> loadAdminInfo() {
        ArrayList<Admin> admins = new ArrayList<Admin>();
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\admin.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each admin
                    Admin admin = (Admin) input.readObject();
                    admins.add(admin);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the admin data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for admins has been saved.");
        }
        return admins;
    }

    public void saveAdminInfos(ArrayList<Admin> admins) {
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\admin.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Admin admin : admins) {
                try {
                    output.writeObject(admin);
                } catch (IOException e) {
                    System.out.println("(Admin::saveAdminInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(Admin::saveAdminInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Game> loadGameInfo() {
        ArrayList<Game> games = new ArrayList<Game>();
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\Game.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each game
                    Game game = (Game) input.readObject();
                    games.add(game);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the game data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for games has been saved.");
        }
        return games;
    }

    public void saveGameInfos(ArrayList<Game> games) {
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\game.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Game game : games) {
                try {
                    output.writeObject(game);
                } catch (IOException e) {
                    System.out.println("(Game::saveGameInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(Game::saveGameInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Developer> loadDeveloperInfo() {
        ArrayList<Developer> developers = new ArrayList<Developer>();
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\Developer.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each developer
                    Developer developer = (Developer) input.readObject();
                    developers.add(developer);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the developer data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for developers has been saved.");
        }
        return developers;
    }

    public void saveDeveloperInfos(ArrayList<Developer> developers) {
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\developer.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Developer developer : developers) {
                try {
                    output.writeObject(developer);
                } catch (IOException e) {
                    System.out.println("(Developer::saveDeveloperInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(Developer::saveDeveloperInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Seller> loadSellerInfo() {
        ArrayList<Seller> sellers = new ArrayList<Seller>();
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\Seller.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    //Read info for each seller
                    Seller seller = (Seller) input.readObject();
                    sellers.add(seller);
                } catch (EOFException e) {
                    //Reaching end of file
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the seller data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data for sellers has been saved.");
        }
        return sellers;
    }

    public void saveSellerInfos(ArrayList<Seller> sellers) {
        File file = new File("C:\\Users\\a\\Desktop\\Practices\\AP4012\\project3\\src\\main\\java\\ir\\ac\\kntu\\seller.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Seller seller : sellers) {
                try {
                    output.writeObject(seller);
                } catch (IOException e) {
                    System.out.println("(Seller::saveSellerInfos): " +
                            "An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("(Seller::saveSellerInfos): " +
                    "An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

}
