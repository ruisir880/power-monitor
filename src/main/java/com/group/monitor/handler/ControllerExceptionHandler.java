package com.group.monitor.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
/**
 * @Description:自定义错误页面
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * @Description:错误信息返回页面
     * @param: request
     * @param: e
     * @return:ModelAadView
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
            ModelAndView mv=new ModelAndView();
            mv.addObject("url",request.getRequestURL());
            mv.addObject("exception" ,e);
            mv.setViewName("error");
            return  mv;
        }
}
