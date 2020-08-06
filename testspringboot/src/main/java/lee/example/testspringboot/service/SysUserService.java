package lee.example.testspringboot.service;

import lee.example.testspringboot.mapper.SysUserMapper;
import lee.example.testspringboot.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser findByUserName(String userName){
        return sysUserMapper.findByUserName(userName);
    }

}
