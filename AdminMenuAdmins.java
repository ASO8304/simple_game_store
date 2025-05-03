package ir.ac.kntu;

import java.util.Scanner;

public class AdminMenuAdmins {

    Scanner sc = new Scanner(System.in);

    public AdminMenuAdmins() {
    }

    public void entrance() {
        System.out.println("-----------------HeadAdmin Admins Menu------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Add Admin\n2:Delete Admin\n3:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                addNewAdmin();
                break;
            case 2:
                deleteAdmin();
                break;
            default:
                new AdminMenu().headAdminMenu();
                break;
        }
    }

    public void addNewAdmin() {
        System.out.println("----------------------------------------");
        System.out.println("Please input newAdmin username:");
        String username = sc.next();
        System.out.println("Please input newAdmin password:");
        String password = sc.next();
        Admin admin = new Admin(username, password);
        System.out.println("----------------------------------------");
        System.out.println("Admin has been added successfully!");
        System.out.println("----------------------------------------");
        admin.addAdmin();
        new AdminMenu().headAdminMenu();
    }

    public void deleteAdmin() {
        System.out.println("----------------------------------------");
        if (Main.admins.isEmpty()) {
            System.out.println("There is no admin to delete!");
            new AdminMenu().headAdminMenu();
            return;
        }
        System.out.print("Please input the username of the admin you wanna delete:");
        String targetAdminUsername = sc.next();
        boolean findAdmin = false;
        int targetAdminIndex = 0;
        for (Admin admin : Main.admins) {
            targetAdminIndex++;
            if (admin.getUsername().toLowerCase().startsWith(targetAdminUsername.toLowerCase())) {
                findAdmin = true;
                break;
            }
        }
        if (findAdmin) {
            Admin admin = Main.admins.get(targetAdminIndex - 1);
            System.out.println("----------------------------------------");
            System.out.println("You are removing " + admin.getUsername() + " from admins!");
            System.out.println("----------------------------------------\n1:Confirm\n2:Cancel");
            int option = sc.nextInt();
            if (option == 1) {
                admin.deleteAdmin();
                System.out.println("----------------------------------------");
                System.out.println("Admin has been deleted successfully!");
                new AdminMenu().headAdminMenu();
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Task has been Canceled!");
                new AdminMenu().headAdminMenu();
            }
        } else {
            System.out.println("No match found.");
            new AdminMenu().headAdminMenu();
        }
    }
}
