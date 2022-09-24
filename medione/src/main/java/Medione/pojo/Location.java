package Medione.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @ClassName
 * @Description
 **/
@Data
@TableName("location")
public class Location {
    @TableId(value = "locationid", type = IdType.AUTO)
    private Integer locationid;
    private String email;
    private String address;
}
