package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Menu;
import com.mahesh.model.Orders;
import com.mahesh.model.Transaction;
import com.mahesh.util.ConnectionUtil;

public class TransactionDao {
	
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(Transaction transaction) {

		String sql = "insert into transaction_hotel(order_id,menu_id,quantity,ordered_time,status) values(?,?,?,?,?)";
		Object[] params = { transaction.getOrderId(),transaction.getMenuId(),transaction.getQuantity(),transaction.getOrderedTime(),transaction.getStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	

	public void delete(int id) {

		String sql = "delete from transaction_hotel where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<Transaction> list() {

		String sql = "select id,order_id,menu_id,quantity,ordered_time,status from transaction_hotel";
		List<Transaction> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Transaction transaction= new Transaction();
			Menu menu=new Menu();
			Orders orders=new Orders();
			transaction.setId(rs.getInt("id"));
			orders.setId(rs.getInt("order_id"));
			transaction.setOrderId(orders);
			menu.setId(rs.getInt("menu_id"));
			transaction.setMenuId(menu);;
			transaction.setQuantity(rs.getInt("quantity"));
			transaction.setOrderedTime(rs.getTime("ordered_time").toLocalTime());
			transaction.setStatus(rs.getString("status"));
			return transaction;

		});
		return list;


}

	

}
