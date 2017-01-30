package com.mahesh.model;

import lombok.Data;

@Data
public class StockRemaining {
	
	private int id;
	private int menuId;
	private int scheduleId;
	private int quantity;

}
