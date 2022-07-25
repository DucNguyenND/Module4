package com.controllers;

import com.model.Comment;
import com.model.MyBlog;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.service.MyBlogService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class Home {
    @Autowired
    MyBlogService myBlogService;
    @Autowired
    CommentService commentService;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("blog",myBlogService.getall(PageRequest.of(page,6, Sort.by("id"))));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("blog",new MyBlog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBlog(@Valid @ModelAttribute("blog") MyBlog myBlog, BindingResult bindingResult, @RequestParam MultipartFile upimage){
        String nameImg = upimage.getOriginalFilename();
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("create");
            return modelAndView;
        }
        try {
            FileCopyUtils.copy(upimage.getBytes(),new File("\\Users\\DucNguyen\\Desktop\\module4\\blog\\src\\main\\webapp\\WEB-INF\\image\\" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myBlog.setImg("/"+ nameImg);
        myBlogService.save(myBlog);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
    @GetMapping("/read")
    public ModelAndView read(@RequestParam int id){
        myBlogService.findBlogbyid(id);
        ModelAndView modelAndView=new ModelAndView("showblog");
        modelAndView.addObject("blog",myBlogService.findBlogbyid(id));
        modelAndView.addObject("newcomment",new Comment());
        modelAndView.addObject("comment",commentService.findCommentbyBlog(myBlogService.findBlogbyid(id)));
        return modelAndView;}


        @PostMapping("/read")
        public ModelAndView savecomment(@Valid @ModelAttribute("newcomment") Comment comment){
        commentService.saveCommnet(comment);
        ModelAndView modelAndView=new ModelAndView("redirect:/read");
        return modelAndView;
        }
}
