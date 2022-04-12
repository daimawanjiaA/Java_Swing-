package main.java.entity;

public class DoctorDO extends DO {
    private String Dno;
    private String Dname;
    private String Dphone;
    private String Oname;
    private String Password;

    public String getDno() {
        return Dno;
    }

    public void setDno(String dno) {
        Dno = dno;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDphone() {
        return Dphone;
    }

    public void setDphone(String dphone) {
        Dphone = dphone;
    }

    public String getOname() {
        return Oname;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
