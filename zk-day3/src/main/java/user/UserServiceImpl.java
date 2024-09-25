package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.queryAll();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

//    @Override
//    public List<User> search(String keyword) {
//        List<User> result = new LinkedList<>();
//        List<User> userList = users.findAll();
//
//        if (keyword == null || "".equals(keyword)) {
//            result = userList;
//        } else {
//            for (User u : userList) {
//                if (u.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
//                    result.add(u);
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public void update(User updatedUser) {
//        users.findAll().stream()
//                .filter(user -> user.getId().equals(updatedUser.getId()))
//                .findFirst()
//                .ifPresent(existingUser -> {
//                    existingUser.setUsername(updatedUser.getUsername());
//                    existingUser.setGender((updatedUser.getGender()));
//                    existingUser.setBirthday(updatedUser.getBirthday());
//                    existingUser.setAge(updatedUser.getAge());
//                    existingUser.setProvince(updatedUser.getProvince());
//                    existingUser.setCity(updatedUser.getCity());
//                });
//    }

}
