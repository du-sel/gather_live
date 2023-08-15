package model;

import java.util.HashMap;

public class Criteria {
	

    /* 검색 키워드 */
    private String keyword;
    
    /* 필터링 기준 */
    private HashMap<String, String> filter;
    
    
    
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public HashMap<String, String> getFilter() {
		return filter;
	}

	public void setFilter(HashMap<String, String> filter) {
		this.filter = filter;
	}
	
	
	private String getFilterString() {
		
		StringBuilder filterString = new StringBuilder();
		
		if(filter.get("loca_g1") != null && ((String)filter.get("loca_g1")).length() > 0) {
			
			filterString.append("AND member_id IN ");
			filterString.append("(SELECT DISTINCT member_id FROM member_loca WHERE ");
			filterString.append("g1='"+filter.get("loca_g1")+"' ");
			
			//g1도 있고 g2도 있다
			if(!((String)filter.get("loca_g2")).equals("전체")) {
				
				filterString.append("AND g2='"+filter.get("loca_g2")+"' ");

				if(filter.get("loca_g3") != null && !((String)filter.get("loca_g3")).equals("전체")) {
					
					filterString.append("AND g3='"+filter.get("loca_g3")+"' ");
				} 
				
			} 
			filterString.append(") ");
		}
		
		
		if(filter.get("inst_g1") != null) {
			filterString.append("AND member_id IN ");
			filterString.append("(SELECT DISTINCT member_id FROM member_inst WHERE ");				

			// 전체조회 
			if(((String)filter.get("instrument")).equals("전체")) {
				filterString.append("inst_name IN (SELECT name FROM final_inst WHERE g1='"+filter.get("inst_g1")+"'))");				
			}
			else {	
				filterString.append("inst_name='"+filter.get("instrument")+"') ");
			}
		}
		
		System.out.println("완성된 crit: "+filterString.toString());
		return filterString.toString();
	}

	@Override
	public String toString() {
		//return "Criteria [pageNum="+pageNum+", amount="+amount+"]";
		if(keyword != null) {
			return "";
		} 
		else if(filter != null) {
			return getFilterString();
		}
		else {
			return "";
		}
			
	}
	

}
