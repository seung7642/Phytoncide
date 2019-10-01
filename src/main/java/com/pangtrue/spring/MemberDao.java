package com.pangtrue.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        // JdbcTemplate#query() 메서드는 List<T> 타입 객체를 반환한다.
        // JdbcTemplate#query() 메서드는 쿼리를 실행하고 얻어온 ResultSet객체를 Java객체로 변환한다.
        // 두 번째 매개변수로 들어간 RowMapper<T> 클래스가 핵심이다.
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where EMAIL = ?", // 첫 번째 매개변수
                new RowMapper<Member>() { // 두 번째 매개변수
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("EMAIL"), 
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"), 
                                rs.getTimestamp("REGDATE").toLocalDateTime());
                        member.setId(rs.getLong("ID"));
                        return member;
                    }
                }, email); // 세 번째 매개변수 email은 인덱스 파라미터(두 번째 매개변수의 "select * ~ EMAIL = ?" 에서 ?가 인덱스 파라미터다.)
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(final Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)" + "values (?, ?, ?, ?)",
                        new String[] { "ID" });
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        // insert, delete, update 쿼리는 스프링의 JdbcTemplate 객체의 update() 메서드를 이용한다.
        // PreparedStatement 객체를 사용할때보다 코드가 상당히 간단해졌다.
        jdbcTemplate.update(
                "update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", 
                member.getName(),
                member.getPassword(), 
                member.getEmail());
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member(
                        rs.getString("EMAIL"), 
                        rs.getString("PASSWORD"), 
                        rs.getString("NAME"),
                        rs.getTimestamp("REGDATE").toLocalDateTime());
                member.setId(rs.getLong("ID"));
                return member;
            }
        });
        return results;
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", 
                Integer.class);
        return count;
    }
}
