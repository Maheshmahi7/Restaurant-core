package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Transaction;

public class TestTransactionDao {
	public static void main(String[] args) {
		
		TransactionDao transactionDao=new TransactionDao();
		
		List<Transaction> list = transactionDao.list();
		Iterator<Transaction> i = list.iterator();
		while (i.hasNext()) {
			Transaction transaction = (Transaction) i.next();
			System.out.println(transaction.getId()+"\t"+transaction.getOrderId().getId()+"\t"+transaction.getMenuId().getId()+"\t"+transaction.getQuantity()+"\t"+transaction.getOrderedTime()+"\t"+transaction.getStatus());
		}

		
	}

}
