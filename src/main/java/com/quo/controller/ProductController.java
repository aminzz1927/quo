 package com.quo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;
import com.quo.service.ProductService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("productController")
@RequestMapping(value="/api")
public class ProductController {

	@Autowired
	public ProductService pService;

	
	     //获取所有产品信息		
			
			  @RequestMapping(value="/product",method=RequestMethod.GET)
			  @ResponseBody 
			  public Result getProductList(){ 
				  
				  List<ProductsDto> plist =	pService.getProductList(); 
				  Result result=new Result(ResultCode.SUCCESS);
				  result.setData(plist);     
				  
				  return result;
			  
			  }
		  
		  //获取单个产品信息
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getProduct(@PathVariable Long pid){ 
			  ProductDto product = pService.getProduct(pid);
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(product);
			  return result;
		  
		  }
		  
		  //更新特定产品信息
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.PUT)
		  @ResponseBody
		  public Result updateProduct(@PathVariable(value="pid") Long pid,@RequestBody Product product){ 
			  product.setPid(pid);		
			  pService.updateProduct(product);					
			  return new Result(ResultCode.SUCCESS);
		  
		  }		  		  
		  
		  //获取产品类型列表
		  @RequestMapping(value="/product-type-list",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeList(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }		  
		  	  
		  
		  //获取产品系列列表
		  @RequestMapping(value="/product-series-list",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getSeriesList(){ 
			  List<ProductSeries> seriesList = pService.getSeriesList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(seriesList);
			  return result;
		  
		  }
		  
		  
		  
		  //删除单个产品
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.DELETE)
		  @ResponseBody
		  public Result deleteProduct(@PathVariable(value="pid") Long pid){ 
			      pService.deleteProduct(pid);
			  return new Result(ResultCode.SUCCESS);
		  
		  }
		  
		  //删除多个产品
		  @RequestMapping(value="/product-del",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Result deleteProducts(Long[] pids){ 
			  
			  		
				  pService.deleteProducts(pids);
				  
			  
			  return new Result(ResultCode.SUCCESS);
		  
		  }

		  /**
			  * 添加多个产品
			  * author：韩宛廷
			  * @param productList
			  * @return
			  */
		    @RequestMapping(value="/products",method = RequestMethod.POST)
		    @ResponseBody
		    public Result saves(@RequestBody List<Product> productList )  {
		    	
				/*
				 * Product p=new Product();
				 * 
				 * p.setPname(p.getPname()); p.setPsid(p.getPsid()); p.setStock(p.getStock());
				 * p.setConnection(p.getConnection()); p.setPinterface(p.getPinterface());
				 * p.setNoise(p.getNoise()); p.setBass(p.getBass());
				 * p.setWaterproof(p.getWaterproof()); p.setMic(p.getMic());
				 * p.setPrice(p.getPrice()); p.setPackageInfo(p.getPackageInfo());
				 * productList.add(p);
				 */
		    	System.out.println(productList);
		    	pService.saves(productList);
		        return new Result(ResultCode.SUCCESS);
		    }


		  //添加单个产品
		  @RequestMapping(value="/product/add",method=RequestMethod.POST)
		  @ResponseBody
		  public Result addProduct(@RequestBody Product product){ 

			  	pService.addProduct(product);
			
				return new Result(ResultCode.SUCCESS);
			  
			  
		  
		  }
		  

		

}
