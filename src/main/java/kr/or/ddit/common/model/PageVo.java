package kr.or.ddit.common.model;

public class PageVo {
	
	private int page;
	private int pageSize;
	
	public PageVo() {}
	
	// controller에서 편하게 매개값 작성 가능
	public PageVo(int page, int pageSize){
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page == 0 ? 1 : page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize == 0 ? 5 : pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	


}
