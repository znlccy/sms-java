package com.znlccy.sms.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: Administrator
 * @Datetime: 2018/9/14-18:27
 * @Version: v1.0.0
 * @Comment: 角色模型
 */

@Table(name = "tb_role")
@Entity
public class Role implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue
    @Column(name = "rid")
    private Integer rid;

    /**
     *
     */
    @Column(name = "role")
    private String role;

    /**
     *
     */
    @Column(name = "description")
    private String description;

    /**
     *
     */
    @Column(name = "available")
    private Boolean available = Boolean.FALSE;

    /**
     *
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Permission> permissionList;

    /**
     *
     */
    @ManyToMany
    @JoinTable(name = "tb_admin_role",joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "aid")})
    private List<Admin> adminList;

    /**
     *
     * @return
     */
    public Integer getRid() {
        return rid;
    }

    /**
     *
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     *
     * @param available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     *
     * @return
     */
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    /**
     *
     * @param permissionList
     */
    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    /**
     *
     * @return
     */
    public List<Admin> getAdminList() {
        return adminList;
    }

    /**
     *
     * @param adminList
     */
    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }
}
