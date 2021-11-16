#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto.req;

import ${groupId}.common.dto.req.BaseReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author shirman
 * @Description
 * @date 2020/5/13 13:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageSortReq extends BaseReq {

    private List<SortReq> orders;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SortReq {
        @ApiModelProperty(name = "column", value = "排序列名", dataType = "String")
        private String column;

        @ApiModelProperty(name = "order", value = "排序方式", dataType = "String", example = "desc, asc")
        private String order;
    }
}
