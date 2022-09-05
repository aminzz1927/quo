package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.quo.dto.StockInfoDto;

/** 

* @author zhoumin

*/
@Mapper
public interface StockMapper {

	@Select("select sr.hid,sr.quantity,sr.preStock,sr.afStock,sr.hdate,p.pname,pt.tname,ps.psname,a.aname,e.ename "
			+ "from stockrecord sr left join product p on sr.pid=p.pid left join productseries ps on "
			+ "p.psid=ps.psid left join producttype pt on ps.tid=pt.tid left join action a on sr.atid=a.atid "
			+ "left join emp e on sr.heno=e.eno")
	List<StockInfoDto> getStockInfoList();

}
