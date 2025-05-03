package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserMenuFriends {

    public static Scanner sc = new Scanner(System.in);

    public static void handleUserMenuFriends(User targetUser) {
        System.out.println("----------------Friends-----------------");
        System.out.println("1:Friends list\n2:Find friends\n3:Requests\n4:Back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                showFriendsList(targetUser);
                break;
            case 2:
                findFriends(targetUser);
                break;
            case 3:
                requestsMenu(targetUser);
                break;
            default:
                new UserMenu().signInUserMenu(targetUser);
                break;
        }
    }

    public static void showFriendsList(User targetUser) {
        System.out.println("----------------Friends List-----------------");
        if (targetUser.getUserFriends().isEmpty()) {
            System.out.println("Unfortunately you have no friends :(\n");
            System.out.println("You can add friends with finding them and request!");
            handleUserMenuFriends(targetUser);
        } else {
            for (int i = 0; i < targetUser.getUserFriends().size(); i++) {
                System.out.println("#" + (i + 1) + "\n" + targetUser.getUserFriendsName(i));
                System.out.println("----------------------------------------");
            }
            System.out.println("#0\nType \"0\" for going back");
            System.out.println("----------------------------------------");
            System.out.println("Please select one of your friends above:");
            int friendsIndex = sc.nextInt();
            if (friendsIndex == 0) {
                handleUserMenuFriends(targetUser);
            }
            showFriendDetails(targetUser, friendsIndex - 1);
        }
    }

    public static void showFriendDetails(User targetUser, int friendsIndex) {
        System.out.println("----------------------------------------");
        User friend = targetUser.getUserFriends().get(friendsIndex);
        System.out.println("# " + friend.getUsername());
        if (friend.getUserGames().isEmpty()) {
            System.out.println("\n" + friend.getUsername() + " doesn't have any games!");
            showFriendsList(targetUser);
        } else {
            for (int i = 0; i < friend.getUserGames().size(); i++) {
                System.out.println("#" + (i + 1));
                System.out.println(friend.getUserGamesName(i));
                System.out.println("----------------------------------------");
            }
            System.out.println("Type any key to going back:");
            String alaki = sc.next();
            showFriendsList(targetUser);
        }

    }

    public static void findFriends(User targetUser) {
        System.out.println("----------------Find Friends-----------------");
        System.out.println("Please type your friends username:");
        String friendUsername = sc.next();
        System.out.println("----------------------------------------");
        ArrayList<Integer> searchIndexes = new ArrayList<>();
        int regularCounter = 0;
        System.out.println("Search results:\n");
        for (User user : Main.users) {
            if (user.getUsername().equals(targetUser.getUsername())) {
                continue;
            }
            if (user.getUsername().toLowerCase().startsWith(friendUsername.toLowerCase())) {
                regularCounter++;
                searchIndexes.add(regularCounter - 1);
                System.out.println("#" + regularCounter + "  " + user.getUsername());
                System.out.println("----------------------------------------");
            }
        }
        if (searchIndexes.isEmpty()) {
            System.out.println("No username found!");
            handleUserMenuFriends(targetUser);
        }
        System.out.println("Please select one of the friends above:");
        int option = sc.nextInt() - 1;
        User targetFriend = Main.users.get(searchIndexes.get(option));
        System.out.println("Friend request sent to " + targetFriend.getUsername());
        targetFriend.addRequest(targetUser);
        handleUserMenuFriends(targetUser);
    }

    public static void requestsMenu(User targetUser) {
        System.out.println("----------------Requests-----------------");
        if (targetUser.getUserRequests().isEmpty()) {
            System.out.println("You have no requests!");
            handleUserMenuFriends(targetUser);
        } else {
            System.out.println("Friend requests!");
            for (int i = 0; i < targetUser.getUserRequests().size(); i++) {
                User requester = targetUser.getUserRequests().get(i);
                System.out.println("#" + (i + 1) + "\n" + requester.getUsername() +
                        " wants to be your friend!");
                System.out.println("----------------------------------------");
            }
            System.out.println("#0\nType \"0\" for going back");
            System.out.println("----------------------------------------");
            System.out.println("Please select one of the requests above:");
            int requesterIndex = sc.nextInt() - 1;
            System.out.println("----------------------------------------");
            User requesterUser = targetUser.getUserRequests().get(requesterIndex);
            acceptOrDenyRequest(targetUser, requesterUser);
        }
    }

    public static void acceptOrDenyRequest(User targetUser, User requesterUser) {
        System.out.println("What are you gonna do with " + requesterUser.getUsername() + " friend request?");
        System.out.println("1:Accept\n2:Deny\n3:Back");
        int option = sc.nextInt();
        System.out.println("----------------------------------------");
        switch (option) {
            case 1:
                requesterUser.addFriend(targetUser);
                targetUser.addFriend(requesterUser);
                targetUser.deleteRequester(requesterUser);
                System.out.println(requesterUser.getUsername() + " is now your friend :)");
                handleUserMenuFriends(targetUser);
                break;
            case 2:
                targetUser.deleteRequester(requesterUser);
                System.out.println("Request Denied!");
                handleUserMenuFriends(targetUser);
                break;
            default:
                handleUserMenuFriends(targetUser);
                break;
        }
    }
}
