package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Menu;
import com.mahesh.model.StockRemaining;

public class TestProcedureDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ProcedureDao proceduredao=new ProcedureDao();
			String test=proceduredao.PR_TAKE_ORDER(7, "South Indian Meals,North Indian Thali,Variety Rice,null,null", "1,1,1,0,0");
			System.out.println(test);
			
			StockRemainingDao stockRemainingDao=new StockRemainingDao();
			List<StockRemaining> list = stockRemainingDao.list();
			Iterator<StockRemaining> i = list.iterator();
			while (i.hasNext()) {
				StockRemaining stockRemaining = (StockRemaining) i.next();
				System.out.println(stockRemaining.getId()+"\t"+stockRemaining.getMenuId()+"\t"+stockRemaining.getScheduleId()+"\t"+stockRemaining.getQuantity());
			}
			
			MenuDao menuDao=new MenuDao();
			List<Menu> list1 = menuDao.list();
			Iterator<Menu> j = list1.iterator();
			while (j.hasNext()) {
				Menu menu = (Menu) j.next();
				System.out.println(menu.getId()+"\t"+menu.getName()+"\t"+menu.getPrice());
			}
			
			
	}

}
