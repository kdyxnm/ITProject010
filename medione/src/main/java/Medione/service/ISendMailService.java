package Medione.service;

import Medione.utils.R;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


public interface ISendMailService  {
    String sendMail(String account, HttpSession session);

//    Boolean checkCode(String input, HttpSession session);
}
