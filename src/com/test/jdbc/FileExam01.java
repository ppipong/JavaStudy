package com.test.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class MachineInfo { //DTO : Data Transfer Object
  // private int seqno; 
  private String machinename;
  private String managername;
  private int temperature;
  private int power;
  private int runtime;

  // setter
  public MachineInfo(String machinename, String managername, int temperature, int power, int runtime) {
    this.machinename = machinename;
    this.managername = managername;
    this.temperature = temperature;
    this.power = power;
    this.runtime = runtime;
  }
 
  // getter
  public String getMachinename() {
    return this.machinename = machinename;
  }
  public String getManagername() {
    return this.managername = managername;
  }
  public int getTemperature() {
    return this.temperature = temperature;
  }
  public int getPower() {
    return this.power = power;
  }
  public int getRuntime() {
    return this.runtime = runtime;
  }
  
}

class FileManager {

  public static void fileReader() throws IOException, ClassNotFoundException, SQLException {

    BufferedReader reader = new BufferedReader(new FileReader(
      "C:\\Repository\\machine\\MachineLog.txt"
      , Charset.forName("UTF-8")));

    String str;
    String query;
    String[] lineArray;

    while ((str = reader.readLine()) != null) {
    
      lineArray = str.split(","); // , 구분자 
      query = "";
      query = "INSERT INTO tbl_machine"+
              "(" +
                "machinename" +
                ",managername" +
                ",temperature" +
                ",power" +
                ",runtime" +
              ")" +
              "VALUES (\'" + lineArray[0] +"\',\'" +
                lineArray[1] +"\'," +
                lineArray[2] +"," +
                lineArray[3] +"," +
                lineArray[4] +")";
      // System.out.println("query : " + query + "\n");
      DBControl.insertDB(query);
    }

    reader.close();

  }
}

class DBControl {

  private final static String uri = "jdbc:mariadb://127.0.0.1:3306/webdev";
  private final static String userid = "webmaster";
  private final static String userpw = "12345";

  public static void insertDB(String query) throws 
              ClassNotFoundException, SQLException{
    Connection con;
    Statement stmt;

    Class.forName("org.mariadb.jdbc.Driver");
    con = DriverManager.getConnection(uri, userid, userpw);
    stmt = con.createStatement();
    stmt.executeUpdate(query);

    if(stmt != null) stmt.close();
    if(con != null) con.close();

  }

}

public class FileExam01 {
  public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    FileManager.fileReader(); // 파일에서 값을 읽어온다
  }
}
