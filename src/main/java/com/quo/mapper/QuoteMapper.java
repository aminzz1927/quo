package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.quo.dto.QuotesDto;

/** 

* @author zhoumin

*/
@Mapper
public interface QuoteMapper {

	@Select("select pid from quote")
	Long[] getPidsByQuote();

	@Select("select q.qid,q.abst,q.qdate,q.totalamount,c.cname,qs.qsname,e.ename from quote q "
			+ "left join customer c on q.cid=c.cid left join qstatus qs on q.qsid=qs.qsid left join "
			+ "emp e on q.ceno=e.eno")
	List<QuotesDto> getQuoteList();

}
