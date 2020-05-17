package com.zxq.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private  final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    public ModelAndView  exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request Url:{},Error:{}",request.getRequestURL(),e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
            throw  e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("Request Url",request.getRequestURL());
        mv.addObject("Exception",e);
        mv.setViewName("error/error");
        return  mv;
    }
}
