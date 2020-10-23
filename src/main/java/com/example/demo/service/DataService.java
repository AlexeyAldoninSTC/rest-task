package com.example.demo.service;

import com.example.demo.entity.Data;
import com.example.demo.repository.DataRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {

    private final DataRepository dataRepository;
    private final DataSource dataSource;

    public DataService(DataRepository dataRepository, DataSource dataSource) {
        this.dataRepository = dataRepository;
        this.dataSource = dataSource;
    }

    public Data getById(Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> request = new HashMap<>();
        request.put("id", id);
        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM data WHERE id=:id", request);
        return new Data((Integer) map.get("id"), (String) map.get("title"), (String) map.get("text"));
    }

    public List<Data> getAllData() {
        //language=sql
        String sql = "SELECT * FROM data";
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Data(rs.getInt("id"), rs.getString("title"), rs.getString("text")));
    }
}
