package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.sellers;

public class AdminMenuSellers {

    Scanner sc = new Scanner(System.in);

    public AdminMenuSellers() {
    }

    public void entrance() {
        System.out.println("-----------------Admin Sellers Menu------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Sellers List\n2:Search Seller\n3:Add Seller\n4:Delete Seller\n5:Back");
        int option = sc.nextInt();
        switchAdminSellerMenu(option);
    }

    public void switchAdminSellerMenu(int option) {
        switch (option) {
            case 1:
                adminSellersListMenu();
                break;
            case 2:
                adminSearchSeller();
                break;
            case 3:
                adminAddSeller();
                break;
            case 4:
                deleteSeller();
                break;
            default:
                new AdminMenu().adminMenu();
                break;
        }
    }

    public void adminSellersListMenu() {
        System.out.println("----------------------------------------");
        if (sellers.isEmpty()) {
            System.out.println("There is no seller to show. You can add sellers later.");
            entrance();
            return;
        }
        int sellerCounter = 0;
        for (Seller seller : Main.sellers) {
            sellerCounter++;
            System.out.println("#" + sellerCounter);
            System.out.println(seller.getUsername());
            System.out.println("----------------------------------------");
        }
        System.out.println("Please select seller by number");
        Seller targetSeller = sellers.get(sc.nextInt() - 1);
        System.out.println("What are you going to do with this seller?");
        System.out.println("1:Delete seller\n2:Edit password\n3:Back");
        int option = sc.nextInt();
        switchSellerListMenu(option, targetSeller);
    }

    public void switchSellerListMenu(int option, Seller targetSeller) {
        switch (option) {
            case 1:
                System.out.print("You are deleting " + targetSeller.getUsername() + " from sellers!");
                System.out.println("----------------------------------------\n1:Confirm\n2:Cancel");
                int confirmOption = sc.nextInt();
                if (confirmOption == 1) {
                    targetSeller.deleteSeller();
                    System.out.println("----------------------------------------");
                    System.out.println("Seller has been deleted successfully!");
                    entrance();
                } else {
                    System.out.println("----------------------------------------");
                    System.out.println("Task has been Canceled!");
                    entrance();
                }
                break;
            case 2:
                System.out.print("Please input new password:");
                String newPassword = sc.next();
                targetSeller.setPassword(newPassword);
                System.out.println("----------------------------------------\n");
                entrance();
                break;
            default:
                entrance();
                break;
        }
    }

    public void adminSearchSeller() {
        if (sellers.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("There is no seller to search. You can add sellers later.");
            entrance();
            return;
        }
        System.out.println("----------------------------------------");
        System.out.print("Please input the seller username you wanna search:");
        String targetSellerUsername = sc.next();
        boolean findSeller = false;
        int targetSellerIndex = 0;
        for (Seller seller : sellers) {
            targetSellerIndex++;
            if (seller.getUsername().toLowerCase().startsWith(targetSellerUsername.toLowerCase())) {
                findSeller = true;
                break;
            }
        }
        Seller targetSeller = sellers.get(targetSellerIndex - 1);
        if (findSeller) {
            System.out.println("----------------------------------------");
            System.out.println(targetSeller.getUsername());
            System.out.println("----------------------------------------");
            System.out.println("What are you going to do with this seller?");
            System.out.println("1:Delete seller\n2:Edit password\n3:Back");
            int option = sc.nextInt();
            switchSellerListMenu(option, targetSeller);
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Seller not found!");
            entrance();
        }

    }

    public void adminAddSeller() {
        System.out.println("----------------------------------------");
        System.out.print("set Username:");
        String username = sc.next();
        System.out.print("set Password:");
        String password = sc.next();
        Seller seller = new Seller(username, password);
        seller.addSeller();
        System.out.println("----------------------------------------");
        System.out.println(seller.getUsername() + " added to sellers successfully!");
        entrance();
    }

    public void deleteSeller() {
        System.out.println("----------------------------------------");
        if (sellers.isEmpty()) {
            System.out.println("There is no seller to delete. You can add sellers later.");
            entrance();
            return;
        }
        System.out.print("Please input the seller username you wanna delete:");
        String targetSellerUsername = sc.next();
        boolean findSeller = false;
        int targetSellerIndex = 0;
        for (Seller seller : sellers) {
            targetSellerIndex++;
            if (seller.getUsername().toLowerCase().startsWith(targetSellerUsername.toLowerCase())) {
                findSeller = true;
                break;
            }
        }
        Seller targetSeller = sellers.get(targetSellerIndex - 1);
        if (findSeller) {
            System.out.println("----------------------------------------");
            System.out.print("You are deleting " + targetSeller.getUsername() + " from sellers!");
            System.out.println("----------------------------------------\n1:Confirm\n2:Cancel");
            int confirmOption = sc.nextInt();
            if (confirmOption == 1) {
                targetSeller.deleteSeller();
                System.out.println("----------------------------------------");
                System.out.println("Seller has been deleted successfully!");
                entrance();
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Task has been Canceled!");
                entrance();
            }
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Seller not found!");
            entrance();
        }
    }
}
