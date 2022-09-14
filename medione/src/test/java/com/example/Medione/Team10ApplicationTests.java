package com.example.Medione;

import Medione.pojo.User;
import Medione.utils.CreateAccountError;
import Medione.utils.R;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Team10ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void RTest(){
        User user = new User();
        user.setNickname("adam");
        R r = new R<>(user);
        System.out.println(r);
    }


}
