package majiang.comunity.controller;

import majiang.comunity.dto.QuestionDTO;
import majiang.comunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by lenovo on 2020/3/11.
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //浏览数统计
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }

}
