package com.quo.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.Product2;
import com.quo.entity.ProductExport;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;

@Repository
public interface ProductMapper {

	
	
	@Select("select p.pid,p.pname,pt.tname,ps.psname,p.stock,p.price from product p left join productseries ps on p.psid=ps.psid left join producttype pt\r\n"
	 + "	on ps.tid=pt.tid order by pid desc")	 
	List<ProductsDto> getProductList();
	
	//List<ProductsDto> getProductList();

	  @Select("select p.pid,p.pname,pt.tid,pt.tname,ps.psid,ps.psname,p.price,p.stock,p.connection,p.pInterface,p.noise,p.bass,"
	  		+ "p.waterproof,p.mic,p.packageInfo from product p left join productseries ps on p.psid=ps.psid "
	  		+ "left join producttype pt on ps.tid=pt.tid where pid=#{pid} ")
	ProductDto getProduct(Long pid);

	  
	boolean updateProduct(Product product);

	List<ProductType> getTypeList();

	List<ProductSeries2> getSeriesList();

	boolean deleteProduct(Long pid);

	boolean deleteProducts(Long[] pids);

	boolean addProduct(Product product);
	
	int saves(List<Product2> productList);
	
	//产品导出
	List<ProductExport> getByPids(Long[] pids);
	
	@Select("select * from product where pid=#{pid}")
	Product getProductByPid(Long pid);

	//更新库存数量
	@Update("update product set stock=#{stock} where pid=#{pid}")
	boolean updateStock(@Param("pid")Long pid, @Param("stock") Integer stock);

}
