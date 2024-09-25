package user;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getUsers();

    void deleteUser(User user);

}
