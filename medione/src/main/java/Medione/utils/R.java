package Medione.utils;

import lombok.Data;

@Data
public class R<T> {
    Boolean flag = true;
    T data = null;

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(T data){
        this.data = data;
        if (data==null|| data.equals(false)){
            flag = false;
        }
    }


}