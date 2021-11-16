#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.utils
 * @date 2020/5/13 16:30
 */
@Slf4j
public class ExcelUtil {

    public static final Integer EXPORT_MAX_ROW_NUMBER_XLSX = 1048576;
    public static final Integer EXPORT_MAX_ROW_NUMBER_XLS = 65536;

    /**
     * 导出
     *
     * @param response
     * @param data
     * @param fileName
     * @param sheetName
     * @param clazz
     * @throws Exception
     */
    public static void writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName,
                                  String sheetName, ExcelTypeEnum excelTypeEnum, Class clazz) throws Exception {
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        headWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle,
                contentWriteCellStyle);
        EasyExcel.write(getOutputStream(fileName, response), clazz).excelType(excelTypeEnum).sheet(sheetName)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).doWrite(data);
    }

    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".csv");
        return response.getOutputStream();
    }

    /**
     * 校验文件后缀是否为excel
     *
     * @param fileName
     * @return
     */
    public static Boolean verifyFileFormat(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        Boolean formatErrorFlag = false;
        for (ExcelTypeEnum et : ExcelTypeEnum.values()) {
            if (et.getValue().equals(extension)) {
                formatErrorFlag = true;
                break;
            }
        }
        return formatErrorFlag;
    }
}
