package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Seat;
import com.mahesh.util.ConnectionUtil;

public class SeatDao {
	
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(Seat seat) {

		String sql = "insert into seat(id,name) values(?,?)";
		Object[] params = { seat.getId(),seat.getName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(Seat seat) {

		String sql = "update seat set name=? where id=?";
		Object[] params = { seat.getName(),seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from seat where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<Seat> list() {

		String sql = "select id,name from seat";
		List<Seat> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Seat seat=new Seat();
			seat.setId(rs.getInt("id"));
			seat.setName(rs.getString("name"));
			return seat;

		});
		return list;
}
	
}
