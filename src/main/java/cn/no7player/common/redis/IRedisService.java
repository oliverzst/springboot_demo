package cn.no7player.common.redis;

import java.util.List;

/**
 * redis常用操作
 *
 * @author zhangst
 * @create 2017-08-10 14:46
 */

public interface IRedisService {

    public boolean set(String key, String value);

    public String getString(String key);

    public boolean expire(String key,long expire);

    public <T> boolean setList(String key ,List<T> list);

    public <T> List<T> getList(String key,Class<T> clz);

    public long lpush(String key,Object obj);

    public long rpush(String key,Object obj);

    public String lpop(String key);

}

