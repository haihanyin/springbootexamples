package com.github.hh.sbes.mvc.view;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
public class BookController {

    @RequestMapping(value = "/showBookWithModel", method = GET)
    public String showBookWithModel(Model dataModel) {
        dataModel.addAttribute("name", "xman");
        dataModel.addAttribute("price", 12.3);
        return "showBook";
    }

    @RequestMapping(value = "/showBookWithModelView", method = GET)
    public ModelAndView showBookWithModel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "xman");
        modelAndView.addObject("price", 12.3);
        modelAndView.setViewName("showBook");
        return modelAndView;
    }

    @GetMapping(value = "/showBookWithResponseEnity")
    public ResponseEntity showBookWithResponseEntity(ResponseEntity responseEntity) {
        return new ResponseEntity<String>("this is a book", HttpStatus.OK);
    }

    @GetMapping(value = "/showBookWithMap")
    @ResponseBody
    public Map showBookWithResponseEntity() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xman");
        map.put("price", 12.3f);
        return map;
    }
}
