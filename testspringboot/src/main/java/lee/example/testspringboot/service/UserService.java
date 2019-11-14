package lee.example.testspringboot.service;

import com.github.pagehelper.Page;
import lee.example.testspringboot.mapper.UserMapper;
import lee.example.testspringboot.model.TabUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Page<TabUser> getUsers() {
        return userMapper.getUsers();
    }

    /**
     * @Cacheable 在方法执行前Spring先查看缓存中是否存在，如果存在，则直接返回缓存数据，若不存在则调用方法并将方法返回值放进缓存
     * @CachePut 无论怎样，都会将方法的返回值放到缓存中。@CachePut的属性与@Cacheable保持一致
     */
    @Cacheable(cacheNames = "users",key = "#id")//使用ehcache.xml配置users缓存，用用户id作为缓存主键
    public TabUser selectById(long id){
        System.out.println("没有缓存，开始查询数据库……");
        //selectByPrimaryKey（）方法是Mapper4框架提供的公共方法之一
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * @CacheEvict 	将一条或多条数据从缓存中删除。
     */
    @CacheEvict(value = "users",key = "#id")
    public void evictUser(Long id) {
        System.out.println("evict user:" + id);
    }
}
