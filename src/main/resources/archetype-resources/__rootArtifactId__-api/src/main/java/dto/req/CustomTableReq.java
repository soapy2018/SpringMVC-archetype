#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.dto.req.table
 * @date 2020/5/21 11:20
 */
@ApiModel("自定义表格对象")
@Data
public class CustomTableReq {

    @NotEmpty(message = "{param.customTable.tableId.non.null}")
    @ApiModelProperty(name = "tableId", value = "表格id", dataType = "String")
    private String tableId;
    @NotEmpty(message = "{param.customTable.userId.non.null}")
    @ApiModelProperty(name = "userId", value = "用户id", dataType = "String")
    private String userId;
    @NotEmpty(message = "{param.customTable.config.non.null}")
    @ApiModelProperty(name = "config", value = "配置信息", dataType = "String")
    private String config;

}
