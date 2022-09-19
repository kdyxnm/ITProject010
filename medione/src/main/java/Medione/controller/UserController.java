package Medione.controller;


import Medione.pojo.Medicine;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import Medione.utils.CreateAccountError;
import Medione.utils.EmailHelper;
import Medione.utils.R;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;
import javax.lang.model.util.Elements;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private ISendMailService mailService;

    /**
     * @param helper a user object
     * @return creation result
     */
    @PostMapping("register")
    public R createAccount(@RequestBody EmailHelper helper, HttpServletRequest request){
        String email = helper.getEmail();
        String username = helper.getUsername();
        QueryWrapper<User> qUsername = new QueryWrapper<>();
        qUsername.eq("username",username);
        QueryWrapper<User> qEmail = new QueryWrapper<>();
        qEmail.eq("email",email);
        String codeInSession = (String) request.getSession().getAttribute("code");
        System.out.println("===================================");
        System.out.println(request.getSession().getId());
        System.out.println("In Session: "+codeInSession);
        System.out.println("input: "+helper.getCode());
        System.out.println("===================================");
        if (service.getOne(qUsername)!=null){
            return new R(CreateAccountError.USERNAME_EXIST);
        }

        else if (service.getOne(qEmail)!=null){
            return new R(CreateAccountError.EMAIL_EXIST);
        }

        else if (!helper.getCode().equals(codeInSession)){
            return new R(CreateAccountError.CODE_MISMATCH);
        }
        return new R(service.save(helper.getUser()));
    }


    @PostMapping("login")
    public R<User> Login(HttpServletRequest request,@RequestBody User user){
        System.out.println("===================================");
        System.out.println(request.getSession().getId());
        System.out.println("===================================");

        User target = service.getByName(user.getUsername());
        System.out.println("target: "+target);
        System.out.println("input: "+user);

        System.out.println("time used: "+ LocalTime.now());

        if (target == null ||    ( !target.getPassword().equals(user.getPassword()) )){
            return new R(404);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        BaseContext.setCurrentSession(session);    //String to Long
        return new R(target);
    }



    @DeleteMapping("log out")
    public R<User> LogOut(HttpServletRequest request,@RequestParam String username){
        request.getSession().invalidate();
        String target = "custom";
        return new R(200);
    }





}
