package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "username")
    private String username;
    private String nickname;
    private String email;
}
