package cn.jomoon.factory.bean;

public class UserService {
    private  String id;

    private UserDao userDao;
    public void queryUserInfo() {
        System.out.println("query user info " + userDao.queryUserName(id));
    }
}
