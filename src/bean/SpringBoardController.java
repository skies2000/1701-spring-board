package bean;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
	String uploadPath = "C:/workspace2/1701-spring-board/WebContent/upload/";
	int maxSize = 1024*10000;
	String encoding = "utf-8";
	
	public SpringBoardController(BoardDao dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="input.do", method={RequestMethod.POST,RequestMethod.POST })
	public Object input(BoardVo vo, HttpServletRequest req){
		System.out.println("controller input....");
		ModelAndView mv = new ModelAndView();
			
			mv.setViewName("input");
			return mv;
		 
	}
	@RequestMapping(value="list.do", method={RequestMethod.POST,RequestMethod.POST})
	public Object list(BoardVo vo, HttpServletRequest req){
		System.out.println("controller list....");
		ModelAndView mv = new ModelAndView();
			
			mv.setViewName("list");
			return mv;
		 
	}
	
	
	
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value="inputR.do", method={RequestMethod.POST,RequestMethod.POST})
	public Object inputR(BoardVo vo, HttpServletRequest req){
		System.out.println("controller inputR....");
		ModelAndView mv = new ModelAndView();
		MultipartRequest mul = null;
		
		
		try {
			mul = new MultipartRequest(req,
					uploadPath,
					maxSize,
					encoding,
					new DefaultFileRenamePolicy());
			
			//泥⑤��뙆�씪�뿉 ���븳 �젙蹂대�� List媛앹껜�뿉 ���옣
			List<String> list = new ArrayList<String>();
			Enumeration<String>e = mul.getFileNames();
			while(e.hasMoreElements()){
				String tagName = e.nextElement();//�뤌�깭洹몄뿉 �깭洹몃궡�엫 ->fileName1, fileName2 �떇�쑝濡�
				if(mul.getFilesystemName(tagName)== null) continue;//留덉�留됱뿉 �뱾�뼱媛�吏� �븡�뒗 泥⑤��뙆�씪�� 嫄대꼫�쎍�떎.
				list.add(mul.getFilesystemName(tagName));//list�뿉 �뙆�씪紐낆씠 ���옣�맂�떎.
				
			}
			
			vo.setWorker(mul.getParameter("worker"));
			vo.setContent(mul.getParameter("content"));
			vo.setSubject(mul.getParameter("subject"));
			vo.setAttfile(list);
			
			String msg = dao.input(vo);
			mv.addObject("msg",msg);
			mv.setViewName("input_result");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return mv;
		}
		 
	}
}
