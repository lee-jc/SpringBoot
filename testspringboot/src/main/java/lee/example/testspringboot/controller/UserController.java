package lee.example.testspringboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lee.example.testspringboot.model.TabUser;
import lee.example.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController 复合注解，相当于@ResponseBody＋@Controller合在一起的作用,会自动返回json类型的数据
 * @ResponseBody 将java对象转为指定格式的数据，默认json，使用此注解之后不会再走视图解析器，而是直接将数据写入到输入流中
 * PS：如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 *     配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * PS：如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 *     如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

/**
 * @RequestMapping :将Http Get请求映射到特定处理程序方法(method = RequestMethod.GET)
 * @PostMapping :将Http Post请求映射到特定处理程序方法(method = RequestMethod.POST)
 * @RequestMapping可以看做@PostMapping,@PostMapping两个注解的父类（合体）
 */

    @RequestMapping("/users")
    public PageInfo<TabUser> lists(@RequestParam(defaultValue = "1")int pageNo, @RequestParam(defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<TabUser> pageInfo = new PageInfo<>(userService.getUsers());
        return pageInfo;
    }

/**
 *  @PathVariable 从路径里面获取参数（用来获得请求url中的动态参数）
 *  @RequestParam 从请求里面获取参数
 */
    @RequestMapping("/user/{id}")
    public TabUser selectById(@PathVariable("id")long id){
        return userService.selectById(id);
    }

    @RequestMapping("/user/del/{id}")
    public String delUser(@PathVariable("id") Long id){
        userService.evictUser(id);
        return "删除成功";
    }

}
