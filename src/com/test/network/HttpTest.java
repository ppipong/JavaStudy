package com.test.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class TestHttpRequest {

  public static void TestHttpRequest(String targetURL, String parameter) 
    throws IOException{
    
    HttpURLConnection connection = null;
    
    // URL 객체 생성
    URL url = new URL(targetURL);
    // HTTP Server와의 Connection설정
    connection = (HttpURLConnection)url.openConnection();
    
    // HTTP Request 메세지의 헤드 값 
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setRequestProperty("Content-Language", "ko-KR");
    
    // HTTP 서버로 데이터 전송 시 행할 선택 사항
    connection.setUseCaches(false); // 캐쉬 설정 안함
    connection.setDoOutput(true); // 위의 설정대로 HTTP서버로 보내는 유무
    
    // Request 값 전송
    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
    // Body 값 전송
    wr.write(parameter.getBytes("UTF-8"));
    // 임시로 버퍼에 저장된 값을 출력(전송)
    wr.flush();
    wr.close();

    int responseCode = connection.getResponseCode();
    BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

    StringBuilder response = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      response.append(line).toString();
      response.append("\r\n");
    }
    rd.close();

    System.out.println("HTTP 응답 코드 : " + responseCode);
    System.out.println("HTTP 응답 헤더 : " + connection.getHeaderFields());
    System.out.println("HTTP BODY : " + response.toString());

    connection.disconnect();

  }
  
}
public class HttpTest {

  public static void main(String[] args) throws IOException {

    String targetURL = "http://127.0.0.1:8080/board/write";
    String parameters = "writer=밈밈&title=배고푸다&content=밥먹고커피ㄱㄱ";
    
    TestHttpRequest.TestHttpRequest(targetURL, parameters);
    
  }
}
