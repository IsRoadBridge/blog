package com.zxq.controller;

import com.zxq.pojo.Blog;
import com.zxq.pojo.Type;
import com.zxq.service.BlogService;
import com.zxq.service.TypeService;
import com.zxq.service.UserService;
import com.zxq.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String index(Model model) {
        List<Blog> blogs = blogService.findBlogAll();
        List<Blog> blogsTop = blogService.findBlogTop(6);
        List<Type> types = typeService.findByTop();
        for (Blog blog : blogs) {
            blog.setUser(userService.findUserById(blog.getUser().getId()));
            blog.setType(typeService.findById(blog.getType().getId()));
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("blogsTop", blogsTop);
        model.addAttribute("types", types);
        model.addAttribute("size", blogs.size());
        return "index";
    }

    @GetMapping("/_fragments")
    public String fragments() {
        return "_fragments";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/archives")
    public String archives() {
        return "archives";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        blog.setUser(userService.findUserById(blog.getUser().getId()));
        blog.setType(typeService.findById(blog.getType().getId()));
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        model.addAttribute("blog", blog);
        return "blog";
    }

    @PostMapping("/search")
    public String search(String query, Model model) {
        List<Blog> blogs = blogService.findBlogBySearch(query);
        for (Blog blog : blogs) {
            blog.setUser(userService.findUserById(blog.getUser().getId()));
            blog.setType(typeService.findById(blog.getType().getId()));
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("query", query);
        model.addAttribute("size", blogs.size());
        return "search";
    }

    @GetMapping("/tags")
    public String tags() {
        return "tags";
    }

    @GetMapping("/types/{id}")
    public String types(@PathVariable Long id, Model model) {
        List<Type> types = typeService.findByTop();
        if (id == -1) {
            id = types.get(0).getId();
        }
        List<Blog> blogs = blogService.findBlogByTypeId(id);
        for (Blog blog : blogs) {
            blog.setUser(userService.findUserById(blog.getUser().getId()));
            blog.setType(typeService.findById(blog.getType().getId()));
        }
        model.addAttribute("types", types);
        model.addAttribute("blogs", blogs);
        model.addAttribute("activeTypeId", id);
        return "types";
    }


}
