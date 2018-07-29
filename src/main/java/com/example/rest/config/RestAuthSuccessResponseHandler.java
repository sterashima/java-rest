package com.example.rest.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.Value;

@Component
public class RestAuthSuccessResponseHandler implements AuthenticationSuccessHandler {
 
    @Autowired
    MappingJackson2HttpMessageConverter httpMessageConverter;

    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response, 
        Authentication authentication) throws ServletException, IOException {
            SuccessResponce result = new SuccessResponce("Sucsess"); // JSONにするオブジェクト
            HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
            httpMessageConverter.write(result, MediaType.APPLICATION_JSON_UTF8, outputMessage);
            response.setStatus(HttpStatus.OK.value()); // 200 OK.
    }

    @Value
    public static class SuccessResponce {
        private final String message;
    }
}