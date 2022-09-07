package com.example.Medione;

import Medione.pojo.User;
import Medione.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;


public class SessionTest {
    @Test
    void contextLoads() {
        User user = new User();
        user.setId(13);
        user.setNickname("adam");
        R r = new R<>(user);
        System.out.println(r);
    }


}
