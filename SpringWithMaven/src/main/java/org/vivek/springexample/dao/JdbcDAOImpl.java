package org.vivek.springexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.vivek.springexample.model.Circle;

@Component
public class JdbcDAOImpl {
	
	
	private DataSource dataSource;
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
	
	
	/*public int getcountCircle(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);	
	}
	
	public String getNames(int circleId){
		String sql = "SELECT NAME FROM CIRCLE where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);	
	}
	*/
	//		SqlParameterSource source = new MapSqlParameterSource("ID", "2").addValue("NAME", "DR. BABA AMTE");

	
	
	public void insertNames(Circle circle){
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:ID, :NAME)";
		SqlParameterSource source = new MapSqlParameterSource("ID", circle.getId()).addValue("NAME", circle.getName());
		jdbcTemplate.update(sql, source);
		
	}
	
	
	public List<Circle> getDrName(){
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleRowMapper());	
	}
	

	private static  final  class CircleRowMapper implements RowMapper<Circle> {
		
	public Circle mapRow(ResultSet resultSet, int rowNo)
				throws SQLException {
				
					Circle circle = new Circle();
					circle.setId(resultSet.getInt("ID"));
					circle.setName(resultSet.getString("NAME"));

				
				
				
			return circle;
		}

	}
	
}


