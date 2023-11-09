package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.entity.Student;
import com.cybersoft.demospringboot03.entity.UsersEntity;
import com.cybersoft.demospringboot03.payload.response.LoginRequest;
import com.cybersoft.demospringboot03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private Student studentIOC;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<?> hello() {
        List<UsersEntity> list = userRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //----------------------------------------------------------------------------------------
    //method = POST ~~ có 3 kiểu parameters
    // form-data : có hỗ trợ truyền file lên
    // x-ww-form-urlencode : không có hỗ trợ truyền file lên
    // raw : hỗ trợ truyền 1 đối tượng lên
    @PostMapping("/cybersoft")
    public String cybersoft(@RequestBody LoginRequest loginRequest) {
        return "Hello Cybersoft!" + " _username: " + loginRequest.getUsername() + "_password: " + loginRequest.getPassword();
    }
    //----------------------------------------------------------------------------------------
    @PutMapping("/update/{id}") //id la ten tham so
    public ResponseEntity<?> update(@PathVariable int id) {
        return new ResponseEntity<>("Update_" + id, HttpStatus.OK);
    }
}
