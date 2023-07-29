import java.util.List;

public class UserDAOImpl implements UserDAO {
    private List<User> users; // In-memory list to store users

    public UserDAOImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void updateUser(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setUsername(user.getUsername());
                u.setEmail(user.getEmail());
                break;
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}