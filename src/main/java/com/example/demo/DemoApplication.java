package com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/index")

public class DemoApplication {

    private final UserService userService;

    public DemoApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "non-param request api method";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable Long id) {
        System.out.println("id="+id);
        return "GET get variable " + id;
    }

//    @GetMapping
//    public String index2(@RequestParam Long id, @RequestParam String name) {
//        System.out.printf("id = %s, name = %s\n", id, name);
//        return "GET id = " + id + " name = " + name;
//    }

    @PostMapping
    public String save(@RequestBody Map<String, String> map) {
        System.out.println(map.toString());
        return "Post Saving!";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Map<String, String> map) {
        System.out.printf("ID = %s, name = %s", id, map);
        return "Put update successful";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("id = " + id);
        return "delete successful";
    }
}
