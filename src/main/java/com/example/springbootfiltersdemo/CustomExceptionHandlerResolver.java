package com.example.springbootfiltersdemo;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandlerResolver extends DefaultHandlerExceptionResolver {
    public CustomExceptionHandlerResolver() {
        super();
        super.setOrder(Integer.MIN_VALUE);
      //  this.setOrder(Integer.MAX_VALUE);
    }

    @Override
    protected ModelAndView handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.getWriter().write("Custom error");
        ModelAndView modelAndView = new ModelAndView();
     //   modelAndView.setStatus(HttpStatus.NOT_ACCEPTABLE);
        return modelAndView;
    }

//    @Override
//    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("In CustomExceptionHandlerResolver");
//        if(((Exception)ex instanceof HttpMediaTypeNotAcceptableException))
//        {
//            try {
//                response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                response.getWriter().write("Custom error");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return new ModelAndView();
//        }
//        return doResolveException(request,response,handler,ex);
//
//    }
//
//
//
//
//    protected ModelAndView handleBindException(
//            BindException ex, HttpServletRequest request, HttpServletResponse response, @Nullable Object handler
//    ) throws IOException {
//        System.out.println("In CustomExceptionHandlerResolver");
//        if(((Exception)ex instanceof HttpMediaTypeNotAcceptableException))
//        {
//            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
//            response.getWriter().write("Custom error");
//            return new ModelAndView();
//        }
//         return doResolveException(request,response,handler,ex);
//    }


//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        if(ex instanceof HttpMediaTypeNotAcceptableException)
//        return new ModelAndView();
//        else
//            return null;
//    }
}