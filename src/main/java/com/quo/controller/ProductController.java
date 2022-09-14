 package com.quo.controller;

import java.io.IOException;

import java.io.OutputStream;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.annotation.Permission;
import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.*;
import com.quo.entity.Product2;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;
import com.quo.entity.Quote;
import com.quo.service.ProductService;
import com.quo.service.QuoteService;
import com.quo.utils.ExcelWriter;
import com.quo.utils.ProductExcelExporter;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;



/** 

* @author zhoumin
 * 

*/
@Controller("productController")
@RequestMapping(value="/api")
public class ProductController {

	@Autowired
	public ProductService pService;  
	
	@Autowired
	public QuoteService qService;

	
	     //获取所有产品信息		
			  @Permission(name = "product:view")
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
		  @Permission(name = "product:edit")
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.PUT)
		  @ResponseBody
		  public Result updateProduct(@PathVariable(value="pid") Long pid,@RequestBody Product product){ 
			  product.setPid(pid);		
			  pService.updateProduct(product);					
			  return new Result(ResultCode.SUCCESS);
		  
		  }		  		  
		  
		  //获取产品类型列表(产品编辑)
		
		  @RequestMapping(value="/product-type-list-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeList(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }		
		  
		  //获取产品类型列表(添加新品)
		  @RequestMapping(value="/product-type-list-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForNew(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  
		//获取产品类型列表(シリーズ編集)
		  @RequestMapping(value="/product-type-list-series-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForSeries(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  
		//获取产品类型列表(新規シリーズ)
		  @RequestMapping(value="/product-type-list-series-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getTypeListForNewSeries(){ 
			  List<ProductType> typeList = pService.getTypeList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(typeList);
			  return result;
		  
		  }	
		  	  
		  
		  //获取产品系列列表(产品编辑)
		  @RequestMapping(value="/product-series-list-edit",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getSeriesListForEdit(){ 
			  List<ProductSeries2> seriesList = pService.getSeriesList();
			  System.out.println("AAAAAAAAAA"+seriesList);
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(seriesList);
			  return result;
		  
		  }
		  
		  //获取产品系列列表(添加新品)
		  @RequestMapping(value="/product-series-list-add",method=RequestMethod.GET)		  
		  @ResponseBody 
		  public Result getSeriesListForNew(){ 
			  List<ProductSeries2> seriesList = pService.getSeriesList();
			  Result result=new Result(ResultCode.SUCCESS);
			  result.setData(seriesList);
			  return result;
		  
		  }
		  
		  
		  
		  //删除单个产品
			/*	  @RequestMapping(value="/product/{pid}",method=RequestMethod.DELETE)
				  @ResponseBody
				  public Result deleteProduct(@PathVariable(value="pid") Long pid){ 
					      pService.deleteProduct(pid);
					  return new Result(ResultCode.SUCCESS);
				  
				  }
				  */
		  @Permission(name = "product:delete")
		  @RequestMapping(value="/product/{pid}",method=RequestMethod.DELETE)
		  @ResponseBody
		  public Result deleteProduct(@PathVariable(value="pid") Long pid){ 
			  
			  Long[] pids =	qService.getPidsByQuote();
			  if (Arrays.binarySearch(pids, pid) >=0) {
				  return new Result(ResultCode.NODEL);
			  }
			      pService.deleteProduct(pid);
			  return new Result(ResultCode.SUCCESS);
		  
		  }
		  
		  //删除多个产品
		  @RequestMapping(value="/product-del",method=RequestMethod.POST)		  
		  @ResponseBody 
		  public Result deleteProducts(@RequestBody Long[] pids){ 
			  
			  Long[] pidsOfQuote =	qService.getPidsByQuote();
			  for(Long pid:pids) {				 
			  	  if (Arrays.binarySearch(pidsOfQuote, pid) >=0) {
				  return new Result(ResultCode.NODEL);
			  }
			} 
			  		
				  pService.deleteProducts(pids);
				  
			  
			  return new Result(ResultCode.SUCCESS);
		  
		  }	

		  //添加单个产品
		  @Permission(name = "product:add")
		  @RequestMapping(value="/product",method=RequestMethod.POST)
		  @ResponseBody
		  public Result addProduct(@RequestBody Product product){ 

			  	pService.addProduct(product);
			
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
		    public Result saves(@RequestBody List<Product2> productList )  {
		    	
		    	System.out.println(productList);
		    	pService.saves(productList);
		        return new Result(ResultCode.SUCCESS);
		    }
/**
 * author:韩宛廷
 * 产品导出
 * @param request
 * @param response
 * @throws IOException 
 */          
		    @RequestMapping(value="/product-export",method = RequestMethod.POST)
		    public void ProductExport(@RequestBody Long[] pids, HttpServletRequest request, HttpServletResponse response) {
		    	String[] arrays= {"产品编号","产品名称","产品类型名称","产品系列名称","价格","库存","耳机连接方式","耳机接口","降噪","重低音","防水功能","麦克风","包装清单"};
		 
				 response.setContentType("application/vnd.ms-excel"); 
				response.setHeader("Content-disposition", "attachment;filename=Product-"+System.currentTimeMillis()+".xlsx");
				List<ProductExport> proList =	pService.getByPids(pids);
		        System.out.println(proList);
				ExcelWriter<ProductExport> ew = new ExcelWriter<>();
				XSSFWorkbook workbook = ew.getWorkbook(proList, "产品信息", ProductExport.class,arrays);
				ServletOutputStream outputStream = null;
				try {
					outputStream=response.getOutputStream();
					workbook.write(outputStream);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						workbook.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		    }
		    
		    
//		    @RequestMapping(value="/product-export",method = RequestMethod.POST)
//		    public void ProductExport(@RequestBody Long[] pids, HttpServletRequest request, HttpServletResponse response) throws IOException {
//	    	 response.setContentType("application/octet-stream"); 
//					response.setHeader("Content-disposition", "attachment;filename=Product-"+System.currentTimeMillis()+".xlsx");
//					List<ProductExport> proList =	pService.getByPids(pids);
//					ProductExcelExporter exporter = new ProductExcelExporter(proList);
//					exporter.export(response);
//		    }
		    
}
