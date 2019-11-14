package lee.example.testspringboot.model;

import javax.persistence.Id;
import java.io.Serializable;

//因为表名和实体类名一样，无需@Table注解指定
public class SysUser implements Serializable {
    @Id
    private Long userId;
    private String userName;
    private String fullName;
    private String password;
    private String salt;

    //定义程序序列化ID,相当于身份认证，
    //主要用于程序的版本控制，保持不同版本的兼容性，在程序版本升级时避免程序报出版本不一致的错误
    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
