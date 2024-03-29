package Medione.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @ClassName Location
 * @Description simple java class for location
 **/
@Data
@TableName("location")
public class Location {
    @TableId(value = "locationid", type = IdType.AUTO)
    private Integer locationid;
    private String email;
    private String address;
}
