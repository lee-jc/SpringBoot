package lee.example.testspringboot.mapper;

import com.github.pagehelper.Page;
import lee.example.testspringboot.base.BaseMapper;
import lee.example.testspringboot.model.TabUser;


public interface UserMapper extends BaseMapper<TabUser> {
    Page<TabUser> getUsers();
}
