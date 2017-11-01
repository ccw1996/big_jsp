package ccw.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactorServlet")
public class ContactorServlet extends HttpServlet {

    private ContactorService cs = new ContactorService();
    private String username;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int method = Integer.parseInt(request.getParameter("method"));
        switch(method){
            case 3: this.query(request, response);
                break;
            case 4: this.add(request, response);
                break;
            case 5: this.loadForUpdate(request, response);
                break;
            case 6: this.edit(request, response);
                break;
            case 7:    this.delete(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void query(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        //执行查询业务
        List<Contactor> list = cs.load(username);
        //将list存放到request域中
        request.setAttribute("contactorList", list);
        System.out.println(list.size());
        //通过请求转发将查询结果带到list.jsp页面上显示
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }

    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        Contactor c = CommonsUtils.toBean(request.getParameterMap(), Contactor.class);
        cs.add(c,username);
        response.sendRedirect("/ContactorServlet?method=3&userId="+username);
    }

    public void loadForUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ids = request.getParameter("id");
        int id = Integer.valueOf(ids);
        Contactor c = cs.loadById(id);
        request.setAttribute("contactor", c);
        request.getRequestDispatcher("/edit.jsp").forward(request, response);

    }

    public void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        Contactor c = CommonsUtils.toBean(request.getParameterMap(), Contactor.class);
        cs.edit(c,username);
        response.sendRedirect("/ContactorServlet?method=3&userId="+username);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        username = (String) session.getAttribute("username");
        String cid = request.getParameter("id");
        int id = Integer.valueOf(cid);
        cs.delete(id);
        response.sendRedirect("/ContactorServlet?method=3&userId="+username);
    }
}
