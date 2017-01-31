package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Seat;

public class TestSeatDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SeatDao seatDao=new SeatDao();
		
		
		
		
		
		List<Seat> list = seatDao.list();
		Iterator<Seat> i = list.iterator();
		while (i.hasNext()) {
			Seat seat = (Seat) i.next();
			System.out.println(seat.getId()+"\t"+seat.getName());
		}
	}

}
