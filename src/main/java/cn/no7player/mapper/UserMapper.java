package cn.no7player.mapper;

import cn.no7player.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
    public User findUserInfo();
    public User findByName(@Param("name")String name);
    public int insert(User user);
}
