package com.quo.service;

import java.util.List;

import com.quo.dto.QuotesDto;

/** 

* @author zhoumin

*/

public interface QuoteService {

	//通过报价单获取产品id
	Long[] getPidsByQuote();

	//获取报价单列表
	List<QuotesDto> getQuoteList();

}
