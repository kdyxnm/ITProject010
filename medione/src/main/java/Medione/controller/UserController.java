package Medione.controller;


import Medione.pojo.Medicine;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.ISendMailService;
import Medione.service.IUserService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
