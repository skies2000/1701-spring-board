package bean;

import org.apache.ibatis.session.SqlSession;

import myba.BoardFactor;

public class BoardDao {
	SqlSession session;
	public BoardDao(BoardFactor f){
		this.session = f.getFactory().openSession();
		 
	}
	
	@SuppressWarnings("finally")
	public String input(BoardVo vo){
		String msg = "";
		try {
			//sessiong은 마이바티스가 만들어준 객체이다. BoardDao의 생성자에서 얻어옴.
			int r = session.insert("board.brd_insert",vo);//첫번째는 힌트, 두번째는 mapping의 id
			
			if(r>0) msg="정상적으로 저장되었습니다.";
			else	msg="저장중 오류 발생";
					
		} catch (Exception e) {
			e.printStackTrace();
			msg = "시스템 오류~~~~";
			session.rollback();
		}finally{
			session.commit();
			return msg;
		}
		
	}
}
