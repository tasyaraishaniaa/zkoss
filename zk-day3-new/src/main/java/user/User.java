package user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "User")
public class User implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    Date birthday;

    @Column(nullable = false)
    Integer age;

    @Column(nullable = false)
    String province;

    @Column(nullable = false)
    String city;

    public User() {

    }

    public User(String username, String gender, Date birthday, Integer age, String province, String city) {
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.province = province;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}


