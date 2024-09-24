package user;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> userList = new LinkedList<User>();

    private int id = 1;

    public UserServiceImpl() {
        userList.add(
                new User(id++,
                        "JohnDoe",
                        "Male",
                        "1990-01-01",
                        34,
                        "California",
                        "Los Angeles"
                        ));
        userList.add(
                new User(id++,
                        "JaneSmith",
                        "Female",
                        "1992-05-15",
                        31,
                        "New York",
                        "New York City"
                ));
        userList.add(
                new User(id++,
                        "MikeJohnson",
                        "Male",
                        "1985-09-30",
                        38,
                        "Texas",
                        "Houston"
                ));
        userList.add(
                new User(id++,
                        "EmilyDavis",
                        "Female",
                        "1988-12-22",
                        35,
                        "Florida",
                        "Miami"
                ));
        userList.add(
                new User(id++,
                        "ChrisBrown",
                        "Male",
                        "1993-06-10",
                        30,
                        "Illonois",
                        "Chicago"
                ));
    }

    public List<User> findAll() {
        return userList;
    }

    public List<User> search(String keyword) {
        List<User> result = new LinkedList<User>();

        if (keyword == null || "".equals(keyword)) {
            result = userList;
        } else {
            for (User u : userList) {
                if (u.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(u);
                }
            }
        }
        return result;
    }
}
