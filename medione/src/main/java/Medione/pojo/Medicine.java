package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.ByteArrayInputStream;

@Data
@TableName("medicine")
public class Medicine {
    private Long id;
    private String name;
    private ByteArrayInputStream image;

    //private String ;

}
