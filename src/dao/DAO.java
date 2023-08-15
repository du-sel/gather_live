package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.catalina.valves.JsonAccessLogValve;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DTO.Member;
import DTO.Member_Inst;
import DTO.Member_Loca;
import DTO.Recruit;
import DTO.Recruit_inst;
import model.Criteria;
import model.PageLimit;

public class DAO {
	
	
	DataSource ds;
	
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	
	// 악기 리스트 제이슨 반환
	public JSONArray getJSONInst() {
		JSONArray list = new JSONArray();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		String sql1 = "SELECT DISTINCT g1 FROM final_inst";
		
		PreparedStatement pstmt = null;
		ResultSet rs2 = null;
		String sql2 = "SELECT DISTINCT name FROM final_inst WHERE g1=?";

		
		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql2);
			
			rs1 = stmt.executeQuery(sql1);
			
			while(rs1.next()) {
				
				JSONObject block = new JSONObject();
				
				String g1 = rs1.getString("g1");
				block.put("g1", g1);
				
				
				pstmt.setString(1, g1);
				
				rs2 = pstmt.executeQuery();
				
				
				ArrayList<String> tmp = new ArrayList<>();
				
				while(rs2.next()) {
					String name = rs2.getString("name");
					tmp.add("'"+name+"'");
				}
				
				block.put("name", tmp);
				
				list.add(block);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs1 != null) rs1.close(); } catch(Exception e) { }
			try { if(rs2 != null) rs2.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		return list;
	}
	
	
	
	
	
	// 지역 리스트 제이슨 반환
	public JSONArray getJSONLoca() {
		JSONArray list = new JSONArray();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		String sql1 = "SELECT DISTINCT g1 FROM final_loca";
		
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		String sql2 = "SELECT DISTINCT g2 FROM final_loca WHERE g1=?";
		
		PreparedStatement pstmt3 = null;
		ResultSet rs3 = null;
		String sql3 = "SELECT DISTINCT g3 FROM final_loca WHERE g1=? AND g2=?";
		
		
		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			
			rs1 = stmt.executeQuery(sql1);
			
			while(rs1.next()) {
				
				JSONObject big = new JSONObject();
				
				String g1 = rs1.getString("g1");
				big.put("g1", g1);
				
				
				pstmt2.setString(1, g1);
				
				rs2 = pstmt2.executeQuery();
				
				
				ArrayList<JSONObject> midList = new ArrayList<>();
				
				while(rs2.next()) {
					JSONObject middle = new JSONObject();
					
					String g2 = rs2.getString("g2");
					middle.put("g2", g2);
					
					pstmt3.setString(1, g1);
					pstmt3.setString(2, g2);
					
					rs3 = pstmt3.executeQuery();
					
					ArrayList<String> smallList = new ArrayList<>();
					
					while(rs3.next()) {
						
						String g3 = rs3.getString("g3");
						
						smallList.add("'"+g3+"'");
					}
					
					middle.put("g3", smallList);
					
					midList.add(middle);
				}
				
				big.put("g2List", midList);
				
				list.add(big);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs1 != null) rs1.close(); } catch(Exception e) { }
			try { if(rs2 != null) rs2.close(); } catch(Exception e) { }
			try { if(rs3 != null) rs3.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(pstmt2 != null) pstmt2.close(); } catch(Exception e) { }
			try { if(pstmt3 != null) pstmt3.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		return list;
	}
	
	
	
	
	
	
	// 악기 리스트 해시맵 반환
	/*
	 * public HashMap<String, ArrayList<String>> getFinalInstMap() {
	 * 
	 * HashMap<String, ArrayList<String>> map = new HashMap<>();
	 * 
	 * Connection conn = null; Statement stmt = null; ResultSet rs1 = null; String
	 * sql1 = "SELECT DISTINCT g1 FROM final_inst";
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs2 = null; String sql2 =
	 * "SELECT DISTINCT name FROM final_inst WHERE g1=?";
	 * 
	 * 
	 * try {
	 * 
	 * conn = ds.getConnection(); stmt = conn.createStatement(); pstmt =
	 * conn.prepareStatement(sql2);
	 * 
	 * rs1 = stmt.executeQuery(sql1);
	 * 
	 * while(rs1.next()) { String g1 = rs1.getString("g1");
	 * 
	 * pstmt.setString(1, g1);
	 * 
	 * rs2 = pstmt.executeQuery(); ArrayList<String> list = new ArrayList<>();
	 * 
	 * while(rs2.next()) { list.add(rs2.getString("name")); }
	 * 
	 * map.put(g1, list); }
	 * 
	 * 
	 * } catch(Exception e) { e.printStackTrace(); } finally { try { if(rs1 != null)
	 * rs1.close(); } catch(Exception e) { } try { if(rs2 != null) rs2.close(); }
	 * catch(Exception e) { } try { if(stmt != null) stmt.close(); } catch(Exception
	 * e) { } try { if(pstmt != null) pstmt.close(); } catch(Exception e) { } try {
	 * if(conn != null) conn.close(); } catch(Exception e) { } }
	 * 
	 * 
	 * return map; }
	 */
	
	
	
	
	
	// 악기 대분류 리스트 반환
	public ArrayList<String> getFinalInst() {
		
		ArrayList<String> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT g1 FROM final_inst";
		

		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String g1 = rs.getString("g1");
				
				list.add(g1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		
		return list;
	}
	
	
	
	
	
	
	// 지역 대분류 리스트
	public ArrayList<String> getFinalLoca() {
		
		ArrayList<String> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT g1 FROM final_loca";
		

		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String g1 = rs.getString("g1");
				
				list.add(g1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	// member 테이블에 INSERT 
	public int insertMember(Member member) {
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(mail, password, user_name, cell, gender, birth, open, pref_genre, pref_musician, pref_music, pref_day, pref_time, hope, introduce, join_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE())";
		
		
		
		try { 
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUser_name());
			pstmt.setString(4, member.getCell());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getBirth());
			pstmt.setInt(7, member.getOpen());
			pstmt.setString(8, member.getPref_genre());
			pstmt.setString(9, member.getPref_musician());
			pstmt.setString(10, member.getPref_music());
			pstmt.setString(11, member.getPref_day());
			pstmt.setString(12, member.getPref_time());
			pstmt.setString(13, member.getHope());
			pstmt.setString(14, member.getIntroduce());


			res = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	
	
	// inst 테이블에 INSERT
	public int insertInst(Member_Inst inst) {
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member_inst VALUES(?, ?, ?, ?)";
		
		
		try { 
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inst.getMember_id());
			pstmt.setString(2, inst.getInst_name());
			pstmt.setString(3, inst.getInst_level());
			pstmt.setTimestamp(4, inst.getInst_time());


			res = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return res;
	}
	
	
	
	
	// loca 테이블에 INSERT
	public int insertLoca(Member_Loca loca) {
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member_loca VALUES(?, ?, ?, ?)";
		
		
		try { 
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, loca.getMember_id());
			pstmt.setString(2, loca.getG1());
			pstmt.setString(3, loca.getG2());
			pstmt.setString(4, loca.getG3());			
			
			res = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// id로 특정 멤버 검색 
	public Member getMemberByID(int id) {
		Member member = new Member();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setMember_id(id);
				member.setMail(rs.getString("mail"));
				member.setPassword(rs.getString("password"));
				member.setUser_name(rs.getString("user_name"));
				member.setCell(rs.getString("cell"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				// 프로필 이미지 어케할거임? 
				member.setOpen(rs.getInt("open"));
				member.setPref_genre(rs.getString("pref_genre"));
				member.setPref_musician(rs.getString("pref_musician"));
				member.setPref_music(rs.getString("pref_music"));
				member.setPref_day(rs.getString("pref_day"));
				member.setPref_time(rs.getString("pref_time"));
				member.setHope(rs.getString("hope"));
				member.setIntroduce(rs.getString("introduce"));
				member.setJoin_date(rs.getTimestamp("join_date"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return member;
	}
	
	
	
	// mail로 특정 멤버 검색 
	public Member getMemberByMail(String mail) {
		Member member = new Member();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE mail=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mail);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setMember_id(rs.getInt("member_id"));
				member.setMail(mail);
				member.setPassword(rs.getString("password"));
				member.setUser_name(rs.getString("user_name"));
				member.setCell(rs.getString("cell"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				// 프로필 이미지 어케할거임? 
				member.setOpen(rs.getInt("open"));
				member.setPref_genre(rs.getString("pref_genre"));
				member.setPref_musician(rs.getString("pref_musician"));
				member.setPref_music(rs.getString("pref_music"));
				member.setPref_day(rs.getString("pref_day"));
				member.setPref_time(rs.getString("pref_time"));
				member.setHope(rs.getString("hope"));
				member.setIntroduce(rs.getString("introduce"));
				member.setJoin_date(rs.getTimestamp("join_date"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return member;
	}
	
	
	
	// 마이 악기 리스트 
	public ArrayList<Member_Inst> getMyInst(Member member) {
		
		ArrayList<Member_Inst> list = new ArrayList<>();
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM my_inst WHERE member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member_Inst inst = new Member_Inst();
				inst.setMember_id(id);
				inst.setInst_name(rs.getString("inst_name"));
				inst.setInst_level(rs.getString("inst_level"));
				inst.setInst_time(rs.getTimestamp("inst_time"));
				

				int tmp = Integer.parseInt(rs.getString("month"));
				String month = null;
				int timeValue = 0;
				
				if(tmp < 3) {
					month = "3개월 미만";
					timeValue = 0;
				} else if(tmp >= 3 && tmp < 6) {
					month = "3개월~6개월";
					timeValue = 3;
				} else if(tmp >= 6 && tmp < 12) {
					month = "6개월~1년";
					timeValue = 6;
				} else if(tmp >= 12 && tmp < 36) {
					month = "1년~3년";
					timeValue = 12;
				} else if(tmp >= 36) {
					month = "3년 이상";
					timeValue = 36;
				}
				inst.setInst_month(month);
				inst.setInst_timeValue(timeValue);
				
				list.add(inst);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}

		return list;
	}
	
	
	
	// 마이 지역 리스트 
	public ArrayList<Member_Loca> getMyLoca(Member member) {
		
		ArrayList<Member_Loca> list = new ArrayList<>();
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member_loca WHERE member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member_Loca loca = new Member_Loca();
				loca.setMember_id(id);
				loca.setG1(rs.getString("g1"));
				loca.setG2(rs.getString("g2"));
				loca.setG3(rs.getString("g3"));			
				
				list.add(loca);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return list;
	}
	
	
	
	
	// 마이 나이계산 
	public String getMemberAge(Member member) {
		
		int id = member.getMember_id();
		String age = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT age FROM member_age WHERE member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("age") == null) {
					age = "비공개";
				} else {
					age = rs.getString("age");
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return age;
	}
	
	
	
	
	// 프로필 한번에 get
	public HashMap<String, Object> getProfile(Member member) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("MEMBER", member);
		map.put("AGE", getMemberAge(member));
		map.put("INSTLIST", getMyInst(member));
		map.put("LOCALIST", getMyLoca(member));
		
		return map;
	}
	
	
	
	
	
	
	
	// 프로필 검색 허용 회원만 get
	public ArrayList<HashMap<String, Object>> getOpenMembers() {
		
		ArrayList<HashMap<String, Object>> memberList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE open=1 ORDER BY join_date DESC";
		

		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setMember_id(rs.getInt("member_id"));
				member.setMail(rs.getString("mail"));
				member.setPassword(rs.getString("password"));
				member.setUser_name(rs.getString("user_name"));
				member.setCell(rs.getString("cell"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				// 프로필 이미지 어케할거임? 
				member.setOpen(rs.getInt(1));
				member.setPref_genre(rs.getString("pref_genre"));
				member.setPref_musician(rs.getString("pref_musician"));
				member.setPref_music(rs.getString("pref_music"));
				member.setPref_day(rs.getString("pref_day"));
				member.setPref_time(rs.getString("pref_time"));
				member.setHope(rs.getString("hope"));
				member.setIntroduce(rs.getString("introduce"));
				member.setJoin_date(rs.getTimestamp("join_date"));
				
				HashMap<String, Object> profile = getProfile(member);
				
				memberList.add(profile);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		
		return memberList;
	}
	
	
	
	
	// 프로필 리스트의 총 인원수만  get
	public int getOpenMembersTotal(Criteria cri) {
		
		int total = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT COUNT(*) FROM member WHERE open=1 "+cri.toString()+"ORDER BY member_id DESC ";
		
		
		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				total = rs.getInt(1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		return total;
	}
	
	
	
	
	
	
	// 프로필 리스트 get
	public ArrayList<HashMap<String, Object>> getPagedMembers(Criteria cri, PageLimit limit) {
			
		ArrayList<HashMap<String, Object>> memberList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT * FROM member WHERE open=1 "+cri.toString()+"ORDER BY member_id DESC "+limit.toString();
		

		try {
			
			conn = ds.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setMember_id(rs.getInt("member_id"));
				member.setMail(rs.getString("mail"));
				member.setPassword(rs.getString("password"));
				member.setUser_name(rs.getString("user_name"));
				member.setCell(rs.getString("cell"));
				member.setGender(rs.getString("gender"));
				member.setBirth(rs.getString("birth"));
				// 프로필 이미지 어케할거임? 
				member.setOpen(rs.getInt(1));
				member.setPref_genre(rs.getString("pref_genre"));
				member.setPref_musician(rs.getString("pref_musician"));
				member.setPref_music(rs.getString("pref_music"));
				member.setPref_day(rs.getString("pref_day"));
				member.setPref_time(rs.getString("pref_time"));
				member.setHope(rs.getString("hope"));
				member.setIntroduce(rs.getString("introduce"));
				member.setJoin_date(rs.getTimestamp("join_date"));
				
				HashMap<String, Object> profile = getProfile(member);
				
				memberList.add(profile);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(stmt != null) stmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
		}
		
		
		
		return memberList;
	
	
	}
	
	
	
	
	// 프로필 좋아요 추가
	public int addProfileLike(int fromID, int toID) {
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO like_profile VALUES(?, ?)";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fromID);
			pstmt.setInt(2, toID);
			
			res = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return res;
	}
	
	
	
	// 프로필 좋아요 해제
	public int removeProfileLike(int fromID, int toID) {
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM like_profile WHERE from_member_id=? AND to_member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fromID);
			pstmt.setInt(2, toID);
			
			res = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		return res;
	}
	
	
	
	
	
	
	
	// 비밀번호 변경
	public int updatePW(Member member) {
		
		int res = 0;
		
		int id = member.getMember_id();
		String pw_new = member.getPassword();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE member SET password=? WHERE member_id=?";
		
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw_new);
			pstmt.setInt(2, id);
			
			res = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}

		
		return res;
	}
	
	
	
	// 회원 탈퇴
	public int deleteAccount(Member member) {
		
		int res = 0;
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM member WHERE member_id=?";
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			res = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	// 계정정보 수정 
	public int updateMember(Member member) {

		int res = 0;
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE member SET user_name=?, birth=?, gender=?, cell=?, open=?, "
				+ "pref_genre=?, pref_musician=?, pref_music=?, pref_day=?, pref_time=?, hope=?, introduce=? WHERE member_id=?";
		
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUser_name());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getCell());
			pstmt.setInt(5, member.getOpen());
			pstmt.setString(6, member.getPref_genre());
			pstmt.setString(7, member.getPref_musician());
			pstmt.setString(8, member.getPref_music());
			pstmt.setString(9, member.getPref_day());
			pstmt.setString(10, member.getPref_time());
			pstmt.setString(11, member.getHope());
			pstmt.setString(12, member.getIntroduce());			
			pstmt.setInt(13, id);
			
			
			res = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	
	// 멤버별 지역리스트 비우기
	public int deleteMemberLoca(Member member) {

		int res = 0;
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM member_loca WHERE member_id=?";

		try {
			
			// 기존 지역 삭제 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			res = pstmt.executeUpdate();
			
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	
	
	// 멤버별 악기리스트 비우기
	public int deleteMemberInst(Member member) {
		
		int res = 0;
		
		int id = member.getMember_id();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM member_inst WHERE member_id=?";
		
		try {
			
			// 기존 지역 삭제 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			res = pstmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) { }
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	
	// 모집글 등록 
	public int insertRecruit(Recruit rcrt) {
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO recruit (title, duration, specDuration, already, otherinst, loca_g1, loca_g2, loca_g3, pref_datetime, free, created, created_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
		
		
		try { 
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcrt.getTitle());
			pstmt.setString(2, rcrt.getDuration());
			pstmt.setString(3, rcrt.getSpecDuration());
			pstmt.setString(4, rcrt.getAlready());			
			pstmt.setString(5, rcrt.getOtherinst());			
			pstmt.setString(6, rcrt.getLoca_g1());			
			pstmt.setString(7, rcrt.getLoca_g2());			
			pstmt.setString(8, rcrt.getLoca_g3());			
			pstmt.setString(9, rcrt.getPref_datetime());			
			pstmt.setString(10, rcrt.getFree());			
			pstmt.setInt(11, rcrt.getCreated_by());			

			res = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	// 모집글 악기 등록
	public int insertRecruitInst(Recruit_inst inst) {
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO recruit_inst VALUES(?, ?, ?)";
		
		
		try { 
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inst.getRecruit_post_id());
			pstmt.setString(2, inst.getInst_name());
			pstmt.setString(3, inst.getInst_level());
			
			res = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch(Exception e) { }
			try { if(conn != null) conn.close(); } catch(Exception e) { }
			
		}
		
		
		return res;
	}
	
	
	
	

}
