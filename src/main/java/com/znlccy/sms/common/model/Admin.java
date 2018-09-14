package com.znlccy.sms.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: Administrator
 * @Datetime: 2018/9/14-18:25
 * @Version: v1.0.0
 * @Comment: 管理员模型
 */

@Table(name = "tb_admin")
@Entity
public class Admin implements Serializable {

    /**
     * 声明用户主键
     */
    @Id
    @GeneratedValue
    @Column(name = "aid")
    private Integer aid;

    /**
     * 声明用户名称
     */
    @Column(name = "username",unique = true)
    private String username;

    /**
     * 声明用户真实姓名或昵称
     */
    @Column(name = "name")
    private String name;

    /**
     * 声明密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 声明加密的盐
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 声明用户状态
     */
    @Column(name = "state")
    private byte state;

    /**
     * 声明角色，多对多管理，立即加载
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_admin_role",joinColumns = {@JoinColumn(name = "aid")}, inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roleList;

    /**
     *
     * @return
     */
    public Integer getAid() {
        return aid;
    }

    /**
     *
     * @param aid
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getSalt() {
        return salt;
    }

    /**
     *
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     *
     * @return
     */
    public byte getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(byte state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     *
     * @param roleList
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
