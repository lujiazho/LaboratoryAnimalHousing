package org.lah.Commons.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a>
 * @author 肖文吉	36750064@qq.com
 * @version V1.0
 */
public class User implements Serializable {

    private Integer id;			// id
    private String username;	// 用户名
    private String loginname;	// 登录名
    private String department;  // 部门
    private String position;    // 职位
    private String password;	// 密码
    private Integer status;		// 状态
    private String phone;       // 电话
    private Date createDate;	// 建档日期
    // 无参数构造器
    public User() {
        super();
    }
    // setter和getter方法
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginname='" + loginname + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
