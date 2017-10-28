package ccw.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "ChangeSql")
public class ChangeSql extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Showmyself showmyself=new Showmyself();
        request.setAttribute("data",showmyself);
        String un=new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
        String pw=new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
        String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"utf-8");
        String birthday=new String(request.getParameter("birthday").getBytes("ISO-8859-1"),"utf-8");
        String national=new String(request.getParameter("national").getBytes("ISO-8859-1"),"utf-8");
        String xm=new String(request.getParameter("xm").getBytes("ISO-8859-1"),"utf-8");

        showmyself.Modify(un,pw,sex,birthday,national,xm);
        response.sendRedirect("introduce.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
