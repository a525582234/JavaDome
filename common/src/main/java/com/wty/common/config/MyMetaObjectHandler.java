package com.wty.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Classname MetaObjectHandler
 * @Description 自动注入
 * @Date 2021/12/3 17:34
 * @@author wty
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        SccUser sccUser = SecureUtil.getUser();
//        if (sccUser != null) {
//            this.setFieldValByName("createUser", sccUser.getUserId(), metaObject);
//            this.setFieldValByName("updateUser", sccUser.getUserId(), metaObject);
//        }
        int length = metaObject.getOriginalObject().toString().length();
        // 获取原型实体对象
        Object originalObject = metaObject.getOriginalObject();
        // 当实体类一个字段都没有 , 并且一定是 lombok 生成的 toString() 也不会不成立 永远为true
        if(!"()".equals(metaObject.getOriginalObject().toString().substring(length-2,length))) {
            // 获取id字段名称
            String fieldNameId = getFieldNameId(metaObject);
            // 获取id的值
            String fieldIdVla = getFieldValueByFieldName(fieldNameId, originalObject);
            // id 值为空才生成新的ID
            if (StringUtils.isEmpty(fieldIdVla)) {
                this.setFieldValByName(getFieldNameId(metaObject), IdWorker.getId(),metaObject);
            }
        }
        String status = getFieldValueByFieldName("status", originalObject);
        if(StringUtils.isEmpty(status)){
            this.strictInsertFill(metaObject,"status",String.class, StringPool.ONE);
        }
        //添加数据的时候版本值是多少
        String version = getFieldValueByFieldName("version", originalObject);
        if (StringUtils.isEmpty(version)){
            this.strictInsertFill(metaObject,"version",String.class,StringPool.ONE);
        }
        //添加数据的时候逻辑删除对应值是多少
        String isDelete = getFieldValueByFieldName("isDelete", originalObject);
        if (StringUtils.isEmpty(isDelete)){
            this.strictInsertFill(metaObject,"isDelete",String.class,StringPool.ZERO);
        }
        this.strictInsertFill(metaObject,"createTime",LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject,"updateTime",LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"updateTime",LocalDateTime.class,LocalDateTime.now());
    }

    public String getFieldNameId(MetaObject metaObject){
        String obj = metaObject.getOriginalObject().toString();
        int star = obj.indexOf("(")+1;
        int end = obj.indexOf("=");
        String substring = obj.substring(star, end);
        return substring;
    }
    /**
     * 根据属性名获取属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    private String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(object, new Object[] {});
            return value.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
