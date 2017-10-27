package ccw.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/introduce")
public class introduce extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Login login=new Login();
        request.setAttribute("data",login);
        String un=request.getParameter("username");
        String pw=request.getParameter("password");
        Sqllink sqllink=new Sqllink("users");
        if(sqllink.check(un,pw)){
            System.out.println("登陆成功");      //todo 用js的方式弹出
            response.sendRedirect("introduce.jsp");
        }
        else
        {
            System.out.println("登陆失败");    //todo 如上
            response.sendRedirect("index.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
