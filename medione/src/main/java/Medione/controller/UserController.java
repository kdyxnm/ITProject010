package Medione.controller;


import Medione.pojo.Medicine;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import Medione.utils.CreateAccountError;
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
     * @param user a user object
     * @return creation result
     */
    @PostMapping
    public R createAccount(@RequestBody User user, @PathVariable String code){
        String email = user.getEmail();
        String username = user.getUsername();
        QueryWrapper<User> qUsername = new QueryWrapper<>();
        qUsername.eq("username",username);

        QueryWrapper<User> qEmail = new QueryWrapper<>();
        qEmail.eq("email",email);

        if (service.getOne(qUsername)!=null){
            return new R(CreateAccountError.USERNAME_EXIST);
        }

        else if (service.getOne(qEmail)!=null){
            return new R(CreateAccountError.EMAIL_EXIST);
        }

        else if (mailService.checkCode(code, username)){
            return new R(CreateAccountError.CODE_MISMATCH);
        }
        return new R(service.save(user));
    }


    @PostMapping("login")
    public R<User> Login(HttpServletRequest request,@RequestBody User user){

        System.out.println("start time: "+LocalTime.now());
        HttpSession session = request.getSession();
        BaseContext.setCurrentId((long) session.getId().hashCode());    //String to Long
        session.setAttribute("username",user.getUsername());
        User target = service.getByName(user.getUsername());
        System.out.println("target: "+target);
        System.out.println("input: "+user);

        System.out.println("time used: "+ LocalTime.now());

        if (target == null ||    ( !target.getPassword().equals(user.getPassword()) )){
            return new R(404);
        }
        return new R(target);
    }



    @DeleteMapping("log out")
    public R<User> LogOut(HttpServletRequest request,@RequestParam String username){
        request.getSession().invalidate();
        String target = "custom";
        return new R(200);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get/{nickname}")
    public String Login2(HttpServletRequest request, HttpServletResponse response, @PathVariable String nickname){
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30);    //8*60*60s
        session.setAttribute("user","nickname");
        System.out.println(session.getId());
        System.out.println(nickname);
        System.out.println(nickname+"login 2 success");

        request.setAttribute("username",nickname);
        System.out.println("request attribute set! : " + request.getAttribute("username"));
        return nickname+ " \nlogin 2 success";
    }



    @GetMapping("get4/{nickname}")
    @Cacheable(value = "session", key ="#nickname")
    public String Login4(HttpServletRequest request, HttpServletResponse response, @PathVariable String nickname){
        HttpSession session = request.getSession();
        request.getSession(false);
        System.out.println(session.getId());

        Cache cache = new ConcurrentMapCache("session");
        System.out.println("cache get!" + cache.get(nickname));
        return nickname+ " \nlogin 2 success";
    }

    @GetMapping("get5/{nickname}")
    public String Login5(HttpServletRequest request, HttpServletResponse response, @PathVariable String nickname){

        return nickname+ " \nlogin 2 success";
    }


}
