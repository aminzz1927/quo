package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.dto.StockInfoDto;
import com.quo.entity.StockRecord;
import com.quo.mapper.ProductMapper;
import com.quo.mapper.StockMapper;
import com.quo.service.StockService;

/** 

* @author zhoumin

*/
@Service("stockService")
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockMapper stockMapper;

	@Override
	public List<StockInfoDto> getStockInfoList() {
		// TODO Auto-generated method stub
		return stockMapper.getStockInfoList();
	}


	@Override
	public boolean addStockRecord(StockRecord stockRecord) {
		// TODO Auto-generated method stub
		return stockMapper.addStockRecord(stockRecord);
	}

}
