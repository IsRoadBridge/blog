package com.zxq.controller.admin;

import com.zxq.pojo.Blog;
import com.zxq.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public  String  blog(){
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public  String  saveBlog(){
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/input")
    public  String saveBlogDo(Blog blog, RedirectAttributes attributes){
        int i= blogService.saveBlog(blog);
        if(i>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }

        return "redirect:/admin/blogs";
    }

}
