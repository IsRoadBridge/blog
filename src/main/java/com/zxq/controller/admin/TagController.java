package com.zxq.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.pojo.Blog;
import com.zxq.pojo.Tag;
import com.zxq.service.TagService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public  String tags(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                        Model model){
        PageHelper.startPage(pageNum,2);
       List<Tag> tags = tagService.findAll();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tags);
       model.addAttribute("pageInfo",pageInfo);
      return "admin/tags";
    }

    @GetMapping("/input")
    public  String tagInput(){
     return "admin/tags-input";
    }

    @PostMapping("/input")
    public  String tagInputDo( String name, RedirectAttributes attributes,Model model){
        Tag tag = tagService.findByName(name);
        if(tag != null){
            model.addAttribute("message","该标签已存在，请勿重复添加");
            return  "admin/tags-input";
        }
        int i =tagService.save(name);
        if(i>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }

        return "redirect:/admin/tags";
    }

    @GetMapping("/update/{id}")
    public  String tagUpdate(@PathVariable Long id,Model model){
        Tag tag = tagService.findById(id);
        System.out.println(tag);
        model.addAttribute("tag",tag);
        return "admin/tags-update";
    }

    @PostMapping("/update")
    public  String tagUpdateDo(Tag tag,RedirectAttributes attributes){
       int i = tagService.update(tag);
        if(i>0){
            attributes.addFlashAttribute("message","修改成功");
        }else{
            attributes.addFlashAttribute("message","修改失败");
        }

        return "redirect:/admin/tags";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id,RedirectAttributes attributes){
        int i = tagService.delete(id);
        if(i>0){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }

        return "redirect:/admin/tags";
    }

}
