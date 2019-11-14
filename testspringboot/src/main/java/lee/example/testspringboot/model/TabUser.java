package lee.example.testspringboot.model;

import javax.persistence.Id;
import javax.persistence.Table;

//类名与实体名一致不需要@Table注解
@Table(name = "tbl_user")
public class TabUser {
    /**
     * 主键上添加@Id注解，联合主键需要主键的每个属性上都加@Id。如果不加该注解，
     * 在使用xxxByPrimaryKey方法时，会把所有字段当成主键，
     * 即会出现where user_id=? and user_name=? and user_age=?这种条件
     */
    @Id
    private Long userId;
    private String userName;
    private Integer userAge;

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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

}
