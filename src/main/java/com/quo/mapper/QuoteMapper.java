package com.quo.mapper;

import org.apache.ibatis.annotations.Select;

/** 

* @author zhoumin

*/

public interface QuoteMapper {

	@Select("select pid from quote")
	Long[] getPidsByQuote();

}
