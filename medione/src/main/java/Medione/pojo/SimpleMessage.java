package Medione.pojo;

import lombok.Data;
/**
 * @ClassName
 * @Description
 **/
@Data
public class SimpleMessage {
    private Integer id;
    private String brandname;
    private Integer locationid;


    public SimpleMessage(Integer id, String brandname, Integer locationid){
        this.brandname = brandname;
        this.id = id;
        this.locationid =locationid;
    }
}
