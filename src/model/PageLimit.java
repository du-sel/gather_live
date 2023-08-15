package model;

public class PageLimit {

	// 한페이지에 보여줄 게시글 개수 고정값
	private int amount = 12;
	
	/* 현재 페이지 */
    private int pageNum;
    
    /* 스킵 할 게시물 수( (pageNum-1) * amount ) */
    private int skip;
    
    /* 기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 12 */
    public PageLimit() {
        this(1);
        this.skip = 0;
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public PageLimit(int pageNum) {
        this.pageNum = pageNum;
        this.skip = (pageNum-1)*amount;
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	/*
	 * public void setAmount(int amount) { this.skip = (this.pageNum-1)*amount;
	 * this.amount = amount; }
	 */
	
	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}
    
	
	
	@Override
	public String toString() {
		
		return "LIMIT "+skip+", "+amount;
			
	}
    
	
	
}
