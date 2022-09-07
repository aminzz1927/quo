package com.quo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.ProductsDto;
import com.quo.dto.StockInfoDto;
import com.quo.entity.Emp;
import com.quo.entity.Product;
import com.quo.entity.StockRecord;
import com.quo.service.ProductService;
import com.quo.service.StockService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("stockController")
@RequestMapping(value="/api")
public class StockController {
	
	    @Autowired
	    public ProductService pService;
	    
	    @Autowired
	    public StockService stockService;
	
	
	  //在库一览					
	  @RequestMapping(value="/stock-list",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getStockList(){ 
		  
		  List<ProductsDto> stockList =	pService.getProductList(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(stockList);     
		  
		  return result;
	  
	  }
	  
	  
	  //出入库详情					
	  @RequestMapping(value="/stock-detail-list",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getStockInfoList(){ 
		  
		  List<StockInfoDto> stockInfoList = stockService.getStockInfoList(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(stockInfoList);     
		  
		  return result;
	  
	  }
	  
	  
	  //更新入库后的库存数量及出入库记录
	  @RequestMapping(value="/stock-in/{pid}",method=RequestMethod.POST)
	  @ResponseBody 
	  public Result updateStockInInfo(@PathVariable(value="pid") Long pid,@RequestBody Integer quantity,HttpSession session){ 
		  System.out.println("pid"+pid+"quantity"+quantity);

		  Product product = pService.getProductByPid(pid);		  
		  Integer preStock = product.getStock();
		  Integer stock = preStock + quantity;		  
		  pService.updateStock(pid,stock);		
		  System.out.println("preStock"+preStock+"stock"+stock);
		  		  
		  Emp emp = (Emp) session.getAttribute("emp");	
		  System.out.println("emp"+emp);	  
		  StockRecord stockRecord = new StockRecord();
		  stockRecord.setPid(pid);
		  stockRecord.setAtid(2);
		  stockRecord.setPreStock(preStock);
		  stockRecord.setQuantity(quantity);
		  stockRecord.setAfStock(stock);
		  stockRecord.setHeno(emp.getEno());		  
		  SimpleDateFormat sdfy = new SimpleDateFormat("yyyy-MM-dd");
		  stockRecord.setHdate(sdfy.format(new Date()));
	 
		  stockService.addStockRecord(stockRecord);     		  
		  return new Result(ResultCode.SUCCESS);
	  
	  }
	  
	  
	  //更新出库后的库存数量及出入库记录
	  @RequestMapping(value="/stock-out/{pid}",method=RequestMethod.POST)
	  @ResponseBody 
	  public Result updateStockOutInfo(@PathVariable(value="pid") Long pid,@RequestBody Integer quantity,HttpSession session){ 
		  System.out.println("pid"+pid+"quantity"+quantity);

		  Product product = pService.getProductByPid(pid);		  
		  Integer preStock = product.getStock();
		  Integer stock = preStock - quantity;		  
		  pService.updateStock(pid,stock);		
		  System.out.println("preStock"+preStock+"stock"+stock);
		  		  
		  Emp emp = (Emp) session.getAttribute("emp");	
		  System.out.println("emp"+emp);
		  StockRecord stockRecord = new StockRecord();
		  stockRecord.setPid(pid);
		  stockRecord.setAtid(2);
		  stockRecord.setPreStock(preStock);
		  stockRecord.setQuantity(quantity);
		  stockRecord.setAfStock(stock);
		  stockRecord.setHeno(emp.getEno());		  
		  SimpleDateFormat sdfy = new SimpleDateFormat("yyyy-MM-dd");
		  stockRecord.setHdate(sdfy.format(new Date()));
	 
		  stockService.addStockRecord(stockRecord);     		  
		  return new Result(ResultCode.SUCCESS);
	  
	  }
	  
	  
	  
	

}
