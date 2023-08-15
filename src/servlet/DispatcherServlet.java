package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DTO.Member;
import DTO.Member_Inst;
import DTO.Member_Loca;
import DTO.Recruit;
import DTO.Recruit_inst;
import handler.CommonHandler;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		ServletContext context = this.getServletContext();
		resp.setContentType("text/html; charset=utf-8");
		
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("SESSION", req.getSession());
		
		
		String servletPath = req.getServletPath();
		//System.out.println("servletPath: "+servletPath);
		
		RequestDispatcher dispatcher = null;
		
		
		CommonHandler handler = (CommonHandler)context.getAttribute(servletPath);
		
		
		
		try {
			
			
			if(servletPath.equals("/join/email.do")) {
				
				if(req.getParameter("email") != null) {
					
					map.put("EMAIL", req.getParameter("email"));
				
				}
				
			}
			
			else if(servletPath.equals("/join/account.do")) {
				

				if(req.getParameter("pw") != null) {
					
					Member member = new Member();
					
					String email = (String)((HttpSession)map.get("SESSION")).getAttribute("EMAIL");
					member.setMail(email);
					member.setPassword(req.getParameter("pw"));
					member.setUser_name(req.getParameter("username"));
					member.setGender(req.getParameter("gender"));
					member.setCell(req.getParameter("cell"));
					if(req.getParameter("birth") != "") {
						member.setBirth(req.getParameter("birth"));
					} else {
						member.setBirth(null);
					}
					
					map.put("MEMBER", member);
				}
				
			}
			
			else if(servletPath.equals("/join/insert.do")) {
				
				if(req.getParameter("instrument1") != null) {
					
					Member member = (Member)((HttpSession)map.get("SESSION")).getAttribute("MEMBER");

					member.setOpen(Integer.parseInt(req.getParameter("open")));
					
					member.setPref_genre(req.getParameter("pref_genre"));
					member.setPref_musician(req.getParameter("pref_musician"));
					member.setPref_music(req.getParameter("pref_music"));
					member.setPref_day(req.getParameter("pref_day"));
					member.setPref_time(req.getParameter("pref_time"));
					member.setHope(req.getParameter("hope"));
					member.setIntroduce(req.getParameter("introduce"));
					
					map.put("MEMBER", member);
					map.put("CHK", "checked");
					
					
					// 악기목록 미리 저장해두기 
					int idxInst = Integer.parseInt(req.getParameter("idxInst"));
					
					ArrayList<Member_Inst> instList = new ArrayList<>();
					Calendar c = Calendar.getInstance();
					
					for(int i = 1; i<=idxInst; i++) {
						String name = "instrument"+i;
						String level = "level"+i;
						String time = "time"+i;
						
						int month = Integer.parseInt(req.getParameter(time));
						long ms = (long)month*30*24*60*60*1000;
						long now = c.getTimeInMillis();
						long start = now-ms;
						
						Member_Inst inst = new Member_Inst();

						inst.setInst_name(req.getParameter(name));
						inst.setInst_level(req.getParameter(level));
						inst.setInst_time(new Timestamp(start));
						
						instList.add(inst);
					}
					
					map.put("INSTLIST", instList);
					
					
					
					// 지역목록 미리 저장해두기 
					int idxLoca = Integer.parseInt(req.getParameter("idxLoca"));
					
					ArrayList<Member_Loca> locaList = new ArrayList<>();
					
					for(int i = 1; i<=idxLoca; i++) {
						String g1 = "location_g1_"+i;
						String g2 = "location_g2_"+i;
						String g3 = "location_g3_"+i;
						
						Member_Loca loca = new Member_Loca();
						
						loca.setG1(req.getParameter(g1));
						loca.setG2(req.getParameter(g2));
						loca.setG3(req.getParameter(g3));
						
						locaList.add(loca);
					}
					
					map.put("LOCALIST", locaList);
					

					
				}
				
			}
			
			else if(servletPath.equals("/join/prfl.do")) {

				HttpSession session = req.getSession();
				
				// 현재 작업중인 멤버의 아이디 
				Member member = (Member)session.getAttribute("MEMBER");
				int id = member.getMember_id();
				

				// 악기리스트에 멤버아이디 넣어주기 
				ArrayList<Member_Inst> instList = (ArrayList<Member_Inst>)session.getAttribute("INSTLIST");
				
				for(Member_Inst inst: instList) {
					inst.setMember_id(id);
				}
				
				map.put("INSTLIST", instList);
				
				
				
				// 지역리스트에 멤버아이디 넣어주기 
				ArrayList<Member_Loca> locaList = (ArrayList<Member_Loca>)session.getAttribute("LOCALIST");
				
				for(Member_Loca loca: locaList) {
					loca.setMember_id(id);
				}
				
				map.put("LOCALIST", locaList);
				
			}
			
			else if(servletPath.equals("/member/login.do")) {
				
				if(req.getParameter("email") != null) {			
					map.put("EMAIL", req.getParameter("email").trim());
					map.put("PW", req.getParameter("pw").trim());
				}

				
			}
			else if(servletPath.equals("/my/changePW.do")) {
				
				map.put("PW", req.getParameter("pw"));
				map.put("PW_NEW", req.getParameter("pw_new"));
				

			}
			else if(servletPath.equals("/my/prfl/account.do")) {
				
				HttpSession session = req.getSession();
				Member member = (Member)session.getAttribute("ACCOUNT");
				
				member.setUser_name(req.getParameter("username"));
				member.setBirth(req.getParameter("birth"));
				member.setGender(req.getParameter("gender"));
				member.setCell(req.getParameter("cell"));
				member.setOpen(Integer.parseInt(req.getParameter("open")));

				map.put("MEMBER", member);
				
				
			}
			else if(servletPath.equals("/my/prfl/location.do")) {
				
				HttpSession session = req.getSession();
				Member member = (Member)session.getAttribute("ACCOUNT");
				
				int idxLoca = Integer.parseInt(req.getParameter("idxLoca"));
				
				ArrayList<Member_Loca> locaList = new ArrayList<>();
				
				for(int i = 1; i<=idxLoca; i++) {
					String g1 = "location_g1_"+i;
					String g2 = "location_g2_"+i;
					String g3 = "location_g3_"+i;
					
					Member_Loca loca = new Member_Loca();
					
					loca.setMember_id(member.getMember_id());
					loca.setG1(req.getParameter(g1));
					loca.setG2(req.getParameter(g2));
					loca.setG3(req.getParameter(g3));
					
					locaList.add(loca);
				}
				
				map.put("LOCALIST", locaList);				
				
			}
			else if(servletPath.equals("/my/prfl/instrument.do")) {
				
				HttpSession session = req.getSession();
				Member member = (Member)session.getAttribute("ACCOUNT");
	
				int idxInst = Integer.parseInt(req.getParameter("idxInst"));
				
				ArrayList<Member_Inst> instList = new ArrayList<>();
				Calendar c = Calendar.getInstance();
				
				for(int i = 1; i<=idxInst; i++) {
					String name = "instrument"+i;
					String level = "level"+i;
					String time = "time"+i;
					
					int month = Integer.parseInt(req.getParameter(time));
					long ms = (long)month*30*24*60*60*1000;
					long now = c.getTimeInMillis();
					long start = now-ms;
					
					Member_Inst inst = new Member_Inst();
					
					inst.setMember_id(member.getMember_id());
					inst.setInst_name(req.getParameter(name));
					inst.setInst_level(req.getParameter(level));
					inst.setInst_time(new Timestamp(start));
					
					instList.add(inst);
				}
				
				map.put("INSTLIST", instList);		
				
			}
			else if(servletPath.equals("/my/prfl/pref.do")) {
				
				HttpSession session = req.getSession();
				Member member = (Member)session.getAttribute("ACCOUNT");
				
				member.setPref_genre(req.getParameter("pref_genre"));
				member.setPref_musician(req.getParameter("pref_musician"));
				member.setPref_music(req.getParameter("pref_music"));
				member.setPref_day(req.getParameter("pref_day"));
				member.setPref_time(req.getParameter("pref_time"));
				member.setHope(req.getParameter("hope"));
				member.setIntroduce(req.getParameter("introduce"));
				
				map.put("MEMBER", member);
				
			}
			else if(servletPath.equals("/prfl/list.do")) {
				
				String pNoStr = req.getParameter("pageNo");
				int pNo = 1;
				if(pNoStr != null) {
					pNo = Integer.parseInt(pNoStr);
				}
				
				map.put("PNO", pNo);


				if(req.getParameter("filterChk") != null) {					
					
					if(req.getParameter("filterChk").length() > 0) {
		
						HashMap<String, String> filter = new HashMap<>();
						filter.put("filterChk", "true");
										
						
						String g1 = req.getParameter("loca_g1");
						String g2 = req.getParameter("loca_g2");
						String g3 = req.getParameter("loca_g3");
						
						if(g1 != null && g1.length() > 0) {
							filter.put("loca_g1", g1);
							filter.put("loca_g2", g2);
							filter.put("loca_g3", g3);
						}
						
						
						String inst_g1 = req.getParameter("inst_g1");
						String instrument = req.getParameter("instrument");
						
						if(inst_g1 != null && inst_g1.length() > 0) {
		
							filter.put("inst_g1", inst_g1);
							filter.put("instrument", instrument);

						}
						
						map.put("FILTER", filter);
					}
				
				}
				
				
				
			}
			else if(servletPath.equals("/prfl/post.do")) {
				
				Set<String> params = req.getParameterMap().keySet();
				HashMap<String, String> filter = new HashMap<>();
				
				for(String key : params) {
					if(key.equals("pageNo") || key.equals("id")) {
						continue;
					}
					System.out.println("key: "+key);
					System.out.println("value: "+req.getParameterMap().get(key)[0]);
					filter.put(key, req.getParameterMap().get(key)[0]);
				}
				map.put("FILTER", filter);
				
				
				String pNoStr = req.getParameter("pageNo");
				int pNo = Integer.parseInt(pNoStr);
				map.put("PNO", pNo);
				
				int id = Integer.parseInt(req.getParameter("id"));
				map.put("ID", id);
				
			}
			else if(servletPath.equals("/prfl/like.do")) {
				
				int id = Integer.parseInt(req.getParameter("id"));
				map.put("toID", id);
				
				map.put("ACT", req.getParameter("act"));
				
			}
			
			else if(servletPath.equals("/rcrt/write.do")) {
				
				Recruit rcrt = new Recruit();
				
				rcrt.setTitle(req.getParameter("title"));
				rcrt.setDuration(req.getParameter("duration"));
				rcrt.setSpecDuration(req.getParameter("specDuration"));
				rcrt.setAlready(req.getParameter("already"));
				rcrt.setOtherinst(req.getParameter("otherinst"));
				rcrt.setLoca_g1(req.getParameter("loca_g1"));
				rcrt.setLoca_g2(req.getParameter("loca_g2"));
				rcrt.setLoca_g3(req.getParameter("loca_g3"));
				rcrt.setPref_datetime(req.getParameter("pref_datetime"));
				rcrt.setFree(req.getParameter("free"));

				
				
				
				int idxInst = Integer.parseInt(req.getParameter("idxInst"));
				
				ArrayList<Recruit_inst> instList = new ArrayList<>();
				
				for(int i = 1; i<=idxInst; i++) {
					String name = "instrument"+i;
					String level = "level"+i;
					
					Recruit_inst rcrtInst = new Recruit_inst();

					rcrtInst.setInst_name(req.getParameter(name));
					rcrtInst.setInst_level(req.getParameter(level));
					
					instList.add(rcrtInst);
				}
				
				rcrt.setInstList(instList);
				
				
				map.put("RECRUIT", rcrt);
				
			}
			

			// 이미지 업로드
//			else if(servletPath.equals("/admin/uploadAjaxAction.do")) {
				
//				Part part = req.getPart("prflPic");
//				System.out.println("part: "+part);	
				
				//Object obj = req.getParameter("prflPic");
				//System.out.println("obj: "+obj);	
			
				//System.out.println("파일 이름 : " + uploadFile.getOriginalFilename());
				//System.out.println("파일 타입 : " + uploadFile.getContentType());
				//System.out.println("파일 크기 : " + uploadFile.getSize());
				
//			}
			
			
		
			
			
			
			
			
			
			
			//System.out.println("핸들러: "+handler);
			String viewURL = handler.execute(map);
			//System.out.println("viewURL: "+viewURL);
			
			
			//System.out.println("***** req map 값 넣기 *****");
			for(String key : map.keySet()) {
				//System.out.println("key: "+key);
				//System.out.println("value: "+map.get(key));
				req.setAttribute(key, map.get(key));
			}
			
			
			
			if(viewURL.startsWith("redirect:")) {
				//System.out.println("substring: "+viewURL.substring(9));
				resp.sendRedirect(viewURL.substring(9));
				return;
			} else if(viewURL.startsWith("referer:")) {
				//System.out.println("리퍼러: "+req.getHeader("referer"));
				String refer = req.getHeader("referer")+viewURL.substring(8);
				resp.sendRedirect(refer);
				return;
			} else {
				
				dispatcher = req.getRequestDispatcher(viewURL);
				dispatcher.include(req, resp);
			}
		
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}
	
}
