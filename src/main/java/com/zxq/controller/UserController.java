package com.zxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/index")
    public  String index(){
        /*String ss= null;
        if(ss==null){
            throw new  NotFindException("博客不存在");
        }*/
       // int i=9/0;
        return "index";
    }

    @GetMapping("/_fragments")
    public  String fragments(){
        return "_fragments";
    }

    @GetMapping("/about")
    public  String about(){
        return "about";
    }

    @GetMapping("/archives")
    public  String archives(){
        return "archives";
    }

    @GetMapping("/blog")
    public  String blog(){
        return "blog";
    }

    @PostMapping("/search")
    public  String search(){
        return "search";
    }

    @GetMapping("/tags")
    public  String tags(){
        return "tags";
    }
    @GetMapping("/types")
    public  String types(){
        return "types";
    }



    @GetMapping("/admin/blogs")
    public  String adminBlogs(){
        return "admin/blogs";
    }

    @GetMapping("/admin/blogs/input")
    public  String adminBlogsInput(){
        return "admin/blogs-input";
    }







}
