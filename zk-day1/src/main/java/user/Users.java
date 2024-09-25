package user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {
    public static List<User> users = new ArrayList<>();

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            users.add(new User(
                    UUID.randomUUID().toString(),
                    "JohnDoe",
                    "Male",
                    sdf.parse("1990-01-01"),
                    34,
                    "Jakarta",
                    "Jakarta Pusat"
            ));
            users.add(new User(
                    UUID.randomUUID().toString(),
                    "JaneSmith",
                    "Female",
                    sdf.parse("1992-05-15"),
                    31,
                    "Jawa Barat",
                    "Bandung"
            ));
            users.add(new User(
                    UUID.randomUUID().toString(),
                    "MikeJohnson",
                    "Male",
                    sdf.parse("1985-09-30"),
                    38,
                    "Banten",
                    "Tangerang"
            ));
            users.add(new User(
                    UUID.randomUUID().toString(),
                    "EmilyDavis",
                    "Female",
                    sdf.parse("1988-12-22"),
                    35,
                    "Jakarta",
                    "Jakarta Barat"
            ));
            users.add(new User(
                    UUID.randomUUID().toString(),
                    "ChrisBrown",
                    "Male",
                    sdf.parse("1993-06-10"),
                    30,
                    "Jawa Barat",
                    "Tangerang Selatan"
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        return users;
    }

    public void delete(User selectedUser) {
        users.removeIf(user -> user.getId().equals(selectedUser.getId()));
    }

    public void add(User user) {
        users.add(user);
    }

}
