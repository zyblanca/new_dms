package com.example.dms.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouy
 * @date 2023/1/5
 * good 01
 */
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {



    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = request.getHeader("authorization");
        if (StringUtils.hasText(token) || token.startsWith("Basic")){
            throw new Exception("sls");
        }
        new ObjectMapper().

    }
}
