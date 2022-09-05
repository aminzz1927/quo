package com.quo.service;

import java.util.List;

import com.quo.dto.StockInfoDto;

/** 

* @author zhoumin

*/

public interface StockService {

	//获取出入库详情列表
	List<StockInfoDto> getStockInfoList();

}
