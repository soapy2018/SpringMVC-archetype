#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.utils
 * @date 2020/5/14 09:53
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalDateTimeFormat {
    /**
     * 指定LocalDateTime转化的日期格式
     * 例如 : "yyyy-MM-dd HH:mm:ss",导入导出都会将LocalDateTime转化为对应格式字符串
     *
     * @return 日期格式
     */
    String value();
}
