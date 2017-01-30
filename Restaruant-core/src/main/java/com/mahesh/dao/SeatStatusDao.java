package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.SeatStatus;
import com.mahesh.util.ConnectionUtil;

public class SeatStatusDao {
	
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(SeatStatus seatStatus) {

		String sql = "insert into seat_status(id,seat_id,status) values(?,?,?)";
		Object[] params = { seatStatus.getId(),seatStatus.getSeatId(),seatStatus.getStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(SeatStatus seatStatus) {

		String sql = "update seat_status set status=? where seat_id=?";
		Object[] params = { seatStatus.getStatus(),seatStatus.getSeatId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from seat_status where seatid=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<SeatStatus> list() {

		String sql = "select id,seat_id,status from seat_status";
		List<SeatStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeatStatus seatStatus=new SeatStatus();
			seatStatus.setId(rs.getInt("id"));
			seatStatus.setSeatId(rs.getInt("seat_id"));
			seatStatus.setStatus(rs.getString("status"));
			return seatStatus;

		});
		return list;
}


}
