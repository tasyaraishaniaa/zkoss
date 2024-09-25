package user;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private Users users = new Users();

    @Override
    public List<User> findAll() {
        return users.findAll();
    }

    @Override
    public List<User> search(String keyword) {
        List<User> result = new LinkedList<>();
        List<User> userList = users.findAll();

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

    @Override
    public void delete(User selectedUser) {
        users.delete(selectedUser);
    }

    @Override
    public void add(String username, String gender, Date birthday, Integer age, String province, String city) {
        User newUser = new User(UUID.randomUUID().toString(), username, gender, birthday, age, province, city);
        users.add(newUser);
    }

    @Override
    public void update(User updatedUser) {
        users.findAll().stream()
                .filter(user -> user.getId().equals(updatedUser.getId()))
                .findFirst()
                .ifPresent(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setGender((updatedUser.getGender()));
                    existingUser.setBirthday(updatedUser.getBirthday());
                    existingUser.setAge(updatedUser.getAge());
                    existingUser.setProvince(updatedUser.getProvince());
                    existingUser.setCity(updatedUser.getCity());
                });
    }

}
