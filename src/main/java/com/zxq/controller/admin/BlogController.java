package com.zxq.controller.admin;

import com.zxq.pojo.Blog;
import com.zxq.pojo.User;
import com.zxq.service.BlogService;
import com.zxq.service.TagService;
import com.zxq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public  String  blog(Model model){
        List<Blog> blogList=blogService.findBlogAll();
        System.out.println(blogList);
        model.addAttribute("blogs",blogList);
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public  String  saveBlog(Model model){
        model.addAttribute("types",typeService.findAll());
        model.addAttribute("tags",tagService.findAll());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/input")
    public  String saveBlogDo(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setType(typeService.findById(blog.getType().getId()));
        blog.setUser((User) session.getAttribute("user"));
        int i= blogService.saveBlog(blog);
        if(i>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }

        return "redirect:/admin/blogs";
    }

}
