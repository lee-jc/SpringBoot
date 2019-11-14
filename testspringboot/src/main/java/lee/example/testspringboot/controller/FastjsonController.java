package lee.example.testspringboot.controller;

import lee.example.testspringboot.model.FastjsonTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FastjsonController {
    @RequestMapping("/fastjson")
    public FastjsonTest getFastjson(){
        FastjsonTest fastjsonTest=new FastjsonTest();
        fastjsonTest.setId(1);
        fastjsonTest.setString("fastjson test");
        fastjsonTest.setDate(new Date());
        fastjsonTest.setIgnore("你看不见我，略略略");
        return fastjsonTest;
    }
}
