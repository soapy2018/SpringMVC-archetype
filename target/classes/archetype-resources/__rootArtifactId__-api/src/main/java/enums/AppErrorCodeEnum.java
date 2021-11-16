#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.enums;

/**
 * @description: 错误枚举CODE
 * @author: Shirman
 * @date: 2020/4/7
 */
public enum AppErrorCodeEnum {
    /**
     * REQUIRE_USL_OR_LSL
     */
    REQUIRE_USL_OR_LSL,
    /**
     * 未知的图类型
     */
    UNKNOWN_CHART_TYPE,
    /**
     * 数据已存在
     */
    DATA_ALREADY_EXIST,
    /**
     * INDEX_NAME_ALREADY_EXIST
     */
    INDEX_NAME_ALREADY_EXIST,
    /**
     * INDEX_CODE_ALREADY_EXIST
     */
    INDEX_CODE_ALREADY_EXIST,
    /**
     * 异常点已经处理过了
     */
    ERROR_RECORD_ALREADY_HANDLED,
    /**
     * 指标未找到
     */
    INDEX_NOT_FOUND,
    /**
     * UNKNOWN_INDEX_DATA_SOURCE_TYPE
     */
    UNKNOWN_INDEX_DATA_SOURCE_TYPE,
    /**
     * SAVE_ERROR
     */
    SAVE_ERROR,
    /**
     * 数据导出条数超过1048576行
     */
    EXPORT_DATA_SIZE_OVER_LIMIT,
    /**
     * 第三方接口调用异常
     */
    THIRD_DATA_SOURCE_ERROR,

    SUPOS_DATA_SOURCE_ERROR,
    /**
     * 第三方接口返回无数据
     */
    THIRD_DATA_EMPTY,

    SUPOS_DATA_EMPTY,
    /**
     * 可用于计算的点数不足
     */
    POINT_POOL_CAN_NOT_CAL,
    /**
     * 启用的指标无法删除
     */
    ENABLED_INDEX_CAN_NOT_DELETE,
}
