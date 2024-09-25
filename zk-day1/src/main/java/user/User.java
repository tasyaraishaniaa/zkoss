package user;

import java.util.Date;
import java.util.UUID;

public class User {

    private String id;

    private String username;

    private String gender;

    private Date birthday;

    private Integer age;

    private String province;

    private String city;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String id, String username, String gender, Date birthday, Integer age, String province, String city) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.province = province;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}


