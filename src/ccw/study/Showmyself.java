package ccw.study;

import ccw.study.Sqllink;

import java.sql.ResultSet;
import java.util.Date;

import static java.lang.System.out;

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

    public String getPw() {
        return pw;
    }

    public void getInformation(String username) {
        Sqllink sqllink = new Sqllink("information");
        Sqllink sqllink2=new Sqllink("users");
        setUn(username);
        ResultSet rs = sqllink.getRs("select * from information where username='" + getUn() + "';");
        ResultSet rs2=sqllink2.getRs("select * from users where username='" + getUn() + "';");
        try {
            setSex(rs.getString(3));
            setBirthday(rs.getString(4));
            setNational(rs.getString(5));
            setXm(rs.getString(6));
            setPw(rs2.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqllink.close();
        }
    }

    public void Modify(String un,String pw,String sex,String birthday,String national,String xm){
        Sqllink sqllink = new Sqllink("information");
        Sqllink sqllink2=new Sqllink("users");
        boolean a=sqllink.Modify("update information set sex='"+sex+"',birthday='"+birthday+"',national='"+national+"',xm='"+xm+"' where username='"+un+"';");
        boolean b=sqllink2.Modify("update users set password='"+pw+"' where username='"+un+"';");
        if(a==true&&b==true)
        {
            out.print("修改成功");
        }
        else{
            out.print("修改失败");
        }
    }

}
