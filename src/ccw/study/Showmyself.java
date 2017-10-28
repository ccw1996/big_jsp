package ccw.study;

import ccw.study.Sqllink;

import java.sql.ResultSet;

public class Showmyself {
    private String un;
    private String sex;
    private String birthday;
    private String national;
    private String xm;
    private String pw;

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void getInformation(String username) {
        Sqllink sqllink = new Sqllink("information");
        setUn(username);
        ResultSet rs = sqllink.getRs("select * from information where username='" + getUn() + "';");
        try {
            setSex(rs.getString(3));
            setBirthday(rs.getString(4));
            setNational(rs.getString(5));
            setXm(rs.getString(6));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqllink.close();
        }
    }


}
