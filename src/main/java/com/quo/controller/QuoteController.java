package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.QuotesDto;
import com.quo.service.QuoteService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("quoteController")
@RequestMapping(value="/api")
public class QuoteController {
	
	
	@Autowired
	public QuoteService qService;
	
	//获取报价单列表
	@RequestMapping(value="/quote",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getQuoteList(){ 
		  
		  List<QuotesDto> qlist =	qService.getQuoteList(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(qlist);     
		  
		  return result;
	  
	  }
	
	

}
