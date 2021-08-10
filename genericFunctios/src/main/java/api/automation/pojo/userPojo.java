package api.automation.pojo;

import java.util.Map;

import com.google.gson.Gson;

public class userPojo {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	public data data;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public data getData() {
		return data;
	}
	public void setData(data data) {
		this.data = data;
	}
	
	public  String getuserPayload(Map<String ,String> testdata)
	{

		data datas=new data();
		datas.setFirst_name(testdata.get("first_name"));
		datas.setLast_name(testdata.get("last_name"));
		datas.setEmail(testdata.get("email"));
		datas.setAvatar(testdata.get("avatar"));
		datas.setId(Integer.parseInt(testdata.get("id")));
			
		userPojo user=new userPojo();
		user.setPage(Integer.parseInt(testdata.get("page")));
		user.setPer_page(Integer.parseInt(testdata.get("per_page")));
		user.setTotal(Integer.parseInt(testdata.get("total")));	
		user.setTotal_pages(Integer.parseInt(testdata.get("total_pages")));
		user.setData(datas);
		
		
		Gson gson=new Gson();
		return gson.toJson(user);
		
	}
	
	public String updateUserPayload(Map<String ,String> testdata) {
		data datas=new data();
		datas.setFirst_name(testdata.get("first_name"));
		datas.setLast_name(testdata.get("last_name"));
		
		Gson gson=new Gson();
		return gson.toJson(datas);
		
		

	}

}
