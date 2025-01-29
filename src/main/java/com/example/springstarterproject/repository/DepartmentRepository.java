package com.example.springstarterproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.springstarterproject.domain.Department;

@Repository
public class DepartmentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Department> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setName(rs.getString("name"));
        return department;
    };


        public Department load(Integer id){
            System.out.println("Repositoryのload()が呼ばれました");
        // String sql = "SELECT id,name FROM departments WHERE id = :id;";
        String sql = "SELECT * FROM departments WHERE id = :id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Department department = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
        return department;
    }
}
