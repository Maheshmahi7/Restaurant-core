package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Menu;

public class TestMenuDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuDao menuDao=new MenuDao();
		
		
		
		
		
		List<Menu> list = menuDao.list();
		Iterator<Menu> i = list.iterator();
		while (i.hasNext()) {
			Menu menu = (Menu) i.next();
			System.out.println(menu.getId()+"\t"+menu.getName()+"\t"+menu.getPrice());
		}
		
	}

}
