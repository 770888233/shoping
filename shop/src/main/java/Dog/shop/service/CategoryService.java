package Dog.shop.service;

import java.util.List;

import Dog.shop.ben.Category;

public interface CategoryService {
//	查询一级目录
	public List<Category> findCategory() throws Exception;

	public List<Category> adminbFindCategory();

	public void addCategory(Category addCategory);

	public Category findCategory(int cid);

	public void deleteCategoryByCid(int cid);

	public void adminCategory_update(Category category);

	public List<Category> list();

	


}
