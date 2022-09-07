package Medione.service.impl;

import Medione.service.ISendMailService;
import Medione.utils.R;
import Medione.utils.RandomCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

@Service
public class SendMailImpl implements ISendMailService {
    @Resource
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from ;
    //    @Value("${self.mail.test-mail}")
//    private String to = "zisu1@student.unimelb.edu.au";
    private String to = "570636077@qq.com";
    private String subject = "[Medione] verification mail";
    private String code;
    private String context = "Your verify code: ";
    private String context2 = "\n"+"Yours sincerely\n" +
            "\n" +
            "Medicine One\n" +
            "\n" +
            "This is a system generated email. Do not reply to this email address as we are unable to respond to enquiries sent to this address.";
    private HashMap<String, LocalTime> timer = new HashMap<>();
    private HashMap<String,String> codeMap = new HashMap<>();
    private final int EXCEED_TIME = 10;

    @Override
    public Boolean sendMail(String account) {
        // a easy cache
        code =  RandomCode.getRandom();
        LocalTime time = LocalTime.now();
        timer.put(account,time);
        codeMap.put(account,code);


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(medione)");
        mailMessage.setTo(account);
        mailMessage.setSubject(subject);
        mailMessage.setText(context+code+context2);
        //sending
        javaMailSender.send(mailMessage);
        System.out.println("sent out!");
        System.out.println("sent out!");
        System.out.println("sent out!");
        System.out.println(code);

        return true;
    }

    @Override
    public Boolean checkCode(String input, String account) {
        if (!codeMap.containsKey(account)){
            return false;
        }
        String localCode = codeMap.get(account);
        System.out.println(localCode);
        Boolean validity = Objects.equals(input, localCode);
        LocalTime sentTime = timer.get(account);
        int exceed = LocalTime.now().compareTo(sentTime.plusMinutes(EXCEED_TIME)); //
        if (validity && (exceed==-1)){
            codeMap.remove(account);
            timer.remove(account);
        }
        return validity&&(exceed==-1);
    }

    public String clearCache(){
        int count = 0;
        for (String account : timer.keySet()) {
            LocalTime sentTime = timer.get(account);
            int exceed = LocalTime.now().compareTo(sentTime.plusMinutes(EXCEED_TIME)); // =1 if expired
            if(exceed == -1){
                codeMap.remove(to);
                timer.remove(to);
                count +=1;
                System.out.println(LocalTime.now()+" "+count+ " verification expired");
            }
        }

        System.out.println(LocalTime.now()+"no verification expired");
        return "no verification expired";
    }
}
