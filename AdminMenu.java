package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    private ArrayList<Admin> admins = new ArrayList<Admin>();


    public AdminMenu(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public AdminMenu() {

    }

    public Scanner sc = new Scanner(System.in);

    public void adminStartMenu() {
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        Admin tempAdmin = new Admin(username, password);
        if (tempAdmin.equals(Main.headAdmin)) {
            headAdminMenu();
            return;
        }
        if (admins.contains(tempAdmin)) {
            adminMenu();
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Username or Password is not correct.\n1:Try again\n2:Back");
            int option = sc.nextInt();
            handleAdminFail(option);
        }
    }

    public void handleAdminFail(int option) {
        if (option == 1) {
            adminStartMenu();
        } else if (option == 2) {
            Main.welcomeMenu();
        } else {
            System.out.println("Number is not valid. Please try again :)");
            System.out.println("1:Try again\n2:Back");
            int newOption = sc.nextInt();
            handleAdminFail(newOption);
        }
    }

    public void headAdminMenu() {
        System.out.println("---------------HeadAdmin Menu---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Games\n2:Users\n3:Admins\n4:Developers\n5:Sellers\n6:Back");
        int option = sc.nextInt();
        handleHeadAdminMenu(option);
    }


    public void adminMenu() {
        System.out.println("---------------Admin Menu---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Games\n2:Users\n3:Developers\n4:Sellers\n5:Back");
        int option = sc.nextInt();
        handleAdminMenu(option);
    }

    public void handleAdminMenu(int option) {
        switch (option) {
            case 1:
                new AdminMenuGames().entrance();
                break;
            case 2:
                new AdminMenuUsers().entrance();
                break;
            case 3:
                new AdminMenuDevelopers().entrance();
                break;
            case 4:
                new AdminMenuSellers().entrance();
                break;
            case 5:
                Main.welcomeMenu();
                break;
            default:
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("1:Games\n2:Users\n3:Developers\n4:Sellers\n5:Back");
                int newOption = sc.nextInt();
                System.out.println("----------------------------------------");
                handleAdminMenu(newOption);
        }
    }

    public void handleHeadAdminMenu(int option) {
        switch (option) {
            case 1:
                new AdminMenuGames().entrance();
                break;
            case 2:
                new AdminMenuUsers().entrance();
                break;
            case 3:
                new AdminMenuAdmins().entrance();
                break;
            case 4:
                new AdminMenuDevelopers().entrance();
                break;
            case 5:
                new AdminMenuSellers().entrance();
                break;
            case 6:
                Main.welcomeMenu();
                break;
            default:
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("1:Games\n2:Users\n3:Admins\n4:Developers\n5:Sellers\n6:Back");
                int newOption = sc.nextInt();
                System.out.println("----------------------------------------");
                handleHeadAdminMenu(newOption);
        }
    }

}
