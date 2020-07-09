package com.zxq.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.pojo.Blog;
import com.zxq.pojo.Type;
import com.zxq.pojo.User;
import com.zxq.service.BlogService;
import com.zxq.service.TagService;
import com.zxq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String blog(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Blog> blogList = blogService.findBlogAll();
        for (Blog blog:blogList){
            blog.setType(typeService.findById(blog.getType().getId()));
        }
        PageInfo<Blog>  pageInfo = new PageInfo<Blog>(blogList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public String saveBlog(Model model) {
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/input")
    public String saveBlogDo(Blog blog, RedirectAttributes attributes, HttpSession session)  {
        blog.setType(typeService.findById(blog.getType().getId()));
        blog.setUser((User) session.getAttribute("user"));
        int i =blogService.saveBlog(blog);
        if (i > 0) {
            attributes.addFlashAttribute("message", "新增成功");
        } else {
            attributes.addFlashAttribute("message", "新增失败");
        }

        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/update/{id}")
    public String updateBlog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("blog", blog);
        return "admin/blogs-update";
    }

    @PostMapping("/blogs/update")
    public String updateBlogDo(Blog blog, RedirectAttributes attributes, HttpSession session) {
        int i = blogService.updateBlog(blog);
        if (i > 0) {
            attributes.addFlashAttribute("message", "修改成功");
        } else {
            attributes.addFlashAttribute("message", "修改失败");
        }

        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable Long id,RedirectAttributes attributes) {
        int i = blogService.deleteBlog(id);
        if (i > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("message", "删除失败");
        }

        return "redirect:/admin/blogs";
    }

}
