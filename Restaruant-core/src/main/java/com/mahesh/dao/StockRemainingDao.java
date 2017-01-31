package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.FoodSchedule;
import com.mahesh.model.Menu;
import com.mahesh.model.StockRemaining;
import com.mahesh.util.ConnectionUtil;

public class StockRemainingDao {
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(StockRemaining stockRemaining) {

		String sql = "insert into stock_remaining(id,menu_id,schedule_id,quantity) values(?,?,?,?)";
		Object[] params = { stockRemaining.getId(),stockRemaining.getMenuId(),stockRemaining.getScheduleId(),stockRemaining.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(StockRemaining stockRemaining) {

		String sql = "update stock_remaining set quantity=? where menu_id=? and schedule_id=?";
		Object[] params = { stockRemaining.getQuantity(),stockRemaining.getMenuId(),stockRemaining.getScheduleId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from stock_remaining where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<StockRemaining> list() {

		String sql = "select id,menu_id,schedule_id,quantity from stock_remaining";
		List<StockRemaining> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			StockRemaining stockRemaining= new StockRemaining();
			Menu menu=new Menu();
			FoodSchedule foodSchedule=new FoodSchedule();
			stockRemaining.setId(rs.getInt("id"));
			menu.setId(rs.getInt("menu_id"));
			stockRemaining.setMenuId(menu);
			foodSchedule.setId(rs.getInt("schedule_id"));
			stockRemaining.setScheduleId(foodSchedule);
			stockRemaining.setQuantity(rs.getInt("quantity"));
			return stockRemaining;

		});
		return list;


}

}
