package main.java.service;

import main.java.entity.DoctorDO;

public interface _DoctorService {
    void retrieveDoctors();//

    boolean validateDoctor(DoctorDO doctorDO);//判断账号密码是否成功

    public void startservice();//开始连接服务
}
