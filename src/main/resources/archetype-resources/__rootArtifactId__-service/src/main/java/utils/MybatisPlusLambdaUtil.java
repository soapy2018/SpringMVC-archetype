#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author shirman
 * @Description
 * @date 2020/5/13 14:30
 */
public class MybatisPlusLambdaUtil {

    /**
     * @param entityClass
     * @param onlyColumn  如果是，结果: "name", 如果否： "name" as "name"
     * @return
     */
    public static String getColumnName(Class<?> entityClass, String fieldName, Boolean onlyColumn) {
        String fieldNameUpper = StringUtils.upperCase(fieldName);
        Map<String, ColumnCache> f = LambdaUtils.getColumnMap(entityClass);
        for (Map.Entry<String, ColumnCache> entry : f.entrySet()) {
            if (entry.getKey().equals(fieldNameUpper)) {
                return onlyColumn ? entry.getValue().getColumn() : entry.getValue().getColumnSelect();
            }
        }
        return null;
    }
}
