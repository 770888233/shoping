package Dog.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dog.shop.ben.Product;
import Dog.shop.ben.ProductExample;
import Dog.shop.mapper.ProductMapper;
import Dog.shop.service.ProductService;
import Utils.PageBean;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		ProductExample example =new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andIsHotEqualTo(1);
		example.setOrderByClause("pdate DESC");
		example.setBeginPage(0);
		example.setEnd(4);		
		List<Product> list = productMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

	@Override
	public List<Product> findNewProduct() {
		// TODO Auto-generated method stub
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andIsHotEqualTo(0);
		example.setOrderByClause("pdate DESC");
		example.setBeginPage(0);
		example.setEnd(8);		 
		List<Product> list = productMapper.selectByExample(example);
	   if(list!=null && list.size()>0){
		   return list;
	   }
	   return null;
	}

	@Override
	public List<Product> searchProduct(String condition) {
		 	 
		 List<Product> list = productMapper.searchProduct(condition) ;
		  
		 if(list!=null && list.size()>0){
			 return list;
		 }
		 return null;
	}

	@Override
//	根据cid查找商品
	public PageBean<Product> findProductyBycid(int cid, int page){
		PageBean<Product> pageBean = new PageBean<>();
//		设置这是第几页
		pageBean.setPage(page);
//		设置10个
		int limitPage =12;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = productMapper.countProducyByCid(cid);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
//		商品集合
		List<Product> list = productMapper.findProductByCid(cid,beginPage,limitPage);
		pageBean.setList(list);
		
		return pageBean;
	}
	//根据csid查询二级目录
	@Override
	public PageBean<Product> finbProductByCsid(int csid, int page) {
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setPage(page);
//		设置10个
		int limitPage =12;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = productMapper.countProducyByCsid(csid);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
//		商品集合
		List<Product> list = productMapper.findProductBycsid(csid,beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Product productFindByPid(int pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public PageBean<Product> findAllProduct(int page){
		PageBean<Product> pageBean = new PageBean<>();
		pageBean.setPage(page);
//		设置10个
		int limitPage =12;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		ProductExample example = new ProductExample();
		totlePage = productMapper.countByExample(example);
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
//		商品集合
		List<Product> list = productMapper.findAllProduct(beginPage,limitPage);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void adminProduct_save(Product product) {
		// TODO Auto-generated method stub
		productMapper.insert(product);
	}

	@Override
	public Product finbProductByPid(int pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public void adminProduct_update(Product product) {
		productMapper.updateByPrimaryKey(product);
		
	}

	@Override
	public void adminProduct_deletecs(int pid) {
		// TODO Auto-generated method stub
		productMapper.deleteByPrimaryKey(pid);
	}

}
