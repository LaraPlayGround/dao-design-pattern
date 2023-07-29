import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test the DAO pattern implementation
        testDAO();
    }

    private static void testDAO() {
        // Create an in-memory list to store users
        List<User> users = new ArrayList<>();

        // Create an instance of the UserDAOImpl
        UserDAO userDAO = new UserDAOImpl(users);

        // Test the DAO operations
        User user1 = new User(1, "john_doe", "john.doe@example.com");
        User user2 = new User(2, "jane_smith", "jane.smith@example.com");

        userDAO.addUser(user1);
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
