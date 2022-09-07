package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.servlet.http.HttpSession;

@Data
@TableName("user")
public class User {
    private int id;
    private String password;
    private String username;
    private String nickname;
    private String email;
}
