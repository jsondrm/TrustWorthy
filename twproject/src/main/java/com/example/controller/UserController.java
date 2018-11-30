package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    public String save(Model model){
        User user = new User("hwx","hwx","tester");
        System.out.println("开始存入数据库");
        userService.save(user);
        System.out.println("已经存入数据库");

        model.addAttribute("user",user);
        return "userInfo";
    }

    @RequestMapping("/delete/{username}")
    public String delete(@PathVariable String username){
        userService.delete(username);
        return "userList";
    }

    @RequestMapping("/update")
    public String update(User user){
        return "userList";

    }


    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("users",userList);
        return "userList";
    }

    @RequestMapping("/findByPage/{start}")
    public List<User> findByPage(@PathVariable int start, User user){
        Pageable pageable = new PageRequest(start,2);
        return userService.findByPage(user,pageable);
    }
    @GetMapping("/saveUser")
    public String userForm(Model model){
        model.addAttribute("user",new User("drm","drm","admin"));
        return "user";
    }
    @PostMapping("/showUser")
    public String userSubmit(@ModelAttribute User user){
        return "userInfo";
    }

    @RequestMapping("/list")
    public String listUser(Model model){
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 10; i ++){
            userList.add(new User("drm"+i,Integer.toString(20+i),"developer"+i));
        }
        model.addAttribute("users",userList);
        return "/userList";
    }
}
