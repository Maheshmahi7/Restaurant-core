package com.mahesh.model;
import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodSchedule {
	private int id;
	private String schedule;
	private LocalTime fromTime;
	private LocalTime toTime;
	private int quantity;

}
