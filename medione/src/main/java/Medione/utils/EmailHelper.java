package Medione.utils;

import Medione.pojo.User;
import lombok.Data;

@Data
public class EmailHelper {
    private String password;
    private String username;
    private String nickname;
    private String email;
    private String code;

    public User getUser(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setEmail(email);
        return user;
    }
}
