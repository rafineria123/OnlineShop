package backend.services.implementations;

import backend.entities.User;
import backend.services.UserManagementService;

import java.util.Arrays;
import java.util.Objects;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;

    private static DefaultUserManagementService instance;

    private User[] users;

    private int lastIndex;

    {
        initUserManagementService();
    }

    @Override
    public String registerUser(User user) {
        if(user == null || user.getEmail().isEmpty()) return EMPTY_EMAIL_ERROR_MESSAGE;
        if(Arrays.stream(users).filter(u -> u.getEmail().equalsIgnoreCase(user.getEmail())).findFirst().isPresent()) return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        if (users.length <= lastIndex) {
            users = Arrays.copyOf(users, users.length << 1);
        }
        users[lastIndex++] = user;
        return NO_ERROR_MESSAGE;
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }


    @Override
    public User[] getUsers() {
        return Arrays.stream(users).filter(Objects::nonNull).toArray(User[]::new);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        var user = Arrays.stream(users).filter(u -> u.getEmail() == userEmail).findFirst();
        return user.isPresent()?user.get():null;
    }

    void clearServiceState() {
        initUserManagementService();
    }

    void initUserManagementService(){
        users = new User[DEFAULT_USERS_CAPACITY];
        lastIndex = 0;
    }
}
