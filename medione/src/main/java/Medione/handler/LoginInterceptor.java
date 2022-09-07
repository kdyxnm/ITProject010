package Medione.handler;

import Medione.pojo.User;
import Medione.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String user = (String) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect("http://localhost:8081/html/User_login.html");
            //未登陆，返回登陆页面
//            request.setAttribute("msg","没有权限请先登陆");
//            request.getRequestDispatcher("http://localhost:8081/html/User_login.html")
//                    .forward(request,response)
            ;
            System.out.println("not yet login");

            return false;
        }
        System.out.println("already login");
        return true;
    }
}
