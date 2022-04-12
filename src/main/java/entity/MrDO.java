package main.java.entity;

public class MrDO extends DO {
    private String MRno;
    private String Pno;
    private String Dno;
    private String disease;
    private String result;
    private String Treatment;

    public String getMRno() {
        return MRno;
    }

    public void setMRno(String MRno) {
        this.MRno = MRno;
    }

    public String getPno() {
        return Pno;
    }

    public void setPno(String pno) {
        Pno = pno;
    }

    public String getDno() {
        return Dno;
    }

    public void setDno(String dno) {
        Dno = dno;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }


}
