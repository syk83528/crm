package com.ipaozha.crm.utils;

import com.ipaozha.crm.constant.WebConst;
import com.ipaozha.crm.pojo.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class CrmUtils {

    /**
     * 返回当前登录用户
     *
     * @return
     */
    public static User getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (User) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }
    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param uid
     */
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            String val = uid + "_" + System.currentTimeMillis();
            boolean isSSL = false;
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, val);
            // 设置所有的路径都可以拿这个cookie
            cookie.setPath("/");
            //过期时间,单位秒
            cookie.setMaxAge(60);
            // 设置可以用http访问cookie
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出登录状态
     *
     * @param session
     * @param response
     */
    public static void logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
