package bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringBoardController {
	BoardDao dao;
	
	public SpringBoardController(BoardDao dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="board/inputR.do", method={RequestMethod.POST})
	public Object inputR(BoardVo vo){
		System.out.println("controller inputR");
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
