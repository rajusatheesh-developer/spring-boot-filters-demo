//package com.example.springbootfiltersdemo;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpMediaTypeNotAcceptableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class Handker
//{
//    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//    public final ResponseEntity<String> handleHttpMediaTypeNotAcceptableException(
//            HttpMediaTypeNotAcceptableException e, HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).contentType(MediaType.APPLICATION_JSON)
//                .body("error");
//    }
//}
