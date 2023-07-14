package com.paul.springmvc;

import com.paul.springmvc.model.Anime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    //? Model attribute at method level
    @ModelAttribute
    public void modelData(Model model) {
        model.addAttribute("name", "Anime");
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("Index page is requested...");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("number1") int num1, @RequestParam("number2") int num2) {

        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("num3", num1+num2);

        return modelAndView;
    }

    @RequestMapping("addAnime")
    public String addAnime(@ModelAttribute("anime") Anime anime) {  //? Model attribute

        /*Anime anime = new Anime();
        anime.setId(id);
        anime.setName(name);
        model.addAttribute( "anime", anime);*/

        return "result";
    }

}
