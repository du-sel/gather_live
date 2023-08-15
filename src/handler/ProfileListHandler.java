package handler;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DTO.Member;
import dao.DAO;
import model.Criteria;
import model.ListPaging;
import model.PageLimit;

public class ProfileListHandler implements CommonHandler {

	
	DAO dao;
	
	public ProfileListHandler setDAO(DAO dao) {
		this.dao = dao;
		return this;
	}
	
	
	
	
	@Override
	public String execute(HashMap<String, Object> map) {
		
		HttpSession session = (HttpSession)map.get("SESSION");
		Member account = (Member)session.getAttribute("ACCOUNT");
		
		
		if(account == null) {		
			return "referer:?error=needLogin";
			
		} else {
		
			int pNo = (Integer)map.get("PNO");
			
			PageLimit limit = new PageLimit(pNo);	// 페이징
			Criteria cri = new Criteria();			// 필터링
			
			// 필터기준 set
			HashMap<String, String> filter = (HashMap<String, String>)map.get("FILTER");			
			cri.setFilter(filter);

			// 해당 페이지의 프로필리스트 가져오기
			ArrayList<HashMap<String, Object>> content = dao.getPagedMembers(cri, limit);
			
			
			
			ListPaging prflPaging = new ListPaging(dao.getOpenMembersTotal(cri), pNo, limit.getAmount(), content);
			
			session.setAttribute("PRFLPAGING", prflPaging);
			
			
			return "/code/02_prfl_list.jsp";
			
		}
	}

}
