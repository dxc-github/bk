package com.dxc.blog.interceptor;

import com.dxc.blog.result.ResultBuilder;
import com.dxc.blog.result.StatusCode;
import com.dxc.blog.utils.JwtHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private JwtHelper jwtHelper =new JwtHelper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("--------------------拦截前-----------------");
        //解决乱码返回接口中文乱码问题
        response.setContentType("application/json;charset=UTF-8");
        String jsonWebToken = request.getHeader("Authorization").substring(7);
        logger.info(jsonWebToken);
        String tokenResultvalidate = jwtHelper.validateLogin(jsonWebToken);
        PrintWriter out = null;
        if(StringUtils.isNotEmpty(tokenResultvalidate)){
            return true;
        }else {
            out = response.getWriter();
            out.append(new ResultBuilder<String>(StatusCode.TOKEN_ERROR).toString());
            //throw new RuntimeException("token验证失败");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("--------------------进入拦截-----------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("--------------------拦截结束-----------------");
    }
}
