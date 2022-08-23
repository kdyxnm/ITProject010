package Medione.controller;


import Medione.pojo.Medicine;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.IUserService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;


    /**
     * @param user a user object
     * @return creation result
     */
    @PostMapping
    public R createAccount(@RequestBody User user){
        return new R(service.save(user));
    }



}
