package Dog.shop.service;

import java.util.List;

import Dog.shop.ben.Product;
import Utils.PageBean;

public interface ProductService {

	List<Product> findHotProduct();

	List<Product> findNewProduct();

	List<Product> searchProduct(String condition);

	PageBean<Product> findProductyBycid(int cid, int page);

	PageBean<Product> finbProductByCsid(int csid, int page);

	Product productFindByPid(int pid);

	PageBean<Product> findAllProduct(int page);

	void adminProduct_save(Product product);

	Product finbProductByPid(int pid);

	void adminProduct_update(Product product);

	void adminProduct_deletecs(int pid);

}
