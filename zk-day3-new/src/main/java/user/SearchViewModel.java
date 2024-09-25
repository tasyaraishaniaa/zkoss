package user;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel {

    @WireVariable
    private UserService userService;

    private List<User> userList;
    private String username;
    private String gender;
    private Date birthday;
    private Integer age;
    private String province;
    private String city;
    private String keyword;
    private User selectedUser;

    @Init
    public void init() {
//        userList = new ListModelList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            userService.addUser(new User(
//                    "JohnDoe",
//                    "Male",
//                    sdf.parse("1990-01-01"),
//                    34,
//                    "Jakarta",
//                    "Jakarta Pusat"
//            ));
//            userService.addUser(new User(
//                    "JaneSmith",
//                    "Female",
//                    sdf.parse("1992-05-15"),
//                    31,
//                    "Jawa Barat",
//                    "Bandung"
//            ));
//            userService.addUser(new User(
//                    "MikeJohnson",
//                    "Male",
//                    sdf.parse("1985-09-30"),
//                    38,
//                    "Banten",
//                    "Tangerang"
//            ));
//            userService.addUser(new User(
//                    "EmilyDavis",
//                    "Female",
//                    sdf.parse("1988-12-22"),
//                    35,
//                    "Jakarta",
//                    "Jakarta Barat"
//            ));
//            userService.addUser(new User(
//                    "ChrisBrown",
//                    "Male",
//                    sdf.parse("1993-06-10"),
//                    30,
//                    "Jawa Barat",
//                    "Tangerang Selatan"
//            ));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        userList.addAll(userService.getUsers());
        userList = new ListModelList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Adding sample users
            userService.addUser(new User("JohnDoe", "Male", sdf.parse("1990-01-01"), 34, "Jakarta", "Jakarta Pusat"));
            // Add more users...
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userList.addAll(userService.getUsers());
    }

    public List<User> getUserListModel() { return userList; }

    @Command
    public void addUser() {
        User user = new User(username, gender, birthday, age, province, city);
        user = userService.addUser(user);
        userList.add(user);
    }

    @Command
    public void deleteUser(@BindingParam("user") User user) {
        userService.deleteUser(selectedUser);
        userList.remove(selectedUser);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

//    public void setUserListModel(ListModelList<User> userListModel) {
//        this.userListModel = userListModel;
//    }

    //    public SearchViewModel() {
//        userList.addAll(userService.findAll());
//    }
//
//    @Command
//    public void search() {
//        userList.clear();
//        userList.addAll(userService.search(keyword));
//        System.out.println(userList);
////        UUID.randomUUID().toString();
//    }
//
//    @Command
//    public void delete() {
//        if (selectedUser == null)
//            throw new RuntimeException("Please select user before delete");
//        userService.delete(selectedUser);
//        userList.remove(selectedUser);
//        selectedUser = null;
//    }
//
//    @Command
//    @NotifyChange("userList")
//    public void add() {
//        userService.add(username, gender, birthday, age, province, city);
//        Executions.sendRedirect("user-detail-mvvm.zul");
//    }
//
//    @Command
//    @NotifyChange({"userList", "selectedUser"})
//    public void update() {
//        userService.update(selectedUser);
//        Executions.sendRedirect("user-detail-mvvm.zul");
//    }

}
