package Medione.utils;

import Medione.pojo.User;

import javax.servlet.http.HttpSession;

public class BaseContext {
    private static ThreadLocal<HttpSession> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param session
     */
    public static void setCurrentSession(HttpSession session){
        threadLocal.set(session);
    }

    /**
     * 获取值
     * @return
     */
    public static HttpSession getCurrentSession(){
        return threadLocal.get();
    }

    public static User getCurrentUser(){
        User user = (User) threadLocal.get().getAttribute("user");
        return user;
    }
}