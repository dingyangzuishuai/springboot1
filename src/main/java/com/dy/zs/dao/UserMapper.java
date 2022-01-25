package com.dy.zs.dao;

import com.dy.zs.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bean
 * @since 2022-01-22
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
