package Medione.utils;

import Medione.pojo.User;
import org.springframework.cache.annotation.Cacheable;

public class CacheUtils {

    @Cacheable(value = "cache", key="user")
    public String putSession(User user){

        return null;
    }
}
