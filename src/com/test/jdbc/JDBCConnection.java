package com.test.jdbc;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.oop.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

  public static void main(String[] args) throws ClassNotFoundException,SQLException {
    
    String uri = "jdbc:mariadb://127.0.0.1:3306/webdev";
    String userid = "";
    String userpw = "";
    String query = "SELECT name , gender , age FROM tbl_test";
  
    Connection con;                
    Statement stmt;
    ResultSet rs;
  
    // JDBC 드라이버 연결
    Class.forName("org.mariadb.jdbc.Driver");
    con = DriverManager.getConnection(uri, userid, userpw);
    stmt = con.createStatement();

    rs = stmt.executeQuery(query);

    List<Member> list = new ArrayList<>();

    while (rs.next()) {
      // rs.next()가 false(행끝남)을 반환할때까지 루핑
      list.add(new Member(
        rs.getString("name")
      , rs.getString("gender")
      , rs.getInt("age")
      ));
    }
    System.out.println("======================");
    if(rs != null) rs.close();
    if(stmt != null) stmt.close();
    if(con != null) con.close();
    
    list.stream().forEach(s->{
      System.out.println("이름 : " + s.getName());
      System.out.println("성별 : " + s.getGender());
      System.out.println("나이 : " + s.getAge());
    });
  }
}
