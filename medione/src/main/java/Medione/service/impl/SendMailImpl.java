package Medione.service.impl;

import Medione.service.ISendMailService;
import Medione.utils.R;
import Medione.utils.RandomCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

@Service
public class SendMailImpl implements ISendMailService {
    @Resource
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from ;
    private String to;
    private String subject = "[Medione] verification mail";
    private String code;
    private String context = "Your verify code: ";
    private String context2 = "\n"+"Yours sincerely\n" +
            "\n" +
            "Medicine One\n" +
            "\n" +
            "This is a system generated email. Do not reply to this email address as we are unable to respond to enquiries sent to this address.";
    private final int EXCEED_TIME = 10;

    @Override
    //@CachePut(value="mail",key="#account")
    public String sendMail( String account, HttpSession session) {
        code =  RandomCode.getRandom();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(medione)");
        mailMessage.setTo(account);
        mailMessage.setSubject(subject);
        mailMessage.setText(context+code+context2);
        //sending
        session.setAttribute("code",code);
        try{
        javaMailSender.send(mailMessage);
        }
        catch (Exception e){
            return null;
        }

        System.out.println("sent out!");
        System.out.println("sent out!");
        System.out.println("sent out!");
        System.out.println(code);

        return code;
    }
//
//    @Override
//    public Boolean checkCode(String input, HttpSession session) {
//        String code = (String) session.getAttribute("code");
//      return (input.equals(code));
//    }

    @Cacheable(value = "mail",key = "#account" )
    public String getCodeByAccount(String account){
        return null;
    }
//    public String clearCache(){
//        int count = 0;
//        for (String account : timer.keySet()) {
//            LocalTime sentTime = timer.get(account);
//            int exceed = LocalTime.now().compareTo(sentTime.plusMinutes(EXCEED_TIME)); // =1 if expired
//            if(exceed == -1){
//                codeMap.remove(to);
//                timer.remove(to);
//                count +=1;
//                System.out.println(LocalTime.now()+" "+count+ " verification expired");
//            }
//        }
//
//        System.out.println(LocalTime.now()+"no verification expired");
//        return "no verification expired";
//    }
}
