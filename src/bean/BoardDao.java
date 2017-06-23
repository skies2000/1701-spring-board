package bean;

import org.apache.ibatis.session.SqlSession;

import myba.BoardFactor;

public class BoardDao {
	SqlSession session;
	public BoardDao(BoardFactor f){
		this.session = f.getFactory().openSession();
		
	}
	
}
