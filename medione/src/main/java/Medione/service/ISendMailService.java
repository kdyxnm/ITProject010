package Medione.service;

import Medione.utils.R;
import org.springframework.stereotype.Service;

@Service
public interface ISendMailService {
    Boolean sendMail(String account);

    Boolean checkCode(String code);
}
