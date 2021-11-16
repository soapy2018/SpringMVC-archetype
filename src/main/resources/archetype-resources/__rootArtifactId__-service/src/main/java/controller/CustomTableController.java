#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${groupId}.common.response.ApiResponse;
import ${groupId}.common.response.ResultCode;
import ${package}.dto.req.CustomTableReq;
import ${package}.dto.res.CustomTableRes;
import ${package}.entity.CustomTable;
import ${package}.service.CustomTableService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author shirman
 * @Description
 * @package_name ${groupId}.metadata.controller
 * @date 2020/5/21 10:46
 */
@Api(tags = {"自定义表格管理"})
@RestController
@Slf4j
public class CustomTableController extends BaseController implements CustomTableService {

    public static final String KEY_PREFIX_CUSTOM_TABLE = "app:${rootArtifactId}-service:table:custom:config:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ApiResponse add(CustomTableReq ct) {
        log.info("custom table add, param is {}", ct.toString());
        CustomTable customTable = new CustomTable();
        BeanUtils.copyProperties(ct, customTable);
        redisTemplate.opsForValue().set(KEY_PREFIX_CUSTOM_TABLE + ct.getTableId() + "-" + ct.getUserId(), customTable);
        return success();
    }

    @Override
    public ApiResponse query(String tableId, String userId) {
        log.info("custom table query, tableId is {}, userId is {}", tableId, userId);
        CustomTable ct =
                (CustomTable) redisTemplate.opsForValue().get(KEY_PREFIX_CUSTOM_TABLE + tableId + "-" + userId);
        if (Objects.isNull(ct)) {
            return fail(ResultCode.RESULE_DATA_NONE.message());
        }
        CustomTableRes ctr = new CustomTableRes();
        BeanUtils.copyProperties(ct, ctr);
        return success(ctr);
    }
}
