package bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class SpringBoardController {
	BoardDao dao;
	String uploadPath = "C:/workspace/1701-spring-board/WebContent/upload/";
	int maxSize = 1024*1000;
	String encoding = "utf-8";
	
	public SpringBoardController(BoardDao dao){
		this.dao = dao;
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="board/inputR.do", method={RequestMethod.POST})
	public Object inputR(BoardVo vo, HttpServletRequest req){
		System.out.println("controller inputR");
		ModelAndView mv = new ModelAndView();
		MultipartRequest mul = null;
		
		try {
			mul = new MultipartRequest(req,
					uploadPath,
					maxSize,
					encoding,
					new DefaultFileRenamePolicy());
			
			mv.setViewName("input_result");
		} catch (Exception e) {
			
		}finally{
			return mv;
		}
		 
	}
}
