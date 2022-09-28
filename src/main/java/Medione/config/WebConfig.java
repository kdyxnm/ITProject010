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
 * @Description config for crossing origin and interceptor
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;



    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);


    /** crossing origin config
     * @param registry default CorsRegistry
     */
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            // allow path
            registry.addMapping("/**")
//                    .allowedOrigins("http://localhost:8080")
                    .allowedOrigins("https://medione.herokuapp.com")
                    .allowCredentials(true)
                    .allowedMethods("*")
                    .maxAge(3600);
            /*registry.addMapping("/**");*/
        }


    /** config about path to block
     * @param registry login interceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        block exclude/login  /register.....
//        block register for testing!
        registry.addInterceptor(loginInterceptor)
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
//                .excludePathPatterns("/generator/**")
//                .excludePathPatterns("/reset_password")
        ;


    }

}