package ir.ac.kntu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<Admin> admins = new ArrayList<Admin>();

    public static ArrayList<Game> games = new ArrayList<>();

    public static ArrayList<Developer> developers = new ArrayList<>();

    public static ArrayList<Seller> sellers = new ArrayList<>();

    public static Scanner sc = new Scanner(System.in);

    public static Admin headAdmin = new Admin("ASO82", "Abolfazl1383");

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        users = dataBase.loadUserInfo();
        admins = dataBase.loadAdminInfo();
        games = dataBase.loadGameInfo();
        developers = dataBase.loadDeveloperInfo();
        sellers = dataBase.loadSellerInfo();
        System.out.println("Welcome :)");
        welcomeMenu();
    }

    public static void welcomeMenu() {
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Admin\n2:Developer\n3:Seller\n4:User");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        handleWelcomeMenu(option);
    }

    public static void handleWelcomeMenu(int option) {
        switch (option) {
            case 1:
                new AdminMenu(admins).adminStartMenu();
                break;
            case 2:
                new DeveloperMenu(developers).developerStartMenu();
                break;
            case 3:
                new SellerMenu().sellerStartMenu();
                break;
            case 4:
                new UserMenu(users).userMenu();
                break;
            default:
                System.out.println("----------------------------------------");
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("1:Admin\n2:Developer\n3:Seller\n4:User");
                int newOption = sc.nextInt();
                handleWelcomeMenu(newOption);
                break;
        }
    }

}