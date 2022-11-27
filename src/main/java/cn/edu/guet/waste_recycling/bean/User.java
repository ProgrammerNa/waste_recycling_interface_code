package cn.edu.guet.waste_recycling.bean;

import java.util.List;
import java.util.Objects;

/**
 * @author HHS
 */
public class User extends BaseModel {

    private String name;
    private List<Role> role;
    private String nickName;
    private String avatar;
    private String password;
    private String email;
    private String mobile;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status && Objects.equals(name, user.name) && Objects.equals(role, user.role) && Objects.equals(nickName, user.nickName) && Objects.equals(avatar, user.avatar) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(mobile, user.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, nickName, avatar, password, email, mobile, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                '}';
    }
}
