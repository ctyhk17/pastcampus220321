package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//GET METHOD 사용 방법 2022.03.21
@RestController
@RequestMapping("/api/get")
public class GetApiController {

  //명시적으로 주소값 지정 => 얘는 Path다.
  @GetMapping(path="/hello") //http://localhost:9090/api/get/hello
  public String hello(){
    return "get Hello";
  }

  @RequestMapping(path="/hi" , method= RequestMethod.GET) //get http://localhost:9090/api/get/hi
  public String hi(){
    return "hi";
  }
  //pathVariable받는법
  //http://localhost:9090/api/get/path-variable/{name} 주소엔 대문자 안쓴다
  @GetMapping("/path-variable/{name}")
  public String pathVariable(@PathVariable String name){ //GetMapping에 {name}을 지정하고 매개변수에서 동일한 명칭으로 해야 매핑되어 받음
    System.out.println("PathVariable : " + name);
    return name;
  }


  //경로의 변수와 매개변수의 명칭을 다르게 해야 할때는 PathVariable의 name속성에서 경로의변수명을 등록하면 매핑된다.
  @GetMapping("/path-variable2/{name}")
  public String pathVariable2(@PathVariable(name = "name") String pathName){
    System.out.println("PathVariable2 : " + pathName);
    return pathName;
  }


  //queryparameter

  //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30

  //queryparam은 @RequestParam 어노테이션을 지정해야 인자값을 받을수 있음
  @GetMapping(path = "query-param")
  public String queryParam(@RequestParam Map<String, String> queryParam){

    StringBuilder sb = new StringBuilder();

    queryParam.entrySet().forEach( entry -> {
      System.out.print("KEY : " + entry.getKey() + " ");
      System.out.println("Value : " + entry.getValue());
      System.out.println("\n");
      sb.append(entry.getKey()+" = " +  entry.getValue()+"\n");
    });


    return sb.toString();
  }

  @GetMapping("query-param02")
  public String queryParam02(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam int age
  ){

    return name+" " + email +" " + age;

  }

  //DTO로 값을 받을때는 RequestParam 어노테이션을 사용하지 않는다.
  //Spring-boot 자체에서 클래스의 변수와 경로의 쿼리 파라미터의 변수를 매핑하여 값을 받아준다.
  @GetMapping(path = "query-param03")
  public String queryParam03(UserRequest userRequest){

    System.out.println(userRequest.getName());
    System.out.println(userRequest.getEmail());
    System.out.println(userRequest.getAge());

    return userRequest.toString();

  }





}
