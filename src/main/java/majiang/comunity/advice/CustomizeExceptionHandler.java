package majiang.comunity.advice;

import majiang.comunity.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常拦截（处理）
 * Created by lenovo on 2020/3/12.
 */
//@ControllerAdvice
public class CustomizeExceptionHandler {

    //@ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model){
        if(e instanceof CustomizeException){
            model.addAttribute("message", e.getMessage());
        }else{
            model.addAttribute("message", "服务器冒烟了，请稍等下再试试");
        }
        //跳转到错误页面
        return new ModelAndView("error");
    }
}
