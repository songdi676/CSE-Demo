package com.service.cserpcdemo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.newland.demo.api.People;

public class PeopleJdbcTemplate extends JdbcDaoSupport {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public void initDao() throws Exception {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());
	}

	/**
	 * 根据人名和状态统计人数
	 * 
	 * @param people
	 * @return
	 */
	public int countOfPeopleByNameAndStatus(People people) {

		String sql = "select count(*) from demo_people where people_name = :peopleName and status = :status";

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(people);

		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

	/**
	 * 保存
	 * 
	 * @param people
	 * @return
	 */
	public int save(People people) {

		String sql = "insert into demo_people(people_id,people_name,status,description) values (:peopleId,:peopleName,:status,:description)";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(people);

		return this.namedParameterJdbcTemplate.update(sql, namedParameters);
	}
}
