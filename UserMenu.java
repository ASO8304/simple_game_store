package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    private ArrayList<User> users = new ArrayList<User>();

    public Scanner sc = new Scanner(System.in);

    public UserMenu(ArrayList<User> users) {
        this.users = users;
    }

    public UserMenu() {

    }

    public void userMenu() {
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Sign up\n2:Sign in\n3:Back");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        handleUserMenu(option);
    }

    public void handleUserMenu(int option) {
        switch (option) {
            case 1:
                signUpUser();
                break;
            case 2:
                signInUser();
                break;
            default:
                Main.welcomeMenu();
                break;
        }
    }

    public void signUpUser() {
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
        signUpConfirm(username, password, email, phoneNumber, option);
    }

    public void signUpConfirm(String username, String password, String email, String phoneNumber, int option) {
        if (option == 2) {
            userMenu();
        } else if (option == 1) {
            if (userInfoVerification(username, password, email, phoneNumber)) {
                User user = new User(username, password, email, phoneNumber);
                user.addUser();
                System.out.println("Sign up successfully :)");
                System.out.println("----------------------------------------");
                userMenu();
            } else {
                System.out.println("----------------------------------------");
                System.out.println("Please pay attention to errors and try again :)");
                signUpUser();
            }
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Number is not valid. Please try again :)");
            System.out.println("1:Confirm\n2:Back");
            int newOption = sc.nextInt();
            signUpConfirm(username, password, email, phoneNumber, newOption);
        }
    }

    public boolean userInfoVerification(String username, String password, String email, String phoneNumber) {
        boolean result = true;
        boolean passwordCond = true;
        boolean emailCond = true;
        boolean phoneNumberCond = true;
        System.out.println("----------------------------------------");
        if (password.length() < 8) {
            System.out.println("Password must contains at least 8 characters :(");
            passwordCond = false;
        }
        if (!passwordCapitalSmallCheck(password)) {
            System.out.println("Password must contains capital letters, small letters & also numbers :(");
            passwordCond = false;
        }
        if (!(email.matches(".+@gmail.com") || (email.matches(".+@email.com")))) {
            System.out.println("Email is not valid :(");
            emailCond = false;
        }
        if (!phoneNumber.matches("09[0-9]{9}")) {
            System.out.println("Phone number is not valid :(");
            phoneNumberCond = false;
        }
        if (!passwordCond || !emailCond || !phoneNumberCond) {
            result = false;
        }
        return result;
    }

    public boolean passwordCapitalSmallCheck(String password) {
        int capital = 0;
        int small = 0;
        for (int i = 0; i < password.length(); i++) {
            char t = password.charAt(i);
            if ((t >= 97) && (t <= 122)) {
                small++;
            } else if ((t >= 65) && (t <= 90)) {
                capital++;
            }
        }
        if ((capital < 1) || (small < 1)) {
            return false;
        }
        return true;
    }

    public void signInUser() {
        System.out.print("Username:");
        String username = sc.next();
        boolean usernameExistence = false;
        User targetUser = null;
        for (User user : Main.users) {
            if (username.equals(user.getUsername())) {
                usernameExistence = true;
                targetUser = user;
            }
        }
        if (usernameExistence == false) {
            System.out.println("----------------------------------------");
            System.out.println("Username not found!");
            userMenu();
        } else {
            System.out.print("Password:");
            String password = sc.next();
            checkUserSignInPassword(targetUser, password);
        }
    }

    public void checkUserSignInPassword(User targetUser, String password) {
        if (targetUser.getPassword().equals(password)) {
            System.out.println("Sign in successfully :)");
            System.out.println("----------------------------------------");
            targetUser.setLogInTime(System.currentTimeMillis());
            signInUserMenu(targetUser);
        } else {
            System.out.println("Password is wrong.\n1:Try again\n2:Back");
            int option = sc.nextInt();
            if (option == 1) {
                signInUser();
            } else {
                userMenu();
            }
        }
    }

    public void signInUserMenu(User targetUser) {
        System.out.println("Please choose one of the following options:");
        System.out.println("1:Profile\n2:Store\n3:Library\n4:Friends\n5:Back");
        int option = sc.nextInt();
        handleSignInUserMenu(option, targetUser);
    }

    public void handleSignInUserMenu(int option, User targetUser) {
        switch (option) {
            case 1:
                new UserMenuProfile().handleUserMenuProfile(targetUser);
                break;
            case 2:
                new UserMenuStore().handleUserMenuStore(targetUser);
                break;
            case 3:
                new UserMenuLibrary().handleUserMenuLibrary(targetUser);
                break;
            case 4:
                new UserMenuFriends().handleUserMenuFriends(targetUser);
                break;
            case 5:
                targetUser.setLogOutTime(System.currentTimeMillis());
                System.out.println("PlayTime: " + targetUser.getPlayTime() / 1000);
                userMenu();
                break;
            default:
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("1:Profile\n2:Store\n3:Library\n4:Friends\n5:Back");
                int newOption = sc.nextInt();
                System.out.println("----------------------------------------");
                new UserMenuProfile().switchUserMenuProfile(newOption, targetUser);
                break;
        }
    }
}
