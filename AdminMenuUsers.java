package ir.ac.kntu;

import java.util.Scanner;

import static ir.ac.kntu.Main.users;

public class AdminMenuUsers {

    public AdminMenuUsers() {
    }

    public Scanner sc = new Scanner(System.in);

    public void entrance() {
        System.out.println("-----------------Admin Users Menu------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Users List\n2:Search User\n3:Add User\n4:Delete User\n5:Back");
        int option = sc.nextInt();
        switchAdminUserMenu(option);
    }

    public void switchAdminUserMenu(int option) {
        switch (option) {
            case 1:
                userslistMenu();
                break;
            case 2:
                usersSearchUser();
                break;
            case 3:
                usersAddUser();
                break;
            case 4:
                usersDeleteUser();
                break;
            default:
                new AdminMenu().adminMenu();
                break;
        }
    }

    public void userslistMenu() {
        if(users.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("There is no user to show. You can add users later.");
            entrance();
            return;
        }
        int userCounter = 0;
        for (User user : Main.users) {
            userCounter++;
            System.out.println("#" + userCounter);
            System.out.println(user.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("Please select user by number");
        User targetUser = users.get(sc.nextInt() - 1);
        System.out.println("What are you going to do with this user?");
        System.out.println("1:Edit username\n2:Edit password\n3:Edit Email\n4:Edit phoneNumber\n5:Charge wallet\n6:Back");
        int option = sc.nextInt();
        switchAdminUsersUsersListMenu(option, targetUser);
    }

    public void switchAdminUsersUsersListMenu(int option, User targetUser) {
        switch (option) {
            case 1:
                System.out.print("Please input new username:");
                String newUsername = sc.next();
                targetUser.setUsername(newUsername);
                System.out.println("----------------------------------------\nUsername has been changed successfully!");
                entrance();
                break;
            case 2:
                System.out.print("Please input new password:");
                String newPassword = sc.next();
                targetUser.setPassword(newPassword);
                System.out.println("----------------------------------------\n");
                entrance();
                break;
            case 3:
                System.out.print("Please input new email:");
                String newEmail = sc.next();
                targetUser.setEmail(newEmail);
                System.out.println("----------------------------------------\nEmail has been changed successfully!");
                entrance();
                break;
            case 4:
                System.out.print("Please input new phoneNumber:");
                String newPhoneNumber = sc.next();
                targetUser.setPhoneNumber(newPhoneNumber);
                System.out.println("----------------------------------------\nPhoneNumber has been changed successfully!");
                entrance();
                break;
            case 5:
                System.out.println("how much money do you want to charge?");
                double charge = sc.nextDouble();
                targetUser.chargeWallet(charge);
                System.out.println("----------------------------------------\nWallet has been charged successfully!");
                entrance();
                break;
            default:
                entrance();
                break;
        }
    }

    public void usersSearchUser() {
        System.out.println("----------------------------------------");
        System.out.println("1:Search by username\n2:Search by phoneNumber\n3:Search by email\n4:Back");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        User targetUser = switchUsersSearchUser(option);
        if (targetUser != null) {
            findAdminUsersSearchUser(targetUser);
        } else {
            System.out.println("----------------------------------------");
            System.out.println("User not found!");
            usersSearchUser();
        }

    }

    public User switchUsersSearchUser(int option) {
        boolean findUser = false;
        int targetUser = 0;
        switch (option) {
            case 1 -> {
                System.out.print("Please input the username you wanna search:");
                String targetUsername = sc.next();
                for (User user : users) {
                    targetUser++;
                    if (user.getUsername().equals(targetUsername)) {
                        findUser = true;
                        break;
                    }
                }
            }
            case 2 -> {
                System.out.print("Please input the phoneNumber you wanna search:");
                String targetPhoneNumber = sc.next();
                for (User user : users) {
                    targetUser++;
                    if (user.getPhoneNumber().equals(targetPhoneNumber)) {
                        findUser = true;
                        break;
                    }
                }
            }
            case 3 -> {
                System.out.print("Please input the email you wanna search:");
                String targetEmail = sc.next();
                for (User user : users) {
                    targetUser++;
                    if (user.getEmail().equals(targetEmail)) {
                        findUser = true;
                        break;
                    }
                }
            }
            default -> entrance();
        }
        if (findUser) {
            return users.get(targetUser - 1);
        } else {
            return null;
        }
    }

    public void findAdminUsersSearchUser(User targetUser) {
        System.out.println("----------------------------------------");
        System.out.println(targetUser.toString());
        System.out.println("----------------------------------------");
        System.out.println("What are you going to do with this user?");
        System.out.println("1:Edit username\n2:Edit password\n3:Edit Email\n4:Edit phoneNumber\n5:Charge wallet\n6:Back");
        int option = sc.nextInt();
        switchAdminUsersUsersListMenu(option, targetUser);
    }

    public void usersAddUser() {
        System.out.print("Username:");
        String username = sc.next();
        System.out.print("Password:");
        String password = sc.next();
        System.out.print("Email:");
        String email = sc.next();
        System.out.print("Phone Number:");
        String phoneNumber = sc.next();
        System.out.println("----------------------------------------");
        System.out.println("1:Confirm\n2:Back");
        int option = sc.nextInt();
        usersAddUserConfirm(username, password, email, phoneNumber, option);
    }

    public void usersAddUserConfirm(String username, String password, String email, String phoneNumber, int option) {
        if (option == 2) {
            entrance();
        } else if (option == 1) {
            if (new UserMenu().userInfoVerification(username, password, email, phoneNumber)) {
                User user = new User(username, password, email, phoneNumber);
                user.addUser();
                System.out.println("User added successfully :)");
                System.out.println("----------------------------------------");
                entrance();
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Please pay attention to errors and try again :)");
                usersAddUser();
            }
        } else {
            usersAddUser();
        }
    }

    public void usersDeleteUser() {
        System.out.println("----------------------------------------");
        int targetUser = 0;
        for (User user : users) {
            targetUser++;
            System.out.println("#" + targetUser + "\n" + user.toString());
            System.out.println("----------------------------------------");
        }
        System.out.print("Please select user by number:");
        targetUser = sc.nextInt();
        System.out.println("----------------------------------------");
        System.out.println("username " + users.get(targetUser - 1).getUsername() + " has been delete deleted successfully!");
        users.remove(targetUser - 1);
        entrance();
    }
}

