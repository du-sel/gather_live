package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member_Inst;
import DTO.Member_Loca;
import dao.DAO;

public class ProfileHandler implements CommonHandler {

	
	DAO dao;
	
	public ProfileHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}	
	
	
	

	@Override
	public String execute(HashMap<String, Object> map) {
		
		ArrayList<Member_Inst> instList = (ArrayList)map.get("INSTLIST");
		
		for(int i = 0; i<instList.size(); i++) {
			Member_Inst inst = instList.get(i);
			dao.insertInst(inst);
		}
		
		
		
		ArrayList<Member_Loca> locaList = (ArrayList)map.get("LOCALIST");
		
		for(int i = 0; i<locaList.size(); i++) {
			Member_Loca loca = locaList.get(i);
			dao.insertLoca(loca);
		}
		
		
		
		// redirect 직전에 세션 만료시키기 
		HttpSession session = (HttpSession)map.get("SESSION");
		session.invalidate();
		
		return "redirect:../join/welcome.do";
	}

}




