package cn.no7player.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangst
 * @create 2017-08-02 11:42
 */

public class Module {

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    private Integer mid;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    private String mname;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    private Set<Role> roles = new HashSet<>();

}
