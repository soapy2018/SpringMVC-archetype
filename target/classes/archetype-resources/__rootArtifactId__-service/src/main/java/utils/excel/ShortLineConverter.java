#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author shirman
 * @Description
 * @date 2020/5/14 10:45
 */
public class ShortLineConverter implements Converter<Object> {

    @Override
    public Class supportJavaTypeKey() {
        return Object.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Object convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty,
                                     GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(Object val, ExcelContentProperty excelContentProperty,
                                       GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData("-");
    }
}
