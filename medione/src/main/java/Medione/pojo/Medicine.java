package Medione.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Date;

@Data
@TableName("medicine")
public class Medicine {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String brandname;
    private String image;
    private Integer quantity;
    private String validity;
    private Integer dosage;
    private String dosagetype;
    private String quantitytype;
    private String manufacturername;
    private String genericname;
    private String producttype;
    private String route;
    private String description;
    @TableField(value = "`usage`")
    private String usage;
    private String warnings;
    private String contraindications;
    private String adversereaction;
    private String overdosage;
    private String username;
    private Integer locationid;




}
