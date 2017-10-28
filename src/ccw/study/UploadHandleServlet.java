package ccw.study;

import com.sun.javafx.applet.ExperimentalExtensions;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "UploadHandleServlet")
public class UploadHandleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String a=(String)session.getAttribute("username");
        String savePath="D:/jsp/big/web/WEB-INF/upload/"+a;
        File file=new File(savePath);
        if(!file.exists()&&!file.isDirectory()){
            System.out.println("目录不存在");
            file.mkdir();
        }
        try{
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            if(!ServletFileUpload.isMultipartContent(request)){
                return;
            }
            List<FileItem> list=upload.parseRequest(request);
            for (FileItem item:list){
                if(item.isFormField()){
                    String name=item.getFieldName();
                    String value=item.getString("UTF-8");
                    System.out.println(name+"="+value);
                }
                else{
                    String filename=item.getName();
                    System.out.println(filename);
                    if(filename==null||filename.trim().equals("")){
                        continue;
                    }
                    filename=filename.substring(filename.lastIndexOf("\\")+1);
                    InputStream in=item.getInputStream();
                    FileOutputStream out=new FileOutputStream(savePath+"\\"+filename);
                    byte buffer[]=new byte[1024];
                    int len=0;
                    while((len=in.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    System.out.println("成功");
                }
            }
        }catch (Exception e){
            System.out.println("失败");
            e.printStackTrace();
        }
        response.sendRedirect("filelist.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
