package com.mahesh.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.mahesh.util.ConnectionUtil;

public class ProcedureDao {
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
	public String PR_TAKE_ORDER(int seatNo,String items ,String quantitys) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("PR_TAKE_ORDER");
		call.declareParameters(new SqlParameter("i_seat_no", Types.INTEGER),new SqlParameter("i_items", Types.VARCHAR),
				new SqlParameter("i_quantitys", Types.VARCHAR),
				new SqlOutParameter("message_status", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("i_seat_no", seatNo);
		in.addValue("i_items", items);
		in.addValue("i_quantitys", quantitys);

		Map<String, Object> execute = call.execute(in);

		String status = (String) execute.get("message_status");
		return status;

	}
	
	public int getItemId(String name){
		String sql = "select FN_GET_MENU_ID(?)";
		Object[] params = { name };
		int id = jdbcTemplate.queryForObject(sql, params,int.class);
		//System.out.println("No of rows updated: " + rows);
		return id;
	}
	
	
}
