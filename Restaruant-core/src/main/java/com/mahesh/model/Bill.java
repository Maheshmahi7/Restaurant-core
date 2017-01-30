package com.mahesh.model;

import lombok.Data;

@Data
public class Bill {
	

	private int id;
	private Orders orderId;
	private int totalCost;
	private String status;
	
}
