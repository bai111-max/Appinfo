package com.bdqn.controller;

import com.bdqn.pojo.DevUser;
import com.bdqn.service.DevService;
import com.bdqn.utli.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dev")
public class DevLoginController {
    @Resource
    private DevService devService;

    @RequestMapping("/main")
    public  String main(HttpServletRequest request){
        request.getSession().getAttribute("devUserSession");
        if(devService == null){
            return "../403";
        }
        return "developer/main";
    }

   @RequestMapping(value = "/login")
    public String devLogin(){
       return "devlogin";
   }

   @RequestMapping(value = "devlogin",method = RequestMethod.POST)
    public String devlogin(HttpServletRequest request, @RequestParam String devCode, @RequestParam String devPassword){
       if(EmptyUtils.isNotEmpty(devCode) && EmptyUtils.isNotEmpty(devPassword)) {
           DevUser devUser=devService.devlogin(devCode,devPassword);
           if(EmptyUtils.isNotEmpty(devUser)){
               request.getSession().setAttribute("devUserSession",devUser);
               return "redirect:/dev/main";
           }else {
               request.setAttribute("error","用户名或密码错误");
               return "devlogin";
           }
       }else {
           request.setAttribute("error","用户名或密码不能为空");
           return "devlogin";
       }
   }
}
