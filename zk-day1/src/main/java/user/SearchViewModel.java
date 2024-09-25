package user;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SearchViewModel {

    private String username;

    private String gender;

    private Date birthday;

    private Integer age;

    private String province;

    private String city;

    private String keyword;

    private List<User> userList = new ListModelList<>();

    private User selectedUser;

    private UserService userService = new UserServiceImpl();

    public SearchViewModel() {
        userList.addAll(userService.findAll());
    }

    @Command
    public void search() {
        userList.clear();
        userList.addAll(userService.search(keyword));
        System.out.println(userList);
        UUID.randomUUID().toString();
    }

    @Command
    public void delete() {
        if (selectedUser == null)
            throw new RuntimeException("Please select user before delete");
        userService.delete(selectedUser);
        userList.remove(selectedUser);
        selectedUser = null;
    }

    @Command
    @NotifyChange("userList")
    public void add() {
        userService.add(username, gender, birthday, age, province, city);
        Executions.sendRedirect("user-detail-mvvm.zul");
    }

    @Command
    @NotifyChange({"userList", "selectedUser"})
    public void update() {
        userService.update(selectedUser);
        Executions.sendRedirect("user-detail-mvvm.zul");
    }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getKeyword() { return keyword; }

    public List<User> getUserList() { return  userList; }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getSelectedUser() { return selectedUser; }

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

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
