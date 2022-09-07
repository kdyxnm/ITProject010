package Medione.service;

import Medione.utils.R;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


public interface ISendMailService  {
    Boolean sendMail(String account);

    Boolean checkCode(String code,String account);
}
