package ccw.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName=request.getParameter("filename");
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        HttpSession session=request.getSession();
        String a=(String)session.getAttribute("username");
        String fileSaveRootPath="D:/jsp/big/web/netdisk/"+a;
        String path=fileSaveRootPath+"\\"+fileName;
        File file=new File(path);
        if(!file.exists()){
            System.out.println("无效资源");  //todo js提示
            return;
        }
        response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream in=new FileInputStream(path);
        OutputStream out=response.getOutputStream();
        byte buffer[]=new byte[1024];
        int len=0;
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
