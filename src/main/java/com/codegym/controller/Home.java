package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Home {
    @Autowired
    CrudProduct crudProduct;

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("products", crudProduct.products);
        return "home";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request,Model model){
        int id= Integer.parseInt(request.getParameter("id"));
        for (int i = 0; i < crudProduct.products.size(); i++) {
            if (id==crudProduct.products.get(i).getId()){
                crudProduct.products.remove(i);
            }
        }
        model.addAttribute("products", crudProduct.products);
        return "home";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id,Model model){
        for (Product re: crudProduct.products
             ) {
            if (id==re.getId()){
                model.addAttribute("product",re);
                break;
            }
        }
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product){
        for (int i = 0; i < crudProduct.products.size(); i++) {
            if (crudProduct.products.get(i).getId()==product.getId()){
                crudProduct.products.get(i).setImg(product.getImg());
                crudProduct.products.get(i).setName(product.getName());
                crudProduct.products.get(i).setPrice(product.getPrice());
                break;
            }
        }
        return "redirect:/home";
    }
    @GetMapping("/create")
    public String create(){
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        crudProduct.products.add(product);
        return "redirect:/home";
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;
    @GetMapping("/validate")
    public String validate(){
    return "index";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam String email, Model model){
        if (!validate(email)){
            model.addAttribute("message","Email is invalid");
            return "index";
        }
        model.addAttribute("message","Email");
        return "index";
    }

    private boolean validate(String regex){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "TineZone";
    }
    @GetMapping("/TimeZone")
    public String TimeZone(){
        return "TineZone";
    }
    @GetMapping("/sandwich")
    public String sandwich(){
        return "saveSandWich";
    }

    @PostMapping("/sandwich")
    public ModelAndView sandwich(ModelAndView modelAndView,@RequestParam("name") String[]condition) {
        modelAndView = new ModelAndView("saveSandWich");
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }
    @GetMapping("/caculator")
                public String caculator(){
            return "Caculator";
        }

    @PostMapping("/caculator")
    public ModelAndView caculator(ModelAndView modelAndView,@RequestParam String type1,@RequestParam String type2 ,@RequestParam String mt){
        double result=0;
        int types1=Integer.parseInt(type1);
        int types2=Integer.parseInt(type2);
        switch (mt){
            case "cong":
                result= types1+types2;
                break;
            case "tru":
                result=types1-types2;
                break;
            case "nhan":
                result=types1*types2;
                break;
            case "chia":
                result=types1/types2;
                break;
        }
        modelAndView=new ModelAndView("Caculator");
        modelAndView.addObject("ketqua",result);
        return modelAndView;
    }
}
