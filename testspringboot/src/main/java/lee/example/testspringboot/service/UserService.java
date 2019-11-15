package lee.example.testspringboot.service;

import com.github.pagehelper.Page;
import lee.example.testspringboot.mapper.UserMapper;
import lee.example.testspringboot.model.TabUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


public interface UserService {
    public Page<TabUser> getUsers();
    public TabUser selectById(long id);
    public void evictUser(Long id);
}
