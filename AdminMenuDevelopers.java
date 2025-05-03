package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.developers;
import static ir.ac.kntu.Main.users;

public class AdminMenuDevelopers {

    Scanner sc = new Scanner(System.in);

    public AdminMenuDevelopers() {
    }

    public void entrance() {
        System.out.println("-----------------Admin Developers Menu------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Developers List\n2:Search Developer\n3:Add Developer\n4:Delete Developer\n5:Back");
        int option = sc.nextInt();
        switchAdminDeveloperMenu(option);
    }

    public void switchAdminDeveloperMenu(int option) {
        switch (option) {
            case 1:
                adminDevelopersListMenu();
                break;
            case 2:
                adminSearchDeveloper();
                break;
            case 3:
                adminAddDeveloper();
                break;
            case 4:
                deleteDeveloper();
                break;
            default:
                new AdminMenu().adminMenu();
                break;
        }
    }

    public void adminDevelopersListMenu() {
        System.out.println("----------------------------------------");
        if (developers.isEmpty()) {
            System.out.println("There is no developer to show. You can add developers later.");
            entrance();
            return;
        }
        int developerCounter = 0;
        for (Developer developer : Main.developers) {
            developerCounter++;
            System.out.println("#" + developerCounter);
            System.out.println(developer.getUsername());
            System.out.println("----------------------------------------");
        }
        System.out.println("Please select developer by number");
        Developer targetDeveloper = developers.get(sc.nextInt() - 1);
        System.out.println("What are you going to do with this developer?");
        System.out.println("1:Delete developer\n2:Edit password\n3:Back");
        int option = sc.nextInt();
        switchDeveloperListMenu(option, targetDeveloper);
    }

    public void switchDeveloperListMenu(int option, Developer targetDeveloper) {
        switch (option) {
            case 1:
                System.out.print("You are deleting " + targetDeveloper.getUsername() + " from developers!");
                System.out.println("----------------------------------------\n1:Confirm\n2:Cancel");
                int confirmOption = sc.nextInt();
                if (confirmOption == 1) {
                    targetDeveloper.deleteDeveloper();
                    System.out.println("----------------------------------------");
                    System.out.println("Developer has been deleted successfully!");
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
                targetDeveloper.setPassword(newPassword);
                System.out.println("----------------------------------------\n");
                entrance();
                break;
            default:
                entrance();
                break;
        }
    }

    public void adminSearchDeveloper() {
        if (developers.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("There is no developer to search. You can add developers later.");
            entrance();
            return;
        }
        System.out.println("----------------------------------------");
        System.out.print("Please input the developer username you wanna search:");
        String targetDeveloperUsername = sc.next();
        boolean findDeveloper = false;
        int targetDeveloperIndex = 0;
        for (Developer developer : developers) {
            targetDeveloperIndex++;
            if (developer.getUsername().toLowerCase().startsWith(targetDeveloperUsername.toLowerCase())) {
                findDeveloper = true;
                break;
            }
        }
        Developer targetDeveloper = developers.get(targetDeveloperIndex - 1);
        if (findDeveloper) {
            System.out.println("----------------------------------------");
            System.out.println(targetDeveloper.getUsername());
            System.out.println("----------------------------------------");
            System.out.println("What are you going to do with this developer?");
            System.out.println("1:Delete developer\n2:Edit password\n3:Back");
            int option = sc.nextInt();
            switchDeveloperListMenu(option, targetDeveloper);
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Developer not found!");
            entrance();
        }

    }

    public void adminAddDeveloper() {
        System.out.println("----------------------------------------");
        System.out.print("set Username:");
        String username = sc.next();
        System.out.print("set Password:");
        String password = sc.next();
        Developer developer = new Developer(username, password);
        developer.addDeveloper();
        System.out.println("----------------------------------------");
        System.out.println(developer.getUsername() + " added to developers successfully!");
        entrance();
    }

    public void deleteDeveloper() {
        System.out.println("----------------------------------------");
        if (developers.isEmpty()) {
            System.out.println("There is no developer to delete. You can add developers later.");
            entrance();
            return;
        }
        System.out.print("Please input the developer username you wanna delete:");
        String targetDeveloperUsername = sc.next();
        boolean findDeveloper = false;
        int targetDeveloperIndex = 0;
        for (Developer developer : developers) {
            targetDeveloperIndex++;
            if (developer.getUsername().toLowerCase().startsWith(targetDeveloperUsername.toLowerCase())) {
                findDeveloper = true;
                break;
            }
        }
        Developer targetDeveloper = developers.get(targetDeveloperIndex - 1);
        if (findDeveloper) {
            System.out.println("----------------------------------------");
            System.out.print("You are deleting " + targetDeveloper.getUsername() + " from developers!");
            System.out.println("----------------------------------------\n1:Confirm\n2:Cancel");
            int confirmOption = sc.nextInt();
            if (confirmOption == 1) {
                targetDeveloper.deleteDeveloper();
                System.out.println("----------------------------------------");
                System.out.println("Developer has been deleted successfully!");
                entrance();
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Task has been Canceled!");
                entrance();
            }
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Developer not found!");
            entrance();
        }
    }
}
