package ByUsingMysqldataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        User user1 = new User();
        user1.setUsername("lara_stack");
        user1.setEmail("lara.stack@example.com");
        userDAO.addUser(user1);

        User user2 = new User();
        user2.setUsername("jane_smith");
        user2.setEmail("jane.smith@example.com");
        userDAO.addUser(user2);

        User fetchedUser = userDAO.getUserById(1);
        System.out.println("User with ID 1: " + fetchedUser);

        List<User> allUsers = userDAO.getAllUsers();
        System.out.println("All Users: " + allUsers);

        user2.setUsername("jane.smith_updated");
        userDAO.updateUser(user2);

        fetchedUser = userDAO.getUserById(2);
        System.out.println("Updated User with ID 2: " + fetchedUser);

        userDAO.deleteUser(1);

        allUsers = userDAO.getAllUsers();
        System.out.println("All Users after deletion: " + allUsers);
    }
}

