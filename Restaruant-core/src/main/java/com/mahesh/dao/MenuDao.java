package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Menu;
import com.mahesh.util.ConnectionUtil;

public class MenuDao {
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();


	public void save(Menu menu) {

		String sql = "insert into menu(id,name,price) values(?,?,?)";
		Object[] params = { menu.getId(), menu.getName(), menu.getPrice() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(Menu menu) {

		String sql = "update menu set name=?,price=? where id=?";
		Object[] params = { menu.getName(), menu.getPrice(),menu.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from menu where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	public List<Menu> list() {

		String sql = "select id,name,price from menu";
		List<Menu> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(rs.getString("name"));
			menu.setPrice(rs.getInt("price"));
			return menu;

		});
		return list;

	}

	

}
