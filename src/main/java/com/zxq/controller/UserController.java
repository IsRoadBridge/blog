package com.zxq.controller;

import com.zxq.pojo.Blog;
import com.zxq.pojo.Type;
import com.zxq.service.BlogService;
import com.zxq.service.TypeService;
import com.zxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/index")
    public  String index(Model model){
        List<Blog> blogs =blogService.findBlogAll();
        List<Blog> blogsTop=blogService.findBlogTop(6);
        List<Type> types =typeService.findByTop();
        System.out.println(types);
        for (Blog blog:blogs) {
          blog.setUser(userService.findUserById(blog.getUser().getId()));
          blog.setType(typeService.findById(blog.getType().getId()));
        }
        model.addAttribute("blogs",blogs);
        model.addAttribute("blogsTop",blogsTop);
        model.addAttribute("types",types);
        model.addAttribute("size",blogs.size());
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











}
