package backend.services;

import backend.entities.User;

public interface UserManagementService {

    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

    User getUserByCredentials(String email, String password);

}
