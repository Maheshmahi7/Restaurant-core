package com.mahesh.dao;



public class TestProcedureDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ProcedureDao proceduredao=new ProcedureDao();
			String test=proceduredao.PR_TAKE_ORDER(5, "South Indian Meals,North Indian Thali,Variety Rice,null,null", "1,1,1,0,0");
			System.out.println(test);
			

			//int itemId=procedureDao.getItemId("South Indian Meals");
			//System.out.println(itemId);
			
	}

}
