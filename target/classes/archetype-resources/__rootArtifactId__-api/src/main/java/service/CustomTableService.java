#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${groupId}.common.response.ApiResponse;
import ${package}.dto.req.CustomTableReq;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.service
 * @date 2020/5/21 11:18
 */
public interface CustomTableService {

    /**
     * 新增
     *
     * @param object
     * @return
     */
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/custom-table/config", method = {RequestMethod.POST})
    ApiResponse add(@RequestBody @Validated CustomTableReq object);


    /**
     * 查询
     *
     * @param tableId
     * @param userId
     * @return
     */
    @ApiOperation(value = "查询")
    @RequestMapping(value = "/custom-table/config", method = {RequestMethod.GET})
    ApiResponse query(@ApiParam(value = "表格id", required = true) @RequestParam String tableId,
                      @ApiParam(value = "用户id", required = true) @RequestParam String userId);
}
