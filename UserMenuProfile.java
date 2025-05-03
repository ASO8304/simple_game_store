package ir.ac.kntu;

import java.util.Scanner;

public class UserMenuProfile {

    public UserMenuProfile() {
    }

    public Scanner sc = new Scanner(System.in);

    public void handleUserMenuProfile(User targetUser) {
        System.out.println("----------------Profile-----------------");
        System.out.println("Username: " + targetUser.getUsername());
        System.out.println("Email: " + targetUser.getEmail());
        System.out.println("PhoneNumber: " + targetUser.getPhoneNumber());
        System.out.println("Wallet: " + targetUser.getWallet());
        System.out.println("PlayTime: " + (targetUser.getPlayTime() / 1000));
        System.out.println("Score: " + targetUser.getScore());
        System.out.println("----------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("\n1:Edit Profile\n2:Charge wallet\n3:Back");
        switchUserMenuProfile(sc.nextInt(), targetUser);
    }

    public void switchUserMenuProfile(int option, User targetUser) {
        switch (option) {
            case 1:
                editProfile(targetUser);
                break;
            case 2:
                chargeWallet(targetUser);
                break;
            case 3:
                new UserMenu().signInUserMenu(targetUser);
                break;
            default:
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("\n1:Edit Profile\n2:Charge wallet\n3:Back");
                int newOption = sc.nextInt();
                System.out.println("----------------------------------------");
                switchUserMenuProfile(newOption, targetUser);
                break;
        }
    }

    public void editProfile(User targetUser) {
        System.out.println("---------------EditProfile--------------");
        System.out.println("1:Edit Username\n2:Edit Password\n3:Edit Email\n4:Edit PhoneNumber\n5:Back");
        switchEditProfile(sc.nextInt(), targetUser);

    }

    public void switchEditProfile(int option, User targetUser) {
        System.out.println("----------------------------------------");
        switch (option) {
            case 1:
                editUserUsername(targetUser);
                break;
            case 2:
                editUserPassword(targetUser);
                break;
            case 3:
                editUserEmail(targetUser);
                break;
            case 4:
                editUserPhoneNumber(targetUser);
                break;
            case 5:
                handleUserMenuProfile(targetUser);
                break;
            default:
                System.out.println("Number is not valid. Please try again :)");
                System.out.println("1:Edit Username\n2:Edit Password\n3:Edit Email\n4:Edit PhoneNumber\n5:Back");
                int newOption = sc.nextInt();
                switchEditProfile(newOption, targetUser);
                break;
        }
    }

    public void editUserUsername(User targetUser) {
        System.out.println("Please input your new Username!");
        String newUsername = sc.next();
        int userIndex = Main.users.indexOf(targetUser);
        Main.users.get(userIndex).setUsername(newUsername);
        System.out.println("Password has been changed successfully!");
        handleUserMenuProfile(Main.users.get(userIndex));
    }

    public void editUserPassword(User targetUser) {
        System.out.println("Please input your current password!");
        String testPassword = sc.next();
        if (targetUser.getPassword().equals(testPassword)) {
            System.out.println("----------------------------------------");
            System.out.println("Now, please input your new password :)");
            String newPassword = sc.next();
            System.out.println("----------------------------------------");
            boolean newPasswordCond = true;
            if (newPassword.length() < 8) {
                System.out.println("Password must contains at least 8 characters :(");
                newPasswordCond = false;
            }
            if (!new UserMenu().passwordCapitalSmallCheck(newPassword)) {
                System.out.println("Password must contains capital letters, small letters & also numbers :(");
                newPasswordCond = false;
            }
            if (newPasswordCond) {
                int userIndex = Main.users.indexOf(targetUser);
                Main.users.get(userIndex).setPassword(newPassword);
                System.out.println("Password has been changed successfully!");
                handleUserMenuProfile(Main.users.get(userIndex));

            } else {
                System.out.println("----------------------------------------");
                System.out.println("Edit password failed :(");
                editProfile(targetUser);
            }

        } else {
            System.out.println("Password is not correct. Please try again!");
            System.out.println("----------------------------------------");
            editUserPassword(targetUser);
        }
    }

    public void editUserEmail(User targetUser) {
        System.out.println("Please input your new Email!");
        String newEmail = sc.next();
        boolean newEmailCond = true;
        if (!(newEmail.matches(".+@gmail.com") || (newEmail.matches(".+@email.com")))) {
            System.out.println("----------------------------------------");
            System.out.println("Email is not valid :(");
            newEmailCond = false;
        }
        if (newEmailCond) {
            int userIndex = Main.users.indexOf(targetUser);
            Main.users.get(userIndex).setEmail(newEmail);
            System.out.println("----------------------------------------");
            System.out.println("Email has been changed successfully!");
            handleUserMenuProfile(Main.users.get(userIndex));
        } else {
            editUserEmail(targetUser);
        }
    }

    public void editUserPhoneNumber(User targetUser) {
        System.out.println("Please input your new phoneNumber!");
        String newPhoneNumber = sc.next();
        boolean newPhoneNumberCond = true;
        if (!newPhoneNumber.matches("09[0-9]{9}")) {
            System.out.println("----------------------------------------");
            System.out.println("Phone number is not valid :(. Please try again");
            newPhoneNumberCond = false;
        }
        if (newPhoneNumberCond) {
            int userIndex = Main.users.indexOf(targetUser);
            Main.users.get(userIndex).setPhoneNumber(newPhoneNumber);
            System.out.println("----------------------------------------");
            System.out.println("PhoneNumber has been changed successfully!");
            handleUserMenuProfile(Main.users.get(userIndex));
        } else {
            editUserPhoneNumber(targetUser);
        }
    }

    public void chargeWallet(User targetUser) {
        System.out.println("----------------------------------------");
        System.out.println("How much money do you want to charge?");
        double charge;
        charge = sc.nextDouble();
        int userIndex = Main.users.indexOf(targetUser);
        Main.users.get(userIndex).chargeWallet(charge);
        System.out.println("----------------------------------------");
        System.out.println("Wallet has been charged successfully!");
        handleUserMenuProfile(targetUser);
    }
}
