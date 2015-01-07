package org.vivek.springexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.vivek.springexample.model.Circle;

@Component
public class JdbcDAOImpl {
	
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}


	public Circle getCircle(int circleId){
		Circle circle= null;
		
		Connection conn = null;
		
		   try {

			conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement("SELECT * FROM CIRCLE WHERE ID = ?");
			psmt.setInt(1, circleId);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				circle = new Circle(circleId,  rs.getString("NAME"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally{
			   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
		
		
		
		return circle;
	}
	
	
	public int getcountCircle(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
		
		
		
	}
}
