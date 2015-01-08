package org.vivek.springexample.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleJdbcDAOImpl extends JdbcDaoSupport {

	public int getcountCircle(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return getJdbcTemplate().queryForObject(sql, Integer.class);	
	}
	
	
}
