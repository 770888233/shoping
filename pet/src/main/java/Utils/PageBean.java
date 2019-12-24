package Utils;

import java.util.List;

public class PageBean<T> {
	private int page;//第几页
	private int totlePage;//一共多少页
	private int limitPage;//每页多少个
	private List<T> list;//目标集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getLimitPage() {
		return limitPage;
	}
	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String toString() {
		return "PageBean [page=" + page + ", totlePage=" + totlePage
				+ ", limitPage=" + limitPage + ", list=" + list + "]";
	}
}
