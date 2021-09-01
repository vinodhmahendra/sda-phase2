package com.simplilearn.workshop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Product;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
	
	private static final String SQL_PRODUCTS_SELECT = "select * from product";
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductRepositoryImpl(DataSource dataSource) {
		//create ajdbcTemplate object
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> findAll() {
		
		return jdbcTemplate.query(SQL_PRODUCTS_SELECT, new RowMapper<Product> () {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setDateAdded(rs.getTimestamp("date_added"));
				return product;
			}
			
		});
	}
	

}
