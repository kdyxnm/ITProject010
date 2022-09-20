package Medione.config;

import Medione.handler.LoginInterceptor;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
//    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
//

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    //解决跨域问题
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            System.out.println("我是MyWebConfig跨域");
            // 设置允许跨域的路径
            registry.addMapping("/**")
                    // 设置允许跨域请求的域名
                    .allowedOrigins("http://localhost:8080")
                    // 是否允许证书，不再默认开启
                    .allowCredentials(true)
                    // 设置允许的方法
                    .allowedMethods("*")
                    // 跨域允许时间
                    .maxAge(3600);
            /*registry.addMapping("/**");*/
        }


    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        block exclude/login  /register.....
//        block register for testing!
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/user/**")
//                .excludePathPatterns("/medicine/**")
//                .excludePathPatterns("/dashboard/**")
//                .excludePathPatterns("/dashboard")
//                .excludePathPatterns("/register")
//                .excludePathPatterns("/about")
//                .excludePathPatterns("/mail")
//                .excludePathPatterns("/mail/**")
//                .excludePathPatterns("/reset_password")
        ;


    }

}