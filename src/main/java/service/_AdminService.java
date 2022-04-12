package main.java.service;

import main.java.entity.AdminDO;

public interface _AdminService {
    public boolean validateAdmin(AdminDO adminDo);//判定账号密码是否正确

    public void startservice();//开始连接服务
}
