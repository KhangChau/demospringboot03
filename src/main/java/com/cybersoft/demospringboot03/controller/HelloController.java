package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.payload.response.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Tham số truyền trên trình duyệt :            @RequestParam
    // Tham số truyền ngầm :                        @RequestParam
    // Tham số đóng vai trò như là 1 đường dẫn :    @PathVariable
    // Tham số là đối tượng :                       @RequestBody


    @GetMapping("")
    public String hello(@RequestParam String hoten, @RequestParam int tuoi) {
        return "Hello Spring Boot " + hoten + " " + tuoi + "\n";
    }
    //----------------------------------------------------------------------------------------
    //method = POST ~~ có 3 kiểu parameters
    // form-data : có hỗ trợ truyền file lên
    // x-ww-form-urlencode : không có hỗ trợ truyền file lên
    // raw : hỗ trợ truyền 1 đối tượng lên
    @PostMapping("/cybersoft")
    public String cybersoft(@RequestBody LoginRequest loginRequest) {
        return "Hello Cybersoft!" + " _username: " + loginRequest.getUsername() + "_password: " + loginRequest.getPassword() + "\n";
    }
    //----------------------------------------------------------------------------------------
    @PutMapping("/update/{id}") //id la ten tham so
    public ResponseEntity<?> update(@PathVariable int id) {
        return new ResponseEntity<>("Update_" + id, HttpStatus.OK);
    }
}
