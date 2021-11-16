#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Shirman
 * @date: 2020/4/24
 */
@Slf4j
public class RequestUtils {

    /**
     * 将对象中string类型且值为""设置成null
     * @param object
     */
    public static void objectStringBlankSetToNull(Object object) {
        if (object == null) {
            return;
        }
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            if (!String.class.equals(fieldType)) {
                continue;
            }
            try {
                String o = (String) field.get(object);
                if (null == o || "".equals(o)) {
                    field.set(object, null);
                }
            } catch (IllegalAccessException e) {
                log.error("获取值异常", e);
            }
        }
    }
}
