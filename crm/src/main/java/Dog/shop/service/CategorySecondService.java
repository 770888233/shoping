package Dog.shop.service;

import java.util.List;

import Dog.shop.ben.Categorysecond;
import Utils.PageBean;

public interface CategorySecondService {
//	管理员分页查询所有的二级分类
	PageBean<Categorysecond> adminCategorySecond_findAllByPage(int page);
//
	void adminCategorySecond_save(Categorysecond categorysecond) throws Exception;
	
	Categorysecond findByCsid(int csid)  throws Exception;
	
	void adminCategorySecond_update(Categorysecond categorysecond);
	
	void adminCategorySecond_delete(int csid) throws Exception;
	
	List<Categorysecond> findAll() throws Exception;
//	级联删除
	void adminCategorySecond_deleteByCid(int cid) throws Exception;
	
}
