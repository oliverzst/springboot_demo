package cn.no7player.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zl on 2015/8/27.
 */
public class User implements Serializable{
    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
