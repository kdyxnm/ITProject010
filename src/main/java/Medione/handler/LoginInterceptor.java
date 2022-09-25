package Medione.handler;

import Medione.pojo.User;
import Medione.utils.BaseContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @ClassName LoginInterceptor
 * @Description Interceptor for login. Define cookie and behaviours.
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        response.addCookie(cookie);
        response.addHeader("Cookie","JSESSIONID="+request.getSession().getId());
        response.addHeader("Access-Control-Expose-Headers","Cookie");
        response.addHeader("Access-Control-Expose-Headers","Authorization");
        //Access-Control-Expose-Headers

        response.setHeader("Access-Control-Expose-Headers","Set-Cookie");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));//allow crossing origin
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");//5 request methods
        response.setHeader("Access-Control-Allow-Credentials", "true");//allow cookie crossing origin
        response.setHeader("Access-Control-Allow-Headers", "Set-Cookie,Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");//Origin, X-Requested-With, Content-Type, Accept,Access-Token
        HttpSession session =request.getSession();

        String username = (String) session.getAttribute("username");
        if(username==null){
//            response.sendRedirect("http://localhost:8080").;

//            request.getRequestDispatcher("http://localhost:8080")
//                    .forward(request,response)
            ;
            System.out.println("not yet login");

            return false;
        }

        System.out.println("already login");
        return true;
    }



}
