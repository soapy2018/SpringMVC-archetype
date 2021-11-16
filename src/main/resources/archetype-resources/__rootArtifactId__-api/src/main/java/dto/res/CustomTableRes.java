#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.dto.res
 * @date 2020/5/21 11:23
 */
@ApiModel("自定义表格返回对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomTableRes {
    @ApiModelProperty(name = "tableId", value = "表格id", dataType = "String")
    private String tableId;
    @ApiModelProperty(name = "userId", value = "用户id", dataType = "String")
    private String userId;
    @ApiModelProperty(name = "config", value = "配置信息", dataType = "String")
    private String config;
}
