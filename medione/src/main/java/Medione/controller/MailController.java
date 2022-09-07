package Medione.controller;

import Medione.service.ISendMailService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Mail")
public class MailController {
    @Autowired
    private ISendMailService service;


    /**send verification mail to the given account
     * @param account register email account
     * @return result class contain true if mail is sent successful and false if fail
     */
    @GetMapping("send/{account}")
    public R sendVerificationMail(@PathVariable String account){

        return new R<>(service.sendMail(account));
    }

    @PostMapping("check")
    public Boolean checkValid(@RequestParam("code") String code,@RequestParam("account") String account ){

        return service.checkCode(code, account);
    }
}
