package lee.example.testspringboot.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//继承Mapper4框架写好的公共方法
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
