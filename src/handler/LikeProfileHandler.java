package handler;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;

public class LikeProfileHandler implements CommonHandler {

	DAO dao;
	
	public LikeProfileHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		Member account = (Member)session.getAttribute("ACCOUNT");
		int fromID = account.getMember_id();
		int toID = (Integer)map.get("toID");

		String act = (String)map.get("ACT");
		
		
		// 좋아요 추가
		if(act.equals("on")) {
			
			dao.addProfileLike(fromID, toID);
			
		// 좋아요 해제
		} else {
			
			dao.removeProfileLike(fromID, toID);
			
		}	
		
		// 리턴 경로 생각해보기 
		return "referer:";
	}

}
