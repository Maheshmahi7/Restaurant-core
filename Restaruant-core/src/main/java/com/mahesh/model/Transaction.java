package com.mahesh.model;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Transaction {
	
	private int id;
	private Orders orderId;
	private Menu menuId;
	private int quantity;
	private LocalTime OrderedTime;
	private String status;

}
