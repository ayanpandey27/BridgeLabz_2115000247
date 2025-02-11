class User {
    int userId;
    String name;
    int age;
    FriendNode friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friends = new FriendNode(userId2, user1.friends);
            user2.friends = new FriendNode(userId1, user2.friends);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        removeFriendFromList(userId1, userId2);
        removeFriendFromList(userId2, userId1);
    }

    private void removeFriendFromList(int userId, int friendId) {
        User user = findUser(userId);
        if (user == null || user.friends == null) return;
        if (user.friends.friendId == friendId) {
            user.friends = user.friends.next;
            return;
        }
        FriendNode temp = user.friends;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null || user.friends == null) {
            System.out.println("No friends found.");
            return;
        }
        FriendNode temp = user.friends;
        System.out.print("Friends of " + user.name + ": ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        SocialMedia network = new SocialMedia();
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 27);
        network.addUser(3, "Charlie", 22);
        
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        
        network.displayFriends(1);
        network.removeFriend(1, 2);
        network.displayFriends(1);
    }
}

