package Medione.controller;


import Medione.pojo.User;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import Medione.utils.CreateAccountError;
import Medione.utils.EmailHelper;
import Medione.utils.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @ClassName UserController
 * @Description API regarding user define here
 **/
//@CrossOrigin(origins = "http://localhost:8080/")
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
    public R createAccount(@RequestBody EmailHelper helper,HttpServletRequest request){
        System.out.println(request.getSession());
        System.out.println("register: " + Thread.currentThread().getId());
        String email = helper.getEmail();
        String username = helper.getUsername();
        QueryWrapper<User> qUsername = new QueryWrapper<>();
        qUsername.eq("username",username);
        QueryWrapper<User> qEmail = new QueryWrapper<>();
        qEmail.eq("email",email);
        String codeInSession = mailService.getCodeByAccount(email);
        System.out.println("===================================");
//        System.out.println(session.getId());
        System.out.println("===================================");
        if(helper.getUsername().contains("@")){
            return new R(CreateAccountError.USERNAME_INVALID);
        }
        if (service.getOne(qUsername)!=null){
            return new R(CreateAccountError.USERNAME_EXIST);
        }

        else if (service.getOne(qEmail)!=null){
            return new R(CreateAccountError.EMAIL_EXIST);
        }

        else if (!helper.getCode().equals(codeInSession)){
            return new R(CreateAccountError.CODE_MISMATCH);
        }
        service.save(helper.getUser());
        helper.getUser().setPassword(null);

        return new R(helper.getUser());
    }


    @PostMapping("login")
    public R<User> Login(@RequestBody User user, HttpServletRequest request){
        //log
        System.out.println("===================================");
        System.out.println(request.getSession());
        System.out.println("login: " + Thread.currentThread().getId());
        System.out.println("===================================");

        User target;
        if(!user.getUsername().contains("@")){
            target = service.getByName(user.getUsername());
        }
        else{
            target = service.getByEmail(user.getUsername());
        }

        System.out.println("target: "+target);
        System.out.println("input: "+user);


        if (target == null ||    ( !target.getPassword().equals(user.getPassword()) )){
            return new R(404);
        }
//        HttpSession session = request.getSession();
//        session.setAttribute("user",user);
        request.getSession().setAttribute("username",user.getUsername());
        BaseContext.setCurrentUser(user);    //set session in thread

        return new R(service.blockPassword(target));
    }


    @PostMapping("reset}")
    public R<User> resetPassword(HttpServletRequest request,EmailHelper helper){

        return new R(200);
    }


    @DeleteMapping("log out")
    public R<User> LogOut(HttpServletRequest request,@RequestParam String username){
        request.getSession().invalidate();
        String target = "custom";
        return new R(200);
    }







}
