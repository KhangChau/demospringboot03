package com.cybersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller : đường dẫn đang quy định trả ra nội dung chỉ là HTML / giao diện
 *
 * @ResponseBody : Giúp cho @Controller có thể trả kiểu String dùng để viết API
 *
 * @RestController : đường dẫn đang quy định trả ra nội dung là API / JSON / chuỗi
 */
//      /hello/cybersoft
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello() {
        return "Hello Spring Boot!\n";
    }

    @GetMapping("/cybersoft")
    public String cybersoft() {
        return "Hello Cybersoft!\n";
    }
}
