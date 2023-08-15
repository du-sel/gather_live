package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import DTO.Member_Inst;
import dao.DAO;

public class MyProfileInstHandler implements CommonHandler {

	
	DAO dao;
	
	public MyProfileInstHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		// 기존 악기 삭제
		HttpSession session = (HttpSession)map.get("SESSION");
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		dao.deleteMemberInst(account);
		

		// 새 악기 입력 
		ArrayList<Member_Inst> instList = (ArrayList)map.get("INSTLIST");
		
		for(int i = 0; i<instList.size(); i++) {
			Member_Inst inst = instList.get(i);
			dao.insertInst(inst);
		}
		
				
		return "redirect:../prfl.do?msg=ok";
	}

}
