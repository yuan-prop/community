package majiang.comunity.advice;

import com.alibaba.fastjson.JSON;
import majiang.comunity.dto.ResultDTO;
import majiang.comunity.exception.CustomizeErrorCode;
import majiang.comunity.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义异常拦截（处理）
 * Created by lenovo on 2020/3/12.
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response){
        String contentType = request.getContentType();
        //当请求的contentType为application/json时
        if("application/json".equals(contentType)){
            ResultDTO resultDTO;
            //返回 JSON
            if(e instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException) e);
            }else{
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));//对象转json
                writer.close();
            } catch (IOException ioe) {
            }
            return null;

        }else{//当请求的contentType为text/html时
            if(e instanceof CustomizeException){
                model.addAttribute("message", e.getMessage());
            }else{
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            //跳转到错误页面
            return new ModelAndView("error");
        }
    }
}
