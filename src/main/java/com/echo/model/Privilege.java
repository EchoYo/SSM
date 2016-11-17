package com.echo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:权限</p>
 * Created by Echoj on 2016-06-13.
 */
public class Privilege implements Serializable {
    private String privilegeId;
    private String name;//权限名称
    private String url;
    private String parentId;
    private String spanClass;
    private List<Privilege> privileges = new ArrayList<Privilege>();//所有下级权限

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSpanClass() {
        return spanClass;
    }

    public void setSpanClass(String spanClass) {
        this.spanClass = spanClass;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        if (!privilegeId.equals(privilege.privilegeId)) return false;
        if (!name.equals(privilege.name)) return false;
        if (!url.equals(privilege.url)) return false;
        if (!parentId.equals(privilege.parentId)) return false;
        return spanClass.equals(privilege.spanClass);

    }

    @Override
    public int hashCode() {
        int result = privilegeId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + parentId.hashCode();
        result = 31 * result + spanClass.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilegeId='" + privilegeId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", parentId='" + parentId + '\'' +
                ", spanClass='" + spanClass + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
