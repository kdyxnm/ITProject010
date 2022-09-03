package Medione.controller;


import Medione.pojo.Medicine;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.lang.model.util.Elements;

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
        return new R(service.save(user)&&mailService.checkCode(code));
    }

    @PostMapping("login")
    public User Login(@RequestBody User user){
        return user;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("get/{nickname}")
    public String Login2(@PathVariable String nickname){
        System.out.println(nickname);
        System.out.println(nickname+"login 2 success");
        return nickname+ " \nlogin 2 success";
    }


}
