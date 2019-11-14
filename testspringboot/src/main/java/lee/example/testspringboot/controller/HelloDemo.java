package lee.example.testspringboot.controller;

import lee.example.testspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDemo {
//    @Value("${hello.name}")
//    String name;
//    @Value("${hello.age}")
//    String age;
//    @Value("${hello.address}")
//    String address;

    @Autowired
    User user;

    @RequestMapping("/hello")
    public String Hello() {
        System.out.println("hello, " + user.getName());
        return "大家好，我的名字是" + user.getName() + "，我今年" + user.getAge() + "岁了，我在" + user.getAddress() + "工作！";
    }


}
