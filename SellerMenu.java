package ir.ac.kntu;

import java.util.Scanner;

public class SellerMenu {

    Scanner sc = new Scanner(System.in);

    public SellerMenu() {

    }

    public void sellerStartMenu() {
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        Seller tempSeller = new Seller(username, password);
        System.out.println("----------------------------------------");
        if (Main.sellers.contains(tempSeller)) {
            sellerMenu(tempSeller);
        } else {
            System.out.println("Username or Password is not correct.\n1:Try again\n2:Back");
            int option = sc.nextInt();
            if (option == 1) {
                sellerStartMenu();
            } else {
                Main.welcomeMenu();
            }
        }
    }

    public void sellerMenu(Seller seller) {
        System.out.println("---------------Seller Menu---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Accessories\n2:Back");
        int option = sc.nextInt();
        if (option == 1) {
            sellerMenuAccessories(seller);
        } else {
            Main.welcomeMenu();
        }
    }

    public void sellerMenuAccessories(Seller seller) {
        System.out.println("---------------Seller Accessories---------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Add Accessory\n2:Delete Accessory\n3:Edit Accessory\n4:Back");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switchSellerOption(option, seller);
    }

    public void switchSellerOption(int option, Seller seller) {
        switch (option) {
            case 1:
                sellerAddAccessory(seller);
                break;
            case 2:
                sellerDeleteAccessory(seller);
                break;
            case 3:
                sellerEditAccessory(seller);
                break;
            default:
                new SellerMenu().sellerMenu(seller);
                break;
        }
    }

    public void sellerAddAccessory(Seller seller) {
        System.out.println("----------------------------------------");
        System.out.println("Please select the type of the accessory you wanna add:");
        System.out.println("1:Controller 2:Monitor");
        int optionType = sc.nextInt();
        if (optionType == 1) {
            sellerAddController(seller);
        } else {
            sellerAddMonitor(seller);
        }
    }

    public void sellerAddController(Seller seller) {
        System.out.println("----------------------------------------");
        System.out.println("Please write the name of the controller you wanna add:");
        String name = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Please choose if the controller is wireless or not:");
        System.out.println("1:Wireless\n2:With wire");
        int wireOption = sc.nextInt();
        boolean isWireless = false;
        if (wireOption == 1) {
            isWireless = true;
        }
        System.out.println("----------------------------------------");
        System.out.println("Please enter the price of the controller:");
        double price = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("How many of this controller you want to add to store? (write the number)");
        int num = sc.nextInt();
        Controller controller = new Controller(name, price, isWireless, num);
        seller.addAccessory(controller);
        sellerMenuAccessories(seller);
    }

    public void sellerAddMonitor(Seller seller) {
        System.out.println("----------------------------------------");
        System.out.println("Please write the name of the monitor you wanna add:");
        String name = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("Please enter the monitor refreshRate:");
        int refreshRate = sc.nextInt();
        System.out.println("----------------------------------------");
        System.out.println("Please enter the size of the monitor:");
        int size = sc.nextInt();
        System.out.println("----------------------------------------");
        System.out.println("Please enter the monitor responseTime:");
        int responseTime = sc.nextInt();
        System.out.println("----------------------------------------");
        System.out.println("Please enter the price of the monitor:");
        double price = sc.nextDouble();
        System.out.println("----------------------------------------");
        System.out.println("How many of this controller you want to add to store? (write the number)");
        int num = sc.nextInt();
        Monitor monitor = new Monitor(name, price, refreshRate, size, responseTime, num);
        seller.addAccessory(monitor);
        sellerMenuAccessories(seller);
    }

    public void sellerDeleteAccessory(Seller seller) {
        System.out.println("----------------------------------------");
        if (seller.getAccessories().isEmpty()) {
            System.out.println("You have no previous accessory record!");
            sellerMenuAccessories(seller);
            return;
        }
        System.out.print("Please input the name of the accessory you wanna delete:");
        String targetAccessoryName = sc.next();
        System.out.println("----------------------------------------");
        boolean findAccessory = false;
        int targetAccessoryIndex = 0;
        for (Accessory accessory : seller.getAccessories()) {
            targetAccessoryIndex++;
            if (accessory.getName().toLowerCase().startsWith(targetAccessoryName.toLowerCase())) {
                findAccessory = true;
                break;
            }
        }
        if (findAccessory) {
            Accessory accessory = seller.getAccessories().get(targetAccessoryIndex - 1);
            seller.deleteAccessory(accessory);
            System.out.println("Accessory has been deleted successfully!");
            sellerMenuAccessories(seller);
        } else {
            System.out.println("No match found.");
            sellerMenuAccessories(seller);
        }
    }

    public void sellerEditAccessory(Seller seller) {
        System.out.println("----------------------------------------");
        if (seller.getAccessories().isEmpty()) {
            System.out.println("You have no previous accessory record!");
            sellerMenuAccessories(seller);
            return;
        }
        System.out.print("Please input the name of the accessory you wanna edit:");
        String targetAccessoryName = sc.next();
        boolean findAccessory = false;
        int targetAccessoryIndex = 0;
        for (Accessory accessory : seller.getAccessories()) {
            targetAccessoryIndex++;
            if (accessory.getName().toLowerCase().startsWith(targetAccessoryName.toLowerCase())) {
                findAccessory = true;
                break;
            }
        }
        if (findAccessory) {
            Accessory accessory = seller.getAccessories().get(targetAccessoryIndex - 1);
            if (accessory.getClass() == Controller.class) {
                editAccessoryTypeConroller(seller, (Controller) accessory);
            } else if (accessory.getClass() == Monitor.class) {
                editAccessoryTypeMonitor(seller, (Monitor) accessory);
            }
            sellerMenuAccessories(seller);
        } else {
            System.out.println("No match found.");
            sellerMenuAccessories(seller);
        }
    }

    public void editAccessoryTypeConroller(Seller seller, Controller accessory) {
        System.out.println("----------------------------------------");
        System.out.println("Please select from the following options:");
        System.out.println("1:Edit name\n2:Edit Price\n3:Edit availableNumbers\n4:Edit wireless condition\n5:Back");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        switch (option) {
            case 1:
                System.out.println("Previous name:" + accessory.getName() + "\nPlease enter the new name:");
                accessory.setName(sc.next());
                break;
            case 2:
                System.out.println("Previous price:" + accessory.getPrice() + "\nPlease enter the new price:");
                accessory.setPrice(sc.nextDouble());
                break;
            case 3:
                System.out.println("Previous number:" + accessory.getNumber() + "\nPlease enter the new number:");
                accessory.setNumber(sc.nextInt());
                break;
            case 4:
                System.out.println("Previous condition:" + accessory.isWireless() + "\nPlease select the new condition:");
                System.out.println("1:Wireless\n2:With wire");
                if (sc.nextInt() == 1) {
                    accessory.setWireless(true);
                } else {
                    accessory.setWireless(false);
                }
                break;
            default:
                sellerMenuAccessories(seller);
                break;
        }
        sellerMenuAccessories(seller);
    }

    public void editAccessoryTypeMonitor(Seller seller, Monitor accessory) {
        System.out.println("----------------------------------------");
        System.out.println("Please select from the following options:");
        System.out.println("1:Edit name\n2:Edit Price\n3:Edit refreshRate\n4:Edit size\n5:Edit ResponseTime\n6:Edit availableNumbers\n7:Back");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        switch (option) {
            case 1:
                System.out.println("Previous name:" + accessory.getName() + "\nPlease enter the new name:");
                accessory.setName(sc.next());
                break;
            case 2:
                System.out.println("Previous price:" + accessory.getPrice() + "\nPlease enter the new price:");
                accessory.setPrice(sc.nextDouble());
                break;
            case 3:
                System.out.println("Previous refreshRate:" + accessory.getRefreshRate() + "\nPlease enter the new refreshRate:");
                accessory.setRefreshRate(sc.nextInt());
                break;
            case 4:
                System.out.println("Previous size:" + accessory.getSize() + "\nPlease enter the new size:");
                accessory.setSize(sc.nextInt());
                break;
            case 5:
                System.out.println("Previous responseTime:" + accessory.getResponseTime() + "\nPlease enter the new responseTime:");
                accessory.setResponseTime(sc.nextInt());
                break;
            case 6:
                System.out.println("Previous availableNumbers:" + accessory.getNumber() + "\nPlease enter the new availableNumbers:");
                accessory.setNumber(sc.nextInt());
                break;
            default:
                sellerMenuAccessories(seller);
                break;
        }
        sellerMenuAccessories(seller);
    }
}















