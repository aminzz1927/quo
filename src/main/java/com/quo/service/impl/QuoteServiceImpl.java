package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.dto.QuotesDto;
import com.quo.mapper.QuoteMapper;
import com.quo.service.QuoteService;

/** 

* @author zhoumin

*/
@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {
	
	@Autowired
	private QuoteMapper qMapper;

	@Override
	public Long[] getPidsByQuote() {
		// TODO Auto-generated method stub
		return qMapper.getPidsByQuote();
	}

	@Override
	public List<QuotesDto> getQuoteList() {
		// TODO Auto-generated method stub
		return qMapper.getQuoteList();
	}

}
