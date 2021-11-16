#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import lombok.Data;

/**
 * @author leo
 * @Description
 * @package_name ${groupId}.metadata.model
 * @date 2020/5/21 11:27
 */
@Data
public class CustomTable {
    private String tableId;
    private String userId;
    private String config;
}
