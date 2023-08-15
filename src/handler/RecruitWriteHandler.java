package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import DTO.Recruit;
import DTO.Recruit_inst;
import dao.DAO;

public class RecruitWriteHandler implements CommonHandler {

	
	DAO dao;
	
	public RecruitWriteHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		Recruit rcrt = (Recruit)map.get("RECRUIT");
		
		if(rcrt.getTitle() == null) {
			return "/code/01_rcrt_write.jsp";
		}
		else {
			
			int id = ((Member)session.getAttribute("ACCOUNT")).getMember_id();
			rcrt.setCreated_by(id);
			
			int res = dao.insertRecruit(rcrt);
			
			if(res > 0) {
				
				ArrayList<Recruit_inst> instList = rcrt.getInstList();
				for(int i = 0; i<instList.size(); i++) {
					Recruit_inst rcrtInst = instList.get(i);
					dao.insertRecruitInst(rcrtInst);
				}
			}
			
			return "redirect:../code/01_rcrt_list.jsp";
		}		
	}

}
