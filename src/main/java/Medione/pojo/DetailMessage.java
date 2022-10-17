package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class DetailMessage {
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
    private String usage;
    private String warnings;
    private String contraindications;
    private String adversereaction;
    private String overdosage;
    private String username;
    private Integer locationid;
    private String note;
    private String location;

    public DetailMessage(Integer id, String brandname, String image, Integer quantity,
                         String validity, Integer dosage, String dosagetype,
                         String quantitytype, String manufacturername, String genericname,
                         String producttype, String route, String description, String usage,
                         String warnings, String contraindications, String adversereaction,
                         String overdosage, String username, Integer locationid, String note,
                         String location){

        this.id = id;
        this.brandname = brandname;
        this.image = image;
        this.quantity = quantity;
        this.validity = validity;
        this.dosage = dosage;
        this.dosagetype = dosagetype;
        this.quantitytype = quantitytype;
        this.manufacturername = manufacturername;
        this.genericname = genericname;
        this.producttype = producttype;
        this.route = route;
        this.description = description;
        this.usage = usage;
        this.warnings = warnings;
        this.contraindications = contraindications;
        this.adversereaction = adversereaction;
        this.overdosage = overdosage;
        this.username = username;
        this.locationid = locationid;
        this.note = note;
        this.location = location;
    }
}
