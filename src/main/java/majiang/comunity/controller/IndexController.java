package majiang.comunity.controller;

import majiang.comunity.dto.PaginationDTO;
import majiang.comunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2020/3/4.
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name = "page",defaultValue="1") Integer page,
                        @RequestParam(name = "size",defaultValue="2") Integer size){

        PaginationDTO pagination = questionService.listByUserId(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}