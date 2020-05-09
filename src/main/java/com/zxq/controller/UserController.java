package com.zxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/index")
    public  String index(){
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

    @GetMapping("/search")
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

    @PostMapping("/admin/index")
    public  String adminIndex(){
        return "admin/index";
    }

    @GetMapping("/admin/login")
    public  String adminLogin(){
        return "admin/login";
    }

    @GetMapping("/admin/blogs")
    public  String adminBlogs(){
        return "admin/blogs";
    }

    @GetMapping("/admin/blogs/input")
    public  String adminBlogsInput(){
        return "admin/blogs-input";
    }

    @GetMapping("/admin/tags")
    public  String adminTags(){
        return "admin/tags";
    }

    @GetMapping("/admin/tags/input")
    public  String adminTagsInput(){
        return "admin/tags-input";
    }

    @GetMapping("/admin/types")
    public  String adminTypes(){
        return "admin/types";
    }

    @GetMapping("/admin/types/input")
    public  String adminTypesInput(){
        return "admin/types-input";
    }

}
