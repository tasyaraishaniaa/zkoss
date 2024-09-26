package user;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
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
        userList = new ListModelList<>();
        userList.addAll(userService.getUsers());
    }

    @Command
    public void addUser() {
        User user = new User(username, gender, birthday, age, province, city);
        user = userService.addUser(user);
        userList.add(user);
        Executions.sendRedirect("user-detail-mvvm.zul");
    }

    @Command
    @NotifyChange("userList")
    public void deleteUser() {
        if (selectedUser == null)
            throw new RuntimeException("Please select user before delete");
        userService.deleteUser(selectedUser.getId());
        userList.remove(selectedUser);
        Executions.sendRedirect("user-detail-mvvm.zul");
    }

    @Command
    @NotifyChange({"userList", "selectedUser"})
    public void updateUser() {
        if (selectedUser == null)
            throw new RuntimeException("Please select user before update");
        userService.updateUser(selectedUser);
        Executions.sendRedirect("user-detail-mvvm.zul");
    }

    @Command
    @NotifyChange("userList")
    public void search() {
        selectedUser = null;
        userList.clear();
        userList.addAll(userService.search(keyword));
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

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

}
