package com.zxq.controller.admin;

import com.zxq.pojo.Tag;
import com.zxq.pojo.Type;
import com.zxq.service.TagService;
import com.zxq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public  String tags(Model model){
       List<Type> types = typeService.findAll();
       model.addAttribute("types",types);
      return "admin/types";
    }

    @GetMapping("/input")
    public  String tagInput(){
     return "admin/types-input";
    }

    @PostMapping("/input")
    public  String tagInputDo( String name, RedirectAttributes attributes,Model model){
        Type type = typeService.findByName(name);
        if(type != null){
            model.addAttribute("message","该分类已存在，请勿重复添加");
            return  "admin/types-input";
        }
        int i =typeService.save(name);
        if(i>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/update/{id}")
    public  String tagUpdate(@PathVariable Long id,Model model){
        Type type = typeService.findById(id);
        System.out.println(type);
        model.addAttribute("type",type);
        return "admin/types-update";
    }

    @PostMapping("/update")
    public  String tagUpdateDo(Type type,RedirectAttributes attributes){
       int i = typeService.update(type);
        if(i>0){
            attributes.addFlashAttribute("message","修改成功");
        }else{
            attributes.addFlashAttribute("message","修改失败");
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id,RedirectAttributes attributes){
        int i = typeService.delete(id);
        if(i>0){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }

        return "redirect:/admin/types";
    }

}
