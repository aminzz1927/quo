 package com.quo.controller;

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
import com.quo.entity.ProductType;
import com.quo.service.ProductService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

@Controller("productController")
public class ProductController {

	@Autowired
	public ProductService pService;

	
	     //获取所有产品信息		
			
			  @RequestMapping(value="/api/product",method=RequestMethod.GET)
			  @ResponseBody 
			  public Result getProductList(){ 
				  
				  List<ProductsDto> plist =	pService.getProductList(); 
				  Result result=new Result(ResultCode.SUCCESS);
				  result.setData(plist);     
				  
				  return result;
			  
			  }
		  
		  //获取单个产品信息
		  @RequestMapping(value="/api/product/{pid}",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getProduct(@PathVariable Long pid){ 
			  ProductDto product = pService.getProduct(pid);
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(product);
			  return result;
		  
		  }
		  
		  //更新特定产品信息
		  @RequestMapping(value="/api/product/{pid}",method=RequestMethod.PUT)
		  @ResponseBody
		  public Result updateProduct(@PathVariable(value="pid") Long pid,@RequestBody Product product){ 
			  product.setPid(pid);		
			  pService.updateProduct(product);					
			  return new Result(ResultCode.SUCCESS);
		  
		  }		  		  
		  
		  //获取产品类型列表
		  @RequestMapping(value="/api/product-type-list",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeList(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }		  
		  	  
		  
		  //获取产品系列列表
		  @RequestMapping(value="/api/product-series-list",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public List<ProductSeries> getSeriesList(){ 
			  List<ProductSeries> seriesList = pService.getSeriesList();
			  return seriesList;
		  
		  }
		  
		  //删除单个产品
		  @RequestMapping(value="/api/product/{pid}",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Product deleteProduct(Long pid){ 
			  Product product = pService.deleteProduct(pid);
			  return product;
		  
		  }
		  
		  
		  //删除多个产品
		  @RequestMapping(value="/api/product-del",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Product deleteProducts(Long pids){ 
			  Product product = pService.deleteProducts(pids);
			  return product;
		  
		  }
	 
		  
		  //添加单个产品
		  @RequestMapping(value="/api/{pid}",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Map<String, String> addProduct(Product product){ 
			  Map<String, String> ret = new HashMap<String, String>();
			  if(product == null){
					ret.put("type", "error");
					ret.put("msg", "请填写正确的产品信息！");
					return ret;
				}
				if(StringUtils.isEmpty(product.getPname())){
					ret.put("type", "error");
					ret.put("msg", "请填写产品名称！");
					return ret;
				}
				if(pService.addProduct(product) <= 0){
					ret.put("type", "error");
					ret.put("msg","产品添加失败，请联系管理员！");
					return ret;
				}
				ret.put("type", "success");
				ret.put("msg", "产品添加成功！");
				return ret;
			  
			  
		  
		  }

}
