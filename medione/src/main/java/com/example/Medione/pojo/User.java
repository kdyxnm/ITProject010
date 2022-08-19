package com.example.Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private int id;
    private String password;
    private int nickname;
}
