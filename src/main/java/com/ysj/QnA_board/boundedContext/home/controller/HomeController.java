package com.ysj.QnA_board.boundedContext.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/home")
@Controller
public class HomeController
{
  @GetMapping("/main")
  @ResponseBody
  public String main()
  {
    return "/home/main";
  }
}
