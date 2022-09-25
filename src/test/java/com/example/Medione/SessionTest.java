package com.example.Medione;

import Medione.pojo.User;
import Medione.utils.R;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionTest {
    @Test
    void contextLoads() {
        User user = new User();;
        user.setNickname("adam");
        R r = new R<>(user);
        System.out.println(r);
    }

    @Test
    void mul(){
        HttpSession session = null;
        System.out.println(session.getId());
        System.out.println(session.getId());
        System.out.println(session.getId());
    }


}
