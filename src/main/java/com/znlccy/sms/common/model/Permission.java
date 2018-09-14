package com.znlccy.sms.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: Administrator
 * @Datetime: 2018/9/14-18:34
 * @Version: v1.0.0
 * @Comment: 权限模型
 */

@Table(name = "tb_permission")
@Entity
public class Permission implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue
    @Column(name = "pid")
    private Integer pid;

    /**
     *
     */
    @Column(name = "name")
    private String name;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "url")
    private String url;

    @Column(name = "permission")
    private String permission;

    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "parentsIds")
    private String parentsIds;

    @Column(name = "available")
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name = "tb_role_permission", joinColumns = {@JoinColumn(name = "pid")}, inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roleList;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentsIds() {
        return parentsIds;
    }

    public void setParentsIds(String parentsIds) {
        this.parentsIds = parentsIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
