package Medione.controller;

import Medione.pojo.User;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private ISendMailService mailService;

    @Autowired
    private IUserService userService;


    @PostMapping("send")
    public R<User> send(HttpServletRequest request, @RequestBody User user){


        if(mailService.sendMail(user.getEmail(), request.getSession())!=null){
            return new R(200);
        }

        return new R(404);
    }

//    @PostMapping("check")
//    public R<Object> checkValid(@RequestParam("code") String code,@RequestParam("account") String account ){
//
//        return new R(mailService.checkCode(code, account));
//    }
}
