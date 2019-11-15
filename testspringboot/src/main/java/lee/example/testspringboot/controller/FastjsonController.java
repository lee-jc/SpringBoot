package lee.example.testspringboot.controller;

import lee.example.testspringboot.model.FastjsonTest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    /**
     * 没有加shiro权限注解
     * @return
     */
    @RequestMapping("/test1")
    public String test1(){
        return "你只是个普通人";
    }

    /**
     * 添加了shiro权限注解，需要用户有"systemUserAdd"权限
     * @return
     */
    @RequestMapping("/test2")
    @RequiresPermissions("systemUserAdd")
    public String test2(){
        return "您是大佬管理员";
    }
}
