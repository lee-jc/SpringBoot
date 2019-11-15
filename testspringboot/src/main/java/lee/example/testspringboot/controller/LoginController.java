package lee.example.testspringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    /**
     * get请求，登录页面跳转
     */
    @GetMapping("/login")
    public String login() {
        //如果认证通过，直接跳转到首页
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * post请求，表单提交登录
     */
    @PostMapping("/login")
    public Object login(String username, String password, Model model){
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            user.login(token);
            return "redirect:/index";
        }catch (UnknownAccountException e){
            model.addAttribute("message","账号不存在");
        }catch (DisabledAccountException e){
            model.addAttribute("message","账号未启用");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
        }catch (Throwable e){
            model.addAttribute("message","未知错误");
        }
        return "login";
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

}
