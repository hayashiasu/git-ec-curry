package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Topping;

/**
 * toppingsテーブルを操作するリポジトリ.
 * 
 * @author watanabe
 *
 */
@Repository
public class ToppingRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_NAME = "toppings";
	/** Toppingオブジェクトを生成するローマッパー */
	private static final RowMapper<Topping> TOPPING_ROW_MAPPER = new BeanPropertyRowMapper<>(Topping.class);

	/**
	 * 主キーからトッピング情報を検索する.
	 * 
	 * @param id 検索するID
	 * @return 検索されたトッピング情報
	 */
	public Topping load(Integer id) {
		StringBuilder loadSql = new StringBuilder();
		loadSql.append("SELECT");
		loadSql.append(" id,name,price_m,price_l");
		loadSql.append(" FROM " + TABLE_NAME);
		loadSql.append(" WHERE");
		loadSql.append(" id =  :id");

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Topping topping = template.queryForObject(loadSql.toString(), param, TOPPING_ROW_MAPPER);

		return topping;
	}

	/**
	 * トッピングの情報を全件検索します.
	 * 
	 * @return 検索されたトッピング情報
	 */
	public List<Topping> findAll() {
		String sql = "SELECT id,name,price_m,price_l FROM toppings ORDER BY id;";
		List<Topping> toppingList = template.query(sql, TOPPING_ROW_MAPPER);
		return toppingList;

	}

}
