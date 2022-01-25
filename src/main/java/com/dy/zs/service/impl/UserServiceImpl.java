package com.dy.zs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dy.zs.pojo.User;
import com.dy.zs.dao.UserMapper;
import com.dy.zs.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bean
 * @since 2022-01-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
//    public User getUserByUsercode(String usercode){
//        QueryWrapper<User> wrapper=new QueryWrapper<>();
//        wrapper.eq("usercode",usercode);
//        return userMapper.selectOne(wrapper);
//    }
    public User checkpwd(String usercode){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("usercode",usercode);
        User user=userMapper.selectOne(wrapper);
        if(usercode==null){
            return null;
        }else{
            return user;
        }
    }
    public int  addUser(User user){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("usercode",user.getUsercode());
        User getteduser=userMapper.selectOne(wrapper);
        if (getteduser!=null){
            return 1;
        }else{
            userMapper.insert(user);
            return 0;
        }
    }
}
