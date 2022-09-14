package Medione.controller;

import Medione.pojo.User;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Mail")
public class MailController {
    @Autowired
    private ISendMailService mailService;

    @Autowired
    private IUserService userService;


    @PostMapping("forget")
    public R<User> forgetPassword(HttpServletRequest request, @RequestBody User user){
        User target = userService.getByName(user.getUsername());
        mailService.sendMail(target.getEmail());

        return new R(user);
    }

    @PostMapping("check")
    public R<Object> checkValid(@RequestParam("code") String code,@RequestParam("account") String account ){

        return new R(mailService.checkCode(code, account));
    }
}
