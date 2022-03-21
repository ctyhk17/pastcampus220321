package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

  private String account;
  private String email;
  private String address;
  private String password;

  //카멜케이스로 된 java 변수와 스네이크케이스로된 json 데이터를 매핑하기위해
  @JsonProperty("phone_number")
  private String phoneNumber; // phone_number

  //혹은 위에 같은 경우가 아닌 카멜도 아니고 스네이크도 이도저도 아닌 케이스 일경우에도 매핑하기 위해 사용한다.
  @JsonProperty("OTP")
  private String OTP;

  public String getOTP() {
    return OTP;
  }

  public void setOTP(String OTP) {
    this.OTP = OTP;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }



  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "PostRequestDto{" +
      "account='" + account + '\'' +
      ", email='" + email + '\'' +
      ", address='" + address + '\'' +
      ", password='" + password + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", OTP='" + OTP + '\'' +
      '}';
  }
}
