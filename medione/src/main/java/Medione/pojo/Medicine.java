package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.sql.Blob;

@Data
@TableName("medicine")
public class Medicine {
    private Long id;
    private String name;
    private Blob image;

    //private String ;

}
