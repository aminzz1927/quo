package com.quo.service;

import java.util.List;

import com.quo.dto.StockInfoDto;
import com.quo.entity.StockRecord;

/** 

* @author zhoumin

*/

public interface StockService {

	//获取出入库详情列表
	List<StockInfoDto> getStockInfoList();

	//新增出入库记录
	boolean addStockRecord(StockRecord stockRecord);

}
