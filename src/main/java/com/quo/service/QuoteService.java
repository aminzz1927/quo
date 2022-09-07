package com.quo.service;

import java.util.List;

import com.quo.dto.QuotesDto;

/** 

* @author zhoumin

*/

public interface QuoteService {

	Long[] getPidsByQuote();

	//获取报价单列表
	List<QuotesDto> getQuoteList();

}
