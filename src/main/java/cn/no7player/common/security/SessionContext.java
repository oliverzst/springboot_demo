package cn.no7player.common.security;

import cn.no7player.common.redis.JedisUtils;
import cn.no7player.common.redis.RedisServiceImpl;
import cn.no7player.common.utils.ApplicationContextHelper;
import cn.no7player.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author zhangst
 * @create 2017-08-17 15:24
 */

public class SessionContext {

    private RedisServiceImpl redisService = ApplicationContextHelper.getBean(RedisServiceImpl.class);

    private static SessionContext instance;
    private HashMap<String,HttpSession> sessionMap;

    private SessionContext() {
        sessionMap = new HashMap<String,HttpSession>();
    }

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }
        return instance;
    }

    public synchronized void AddSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public synchronized void DelSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
            if(session.getAttribute("user")!=null){
                User user = (User) session.getAttribute("user");
                sessionMap.remove(user.getUid());
                //session.invalidate();
            }
        }
    }

    public synchronized HttpSession getSession(int session_id) {
//        if (session_id == null) return null;
        return (HttpSession) sessionMap.get(session_id);
    }

    public HashMap getSessionMap() {
        return sessionMap;
    }

    public void setMymap(HashMap sessionMap) {
        this.sessionMap = sessionMap;
    }

    public boolean sessionHandlerByCacheMap(HttpSession session){
        User user = (User) session.getAttribute("user");

        int userid= user.getUid();
        if(getSessionMap().get(userid)!=null){
            HttpSession oldsession = (HttpSession) getSessionMap().get(userid);
            //判断session是否过期
            if (isSessionExit(oldsession.getId())) {
                //没有过期
                //排除同个浏览器
                if (!oldsession.getId().equals(session.getId())) {
                    session.removeAttribute("user");
                    session.invalidate();
                }
                return false;
            } else {
                //过期
                getSessionMap().remove(userid);
                getSessionMap().put(userid,session);
                return true;
            }
//            HttpSession userSession=(HttpSession)getSessionMap().get(userid);
            //注销在线用户
//            if (!userSession.getId().equals(session.getId())) {
//                getSession(userid).removeAttribute("user");
//                getSession(userid).invalidate();
//            }
//            getSessionMap().remove(userid);
            //清除在线用户后，更新map,替换map sessionid
//            getSessionMap().remove(session.getId());
//            getSessionMap().put(userid,session);
        }
        else
        {
            // 根据当前sessionid 取session对象。 更新map key=用户名 value=session对象 删除map
//            getSessionMap().get(session.getId());
            getSessionMap().put(userid,session);
            return true;
//            getSessionMap().remove(session.getId());
        }
    }

    public boolean isSessionExit(String sessionid) {
        if (JedisUtils.exists("spring:session:sessions:"+sessionid)) return true;
        return false;
    }

}
