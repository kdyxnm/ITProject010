package Medione.handler;

import Medione.pojo.User;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session =request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("http://localhost:8080/login");
            //未登陆，返回登陆页面
//            request.setAttribute("msg","没有权限请先登陆");
//            request.getRequestDispatcher("http://localhost:8081/html/User_login.html")
//                    .forward(request,response)
            ;
            System.out.println("not yet login");

            return false;
        }
        else {
            BaseContext.setCurrentSession(session);
        }
        System.out.println("already login");
        return true;
    }
}
