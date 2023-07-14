package com.paul.springmvc;

import com.paul.springmvc.model.Anime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

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
        modelAndView.addObject("num3", num1 + num2);

        return modelAndView;
    }

    @PostMapping("addAnime")
    public String addAnime(@ModelAttribute("anime") Anime anime) {  //? Model attribute

        /*Anime anime = new Anime();
        anime.setId(id);
        anime.setName(name);
        model.addAttribute( "anime", anime);*/

        return "result";
    }

    @GetMapping("getAnime")
    public String getAnime(Model model) {
        List<Anime> animeList = Arrays.asList(
                new Anime(
                        101, "Zatchbell"
                ),
                new Anime(
                        102, "Brago"
                ),
                new Anime(
                        103, "Tia"
                ),
                new Anime(
                        104, "Zino"
                )
        );
        model.addAttribute("result", animeList);
        return "showAnime";
    }

}
