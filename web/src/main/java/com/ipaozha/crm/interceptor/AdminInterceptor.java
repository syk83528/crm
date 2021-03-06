package com.ipaozha.crm.interceptor;

import com.ipaozha.crm.pojo.User;
import com.ipaozha.crm.utils.CrmUtils;
import com.ipaozha.crm.utils.IPKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private  String baseImg = "/upload";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String uri = request.getRequestURI();
        // 这里传过去basePath的一些参数
        request.getSession().setAttribute("base", "");
        request.getSession().setAttribute("baseImg", baseImg);

//        log.info(String.valueOf(request.getSession().getMaxInactiveInterval()));
        log.info("UserAgent: {}", request.getHeader("user-agent"));
        log.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));
        //请求拦截处理
        User user = CrmUtils.getLoginUser(request);
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == user
                && !uri.startsWith("/admin/css") && !uri.startsWith("/admin/images")
                && !uri.startsWith("/admin/js")) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        //先在这里存一下user
        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
