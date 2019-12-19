package Dog.shop.mapper;

import Dog.shop.ben.Product;
import Dog.shop.ben.ProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Product> searchProduct(String condition);

	int countProducyByCid(int cid);

	List<Product> findProductByCid(int cid, int beginPage, int limitPage);

	int countProducyByCsid(int csid);

	

	List<Product> findProductBycsid(int csid, int beginPage, int limitPage);

	List<Product> findAllProduct(int beginPage, int limitPage);

}