package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//POST로 들어오는 json 데이터를 매핑하기 위해서는 RequestBody 어노테이션을 명시해줘야 한다.
@RestController
@RequestMapping("/api")
public class PostApiController {


  @PostMapping("/post")
  public void post(@RequestBody Map<String, Object> requestData){

    /*requestData.entrySet().forEach(entry -> {

      System.out.print("key : " + entry.getKey() + " ");
      System.out.println("value : " + entry.getValue() );
    });*/

    requestData.forEach((key, value) -> {
      System.out.print("key : " + key  + " ");
      System.out.print("value : " + value  + " ");
    });

  }

  @PostMapping(path = "/post02")
  public void post02(@RequestBody PostRequestDto dto){

    System.out.println(dto);

  }

}
