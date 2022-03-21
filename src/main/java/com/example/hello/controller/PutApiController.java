package com.example.hello.controller;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

  @PutMapping("/put")
  public void put(@RequestBody PutRequestDto requestDto){

    System.out.println(requestDto);

  }

  @PutMapping("/put02")
  public PutRequestDto put02(@RequestBody PutRequestDto requestDto) {

    System.out.println(requestDto);
    return requestDto;
  }

  @PutMapping("/put03/{userId}")
  public PutRequestDto put03(@RequestBody PutRequestDto requestDto, @PathVariable(name="userId") Long id) {

    System.out.println(id);
    return requestDto;

  }

}
