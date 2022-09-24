package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.servlet.http.HttpSession;
/**
 * @ClassName User
 * @Description simple java class for user
 **/
@Data
@TableName("user")
public class User {
    private String password;
    private String username;
    private String nickname;
    private String email;
}
