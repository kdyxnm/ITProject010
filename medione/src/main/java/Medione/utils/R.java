package Medione.utils;

import lombok.Data;

@Data
public class R<T> {
    int status = 200;
    T data = null;

    public R(int status){
        this.status = status;
    }

    public R(T data){
        this.data = data;
        if (data==null|| data.equals(false)){
            status = 404;
        }
    }


}