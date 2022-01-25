package com.dy.zs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bean
 * @since 2022-01-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField
    private String usercode;
    @TableField
    private String pwd;
    @TableField
    private String name;
    @TableField
    private String gender;
    @TableField
    private String s_class;

    public User(String usercode, String pwd, String name, String gender, String s_class) {
        this.usercode = usercode;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.s_class = s_class;
    }
}
