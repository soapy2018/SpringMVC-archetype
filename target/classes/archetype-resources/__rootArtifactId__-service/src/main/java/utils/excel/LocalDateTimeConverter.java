#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.utils
 * @date 2020/5/14 09:52
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    /**
     * 不使用{@code @LocalDateTimeFormat}注解指定日期格式时,默认会使用该格式.
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *
     * @param cellData            excel数据 (NotNull)
     * @param contentProperty     excel属性 (Nullable)
     * @param globalConfiguration 全局配置 (NotNull)
     * @return 读取到内存中的数据
     */
    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                           GlobalConfiguration globalConfiguration) {
        LocalDateTimeFormat annotation = contentProperty.getField().getAnnotation(LocalDateTimeFormat.class);
        return LocalDateTime.parse(cellData.getStringValue(),
                DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ? annotation.value() : DEFAULT_PATTERN));
    }

    /**
     * 写的时候会调用
     *
     * @param value               java value (NotNull)
     * @param contentProperty     excel属性 (Nullable)
     * @param globalConfiguration 全局配置 (NotNull)
     * @return 写出到excel文件的数据
     */
    @Override
    public CellData convertToExcelData(LocalDateTime value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        LocalDateTimeFormat annotation = contentProperty.getField().getAnnotation(LocalDateTimeFormat.class);
        return new CellData(value.format(DateTimeFormatter.ofPattern(Objects.nonNull(annotation) ?
                annotation.value() : DEFAULT_PATTERN)));
    }
}