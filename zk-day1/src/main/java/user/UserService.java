package user;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> search(String keyword);

    void delete(User selectedUser);

    void add(String username, String gender, Date birthday, Integer age, String province, String city);

    void update(User selectedUser);

}
