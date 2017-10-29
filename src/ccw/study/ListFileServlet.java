package ccw.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ListFileServlet")
public class ListFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String a=(String)session.getAttribute("username");
        String savePath="D:/jsp/big/web/netdisk/"+a;
        File file=new File(savePath);
        if(!file.exists()&&!file.isDirectory()){
            System.out.println("目录不存在");
            file.mkdir();
        }
        Map<String,String> fileNameMap = new HashMap<String,String>();
        listfile(new File(savePath),fileNameMap);
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/filelist.jsp").forward(request, response);
    }
    public void listfile(File file,Map<String,String> map){
        if(!file.isFile()) {
            File files[] = file.listFiles();
            for (File f : files) {
                listfile(f, map);
            }
        }else
        {
            map.put(file.getName(),file.getName());
        }
    }
}
