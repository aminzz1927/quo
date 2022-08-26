package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductType;
@Repository
public interface ProductMapper {

	
	
	  @Select("select p.pid,p.pname,pt.tname,ps.psname,p.stock,p.price from product p left join productseries ps on p.psid=ps.psid left join producttype pt\r\n"
	  + "	on ps.tid=pt.tid order by pid asc")	 
	List<ProductsDto> getProductList();

	  @Select("select p.pid,p.pname,pt.tname,ps.psname,p.stock,p.connection,p.pInterface,p.noise,p.bass,"
	  		+ "p.waterproof,p.mic,p.packageInfo from product p left join productseries ps on p.psid=ps.psid "
	  		+ "left join producttype pt on ps.tid=pt.tid where pid=#{pid} ")
	ProductDto getProduct(Long pid);

	  
	boolean updateProduct(Product product);

	List<ProductType> getTypeList();

	List<ProductSeries> getSeriesList();

	Product deleteProduct(Long pid);

	Product deleteProducts(Long pids);

}
