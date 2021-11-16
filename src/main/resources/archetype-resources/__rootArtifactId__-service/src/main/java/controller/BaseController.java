#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${groupId}.common.response.ApiResponse;
import ${groupId}.common.response.ApiResponseUtil;
import ${package}.common.AppConstants;
import ${package}.dto.req.PageSortReq;
import ${package}.utils.MybatisPlusLambdaUtil;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器基类
 * @author andongdogn
 */
@RestController
public abstract class BaseController {

    protected <T> ApiResponse<T> success() {
        return ApiResponseUtil.getSuccessResponse(null);
    }

    protected <T> ApiResponse<T> success(String msg) {
        return ApiResponseUtil.getSuccessResponse(msg);
    }

    protected <T> ApiResponse<T> success(String msg, T data) {
        return ApiResponseUtil.getSuccessResponse(msg, data);
    }

    protected <T> ApiResponse<T> success(T data) {
        return ApiResponseUtil.getSuccessResponse(data);
    }

    protected <T> ApiResponse<T> fail(String msg) {
        return ApiResponseUtil.getFailResponse(msg, null);
    }

    protected <T> ApiResponse<T> fail(String msg, T data) {
        return ApiResponseUtil.getFailResponse(msg, data);
    }

    protected <T> ApiResponse<T> response(Integer count, String msg, T data) {
        return ApiResponseUtil.getResponse(msg, data, count);
    }

    protected void sort(PageSortReq request, QueryWrapper queryWrapper, Class clazz) {
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(request.getOrders())) {
            for (PageSortReq.SortReq sr : request.getOrders()) {
                String columnName = MybatisPlusLambdaUtil.getColumnName(clazz, sr.getColumn(),
                        true);
                if (!Strings.isNullOrEmpty(columnName)) {
                    queryWrapper.orderBy(true,
                            AppConstants.COLUMN_ORDER_ASC.equals(StringUtils.lowerCase(sr.getOrder())), columnName);
                }
            }
        }
    }

}
