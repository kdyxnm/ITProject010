package Medione.controller;

import Medione.pojo.User;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.prefs.BackingStoreException;


/**
 * @ClassName MailController
 * @Description API regarding mail define here
 **/
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private ISendMailService mailService;

    @Autowired
    private IUserService userService;


    @PostMapping("send")
    public R<User> send(HttpSession session, @RequestBody User user){
        if (!user.getEmail().contains("@")  ){
            return new R<>(404,"invalid email");
        }

        if(mailService.sendMail(user.getEmail())!=null ){
            return new R<>(200,"email is sent!");
        }

        return new R<>(404);
    }



//    @PostMapping("check")
//    public R<Object> checkValid(@RequestParam("code") String code,@RequestParam("account") String account ){
//
//        return new R(mailService.checkCode(code, account));
//    }
}
