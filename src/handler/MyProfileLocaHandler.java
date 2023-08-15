package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import DTO.Member_Loca;
import dao.DAO;

public class MyProfileLocaHandler implements CommonHandler {

	
	DAO dao;
	
	public MyProfileLocaHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	@Override
	public String execute(HashMap<String, Object> map) {

		// 기존 지역 삭제
		HttpSession session = (HttpSession)map.get("SESSION");
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		dao.deleteMemberLoca(account);
		

		// 새 지역 입력 
		ArrayList<Member_Loca> locaList = (ArrayList)map.get("LOCALIST");
		
		for(int i = 0; i<locaList.size(); i++) {
			Member_Loca loca = locaList.get(i);
			dao.insertLoca(loca);
		}
		
		
		return "redirect:../prfl.do?msg=ok";
	}

}
