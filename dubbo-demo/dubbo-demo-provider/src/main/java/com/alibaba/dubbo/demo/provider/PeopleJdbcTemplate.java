package com.alibaba.dubbo.demo.provider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

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
	 * 根据名字查询
	 * 
	 * @param people
	 * @return
	 */
	public List<People> getPeopleByName(String peopleName) {

		Map<String, Object> parameters = new HashMap<String, Object>(1);
		parameters.put("peopleName", peopleName);
		String sql = "select people_id,people_name,status,description from demo_people where people_name = :peopleName";

		return this.namedParameterJdbcTemplate.query(sql, parameters, new RowMapper<People>() {
			public People mapRow(ResultSet rs, int rowNum) throws SQLException {
				People actor = new People();
				actor.setPeopleId(rs.getInt("people_id"));
				actor.setPeopleName(rs.getString("people_name"));
				actor.setStatus(rs.getInt("status"));
				actor.setDescription(rs.getString("description"));
				return actor;
			}
		});
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

	/**
	 * 批量保存
	 * 
	 * @param people
	 * @return
	 */
	public int[] batchSave(List<People> peopleList) {

		String sql = "insert into demo_people(people_id,people_name,status,description) values (:peopleId,:peopleName,:status,:description)";

		return this.namedParameterJdbcTemplate.batchUpdate(sql,
				SqlParameterSourceUtils.createBatch(peopleList.toArray()));
	}

	/**
	 * 根据名字删除
	 * 
	 * @param people
	 * @return
	 */
	public int deletePeopleByName(String peopleName) {

		Map<String, Object> parameters = new HashMap<String, Object>(1);
		parameters.put("peopleName", peopleName);
		String sql = "delete from demo_people where people_name = :peopleName";

		return namedParameterJdbcTemplate.update(sql, parameters);
	}

}
