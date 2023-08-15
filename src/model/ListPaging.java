package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ListPaging {

	private int total;
	private int currentPage;
	private ArrayList<HashMap<String, Object>> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	
	public ListPaging(int total, int currentPage, int amount, ArrayList<HashMap<String, Object>> content) {
		
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			
			totalPages = total/amount;
			
			if(total%amount > 0) {
				totalPages++;
			}
			
			int modVal = currentPage%5;
			startPage = currentPage/5*5 +1;
			if(modVal == 0) {
				startPage -= 5;
			}
			
			endPage = startPage + 4;
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			
		}
	}
			
		
	public int getTotal() {
		return total;
	}
		
	
	
	public boolean hasNoPost() {
		return total==0;
	}
	
	
	public boolean hasPost( ) {
		return total>0;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}


	public ArrayList<HashMap<String, Object>> getContent() {
		return content;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}
	
	
	
	
	
	
	
	
}
