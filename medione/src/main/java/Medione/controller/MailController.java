package Medione.controller;

import Medione.service.ISendMailService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MailController {
    @Autowired
    private ISendMailService service;


    /**send verification mail to the given account
     * @param account register email account
     * @return result class contain true if mail is sent successful and false if fail
     */
    @GetMapping("{account}")
    public R sendVerificationMail(@PathVariable String account){

        return new R<>(service.sendMail(account));
    }

}
