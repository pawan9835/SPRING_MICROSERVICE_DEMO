package com.ticket.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class CustomIdGenerator implements IdentifierGenerator {

	String prefix = "MOV00";
	String suffix = "";

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		try {
			
			String query = " select next_val from ticket_details_seq";

			JdbcConnectionAccess connectionAccess = session.getJdbcConnectionAccess();

			Connection con = connectionAccess.obtainConnection();

			Statement stmt = con.createStatement();
			
			
		  ResultSet rs =	   stmt.executeQuery(query);
		  
		    if (rs.next()) {
				  int idValue = rs.getInt(1);
				  
				  Random random = new Random();   
				  
				int rvalue =    random.nextInt(100+500+1)+100;
				   
				  
				   suffix =String.valueOf(idValue+rvalue);
			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return prefix+suffix;
	}

}
