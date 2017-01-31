package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.SeatStatus;

public class TestSeatStatusDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeatStatusDao seatStatusDao=new SeatStatusDao();
		
		
		
		
		
		List<SeatStatus> list = seatStatusDao.list();
		Iterator<SeatStatus> i = list.iterator();
		while (i.hasNext()) {
			SeatStatus seatStatus = (SeatStatus) i.next();
			System.out.println(seatStatus.getId()+"\t"+seatStatus.getSeatId().getId()+"\t"+seatStatus.getStatus());
		}

	}

}
