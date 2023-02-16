package hae.basic.jsp;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import able.cloud.core.web.HController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dext5.DEXT5Handler;


/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 1.
 * @see
 */
@CrossOrigin(origins="*")
@Controller
public class JspController extends HController {
    
    @GetMapping("/{name}.html")
    public String page(@PathVariable String name,Model model){
        model.addAttribute("pageName",name);
        return "page";
    }
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
//    @RequestMapping(value = "/dext5editor", method = {RequestMethod.GET, RequestMethod.POST})
//    public void uploadHandler(HttpServletRequest request, HttpServletResponse response){
//        String _allowFileExt = "gif, jpg, jpeg, png, bmp, wmv, asf, swf, avi, mpg, mpeg, mp4, txt, doc, docx, xls, xlsx, ppt, pptx, hwp, zip, pdf,flv";
//        int upload_max_size = 2147483647;
//
//        // Servlet으로 handler 작업을 하시려면 다음과 같이 작성해 주세요.
//        // 만일 getServletContext()가 undefined 이면 request.getSession().getServletContext(); 으로 하시면 됩니다.
//        ServletContext application = request.getSession().getServletContext();
//        
//        DEXT5Handler DEXT5 = new DEXT5Handler();
//        
//        // 환경설정파일 물리적 폴더 (서버 환경변수를 사용할 경우)
////        DEXT5.SetConfigPhysicalPath("C:/dext5/config");
//
////        DEXT5.SetJpegQuality(100); // JPG 품질 (1 ~ 100)
//        // (저품질, 용량 축소) 1 ~ 100 (고품질, 용량 증가) - jdk 1.5 이상에서만 사용가능합니다.
////        DEXT5.SetAntialiasing(true); // 이미지 안티앨리어싱 활성화
//        
//        String[] allowUploadDirectoryPath = { request.getSession().getServletContext().getRealPath("/") };
//        DEXT5.SetAllowUploadDirectoryPath(allowUploadDirectoryPath);
//
//        try {
//            String result = DEXT5.DEXTProcess(request, response, application, _allowFileExt, upload_max_size);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//    }
    
    @RequestMapping("/dext5")
    public String dext5(HttpServletRequest request,Model model){
        return null;
    }

   
    
    
}
