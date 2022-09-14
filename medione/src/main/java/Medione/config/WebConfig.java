package Medione.config;

import Medione.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMvcConfig
 * @Description
 * @Date 2021/12/17 9:23
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

//    @Override
//    public  void addCorsMappings(CorsRegistry registry){
//        //loc 8081
//        registry.addMapping("/**").allowedOrigins("http://192.168.254.11:8080");
//
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        block exclude/login  /register.....
//        block register for testing!
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/html/Register.html")
                //.addPathPatterns("/**")
                .excludePathPatterns("/html/User_login.html")
                //.excludePathPatterns("/register")
        ;


    }

}