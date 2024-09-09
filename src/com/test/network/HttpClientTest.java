package com.test.network;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.net.http.HttpClient.Version;

public class HttpClientTest {
  public static void main(String[] args) throws Exception {
    
    String address = "http://127.0.0.1:8080/board/write";
    Map<String, String> params = new HashMap<>();
    params.put("writer", "홍홍홍");
    params.put("title", "안녕하세요");
    params.put("content", "배불러요");
    String[] headers = {"content-type", "application/x-www-form-urlencoded"};
    
    HttpClientRun.post(address, params, headers);

  }
}

class HttpClientRun {

  public static void get() throws Exception {

    // HEADER 값 설정
    String address = "http://127.0.0.1:8080/board/write";
    // HEADER 설정 규칙 = {"key", "value"}
    String[] headers = {"content-type", "text/html"};
    HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

    // 동기 방식
    String result = client.sendAsync(HttpRequest.newBuilder(
        new URI(address)).GET().headers(headers).build()
      , HttpResponse.BodyHandlers.ofString()
    ).thenApply(HttpResponse::body).get().toString();

    System.out.println(result);

  }

  public static void post(String address, Map<String, String> params, String[] headers) 
    throws Exception {

    // (Request 요청 값)을 받아서 서버에서 작업 후 결과(HTTP Response 메세시 중 Body)를 리턴
    BodyPublisher body = BodyPublishers.ofString(getFormDataAsString(params));
    HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
    HttpResponse<String> response = client.send(
        HttpRequest.newBuilder(new URI(address)).POST(body).headers(headers).build()
        , HttpResponse.BodyHandlers.ofString()
    );

    System.out.println(response);
  }

  public static String getFormDataAsString(Map<String, String> formDate) {
    
    StringBuilder formBodyBuilder = new StringBuilder();
    for (Entry<String, String> singleEntry : formDate.entrySet()) {
      
      if(formBodyBuilder.length() > 0) {formBodyBuilder.append("&");}
      formBodyBuilder.append(URLEncoder.encode(
                            singleEntry.getKey(), StandardCharsets.UTF_8));
      formBodyBuilder.append("=");
      formBodyBuilder.append(URLEncoder.encode(
                            singleEntry.getValue(),StandardCharsets.UTF_8));
    }
    return formBodyBuilder.toString();
  }

}
