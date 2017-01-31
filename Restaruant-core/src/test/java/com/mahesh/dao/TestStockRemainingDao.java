package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.StockRemaining;


public class TestStockRemainingDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockRemainingDao stockRemainingDao=new StockRemainingDao();
		
		List<StockRemaining> list = stockRemainingDao.list();
		Iterator<StockRemaining> i = list.iterator();
		while (i.hasNext()) {
			StockRemaining stockRemaining = (StockRemaining) i.next();
			System.out.println(stockRemaining.getId()+"\t"+stockRemaining.getMenuId().getId()+"\t"+stockRemaining.getScheduleId().getId()+"\t"+stockRemaining.getQuantity());
		}


	}

}
