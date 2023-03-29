package com.example.springbootfiltersdemo;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(value = "/api")
public class HomeController
{

    @ApiOperation(value = "It will return list of Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Invalid ID supplied"),
            @ApiResponse(code = 406, message = "My custom error")})
    @GetMapping(value = "/{name}")
     public User getName(@PathVariable String name)
    {
        User user=null;
        user.setName(name);
        return user;
    }
}
