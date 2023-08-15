package handler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Member;
import DTO.Member_Inst;
import DTO.Member_Loca;
import dao.DAO;

public class InsertHandler implements CommonHandler {
	
	DAO dao;
	
	public InsertHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	



	@Override
	public String execute(HashMap<String, Object> map) {
	
		Member member = (Member)map.get("MEMBER");

		
		// 확인 메세지가 오지 않았다면 악기폼을 거치지 않았다는 의미임 
		if(map.get("CHK") == null) {

			return "/code/05_join_3.jsp";
			
		} else {
				
			dao.insertMember(member);

			
			HttpSession session = (HttpSession)map.get("SESSION");
			Member last = dao.getMemberByMail(member.getMail());
			session.setAttribute("MEMBER", last);
			
			
			ArrayList<Member_Inst> instList = (ArrayList<Member_Inst>)map.get("INSTLIST");
			session.setAttribute("INSTLIST", instList);
			
			ArrayList<Member_Loca> locaList = (ArrayList<Member_Loca>)map.get("LOCALIST");
			session.setAttribute("LOCALIST", locaList);
			

			return "redirect:../join/prfl.do";
		}
	}
	
	
	
	

}
