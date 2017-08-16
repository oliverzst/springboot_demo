package cn.no7player.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangst
 * @create 2017-08-02 11:39
 */

public class Role {
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    private Integer rid;

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    private String rname;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    private Set<User> users = new HashSet<>();

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    private Set<Module> modules = new HashSet<>();
}
