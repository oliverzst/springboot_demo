package cn.no7player.common.security;

import cn.no7player.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author zhangst
 * @create 2017-08-15 10:56
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null==user){
            response.sendRedirect("login");
            flag = false;
        } else{
            flag = true;
        }
        return flag;
    }

//    public void handlerSession(HttpServletRequest request) {
//        String sessionId = request.getHeader(SESSION_KEY);
//        if(org.apache.commons.lang3.StringUtils.isBlank(sessionId)){
//            sessionId=(String) request.getSession().getAttribute(SESSION_KEY);
//        }
//        if (org.apache.commons.lang3.StringUtils.isNotBlank(sessionId)) {
//            SessionData model = (SessionData) redisUtils.get(SESSION_KEY_PREFIX+sessionId);
//            if (model == null) {
//                return ;
//            }
//            request.setAttribute(SESSION_KEY,sessionId);
//            Integer userCode = model.getUserCode();
//            if (userCode != null) {
//                request.setAttribute(USER_CODE_SESSION_KEY, Long.valueOf(userCode));
//            }
//            String mobile = model.getMobileNumber();
//            if (mobile != null) {
//                request.setAttribute(MOBILE_NUMBER_SESSION_KEY, mobile);
//            }
//        }
//        return ;
//    }

}
