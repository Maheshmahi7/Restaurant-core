package com.mahesh.model;

import lombok.Data;

@Data
public class StockRemaining {
	
	private int id;
	private Menu menuId;
	private FoodSchedule scheduleId;
	private int quantity;

}
