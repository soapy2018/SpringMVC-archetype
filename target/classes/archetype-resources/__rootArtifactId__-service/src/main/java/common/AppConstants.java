#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;

/**
 * 全局常量配置
 *
 * @author Shirman
 */
public class AppConstants {

    /**
     * sort
     */
    public static final String COLUMN_ORDER_DESC = "desc";
    public static final String COLUMN_ORDER_ASC = "asc";

    /**
     * symbol
     */
    public static final String NEW_LINE = "${symbol_escape}n";
    public static final String SHORT_LINE = "-";
    public static final String SHORT_UNDERLINE = "_";

    /**
     * datetime format
     */
    public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmssSSS";

}
