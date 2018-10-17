package com.ipaozha.crm.utils;

import com.ipaozha.crm.constant.WebConst;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class CrmUtils {
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
}
