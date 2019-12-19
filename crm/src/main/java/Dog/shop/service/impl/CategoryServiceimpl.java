package Dog.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dog.shop.ben.Category;
import Dog.shop.ben.CategoryExample;
import Dog.shop.mapper.CategoryMapper;
import Dog.shop.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findCategory() throws Exception {
		// TODO Auto-generated method stub
		List<Category> list = categoryMapper.findCategoryAndSecondcategory();
		if (list!=null && list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public List<Category> adminbFindCategory() {
		// TODO Auto-generated method stub
		CategoryExample example = new CategoryExample();
		List<Category> list = categoryMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}


	@Override
	public void addCategory(Category addCategory) {
		// TODO Auto-generated method stub
		categoryMapper.insert(addCategory);
		
	}

	@Override
	public Category findCategory(int cid) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public void deleteCategoryByCid(int cid) {
		// TODO Auto-generated method stub
		categoryMapper.deleteByPrimaryKey(cid);
		
	}

	@Override
	public void adminCategory_update(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.updateByPrimaryKey(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		CategoryExample example = new CategoryExample();	
		return categoryMapper.selectByExample(example);
	}

	

	
}
