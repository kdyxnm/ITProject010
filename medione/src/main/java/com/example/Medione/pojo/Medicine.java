package com.example.Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("medicine")
public class Medicine {
    private Long id;
    private String name;
    //private String ;

}
