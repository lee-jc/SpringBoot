package lee.example.testspringboot.mapper;

import lee.example.testspringboot.model.SysUser;

public interface SysUserMapper {
    SysUser findByUserName(String userName);
}
