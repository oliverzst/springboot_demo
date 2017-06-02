package cn.no7player.service;

import cn.no7player.mapper.UserMapper;
import cn.no7player.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

    public User findByName(String name){
        User user = userMapper.findByName(name);
        return user;
    }

    public void save(User user){
        userMapper.insert(user);
    }

}
