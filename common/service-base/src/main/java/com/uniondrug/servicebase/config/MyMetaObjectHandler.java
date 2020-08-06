package com.uniondrug.servicebase.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ：SaoBai
 * @motto ：不忘初心
 * @date ：Created in 2020/8/6 20:53
 * @Function :
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override

    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("gmtCreate", new Date(), metaObject);

        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }


    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}