#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;


import ${groupId}.common.token.SuposUser;
import ${groupId}.database.meta.MybatisUserMetaObjectService;
import ${groupId}.starter.sdk.filter.AppTokenContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: mybatis 配置
 * @author: Shirman
 * @date: 2020/4/26
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MybatisUserMetaObjectService mybatisUserMetaObjectService() {
        return new MybatisUserMetaObjectServiceImpl();
    }

    public static class MybatisUserMetaObjectServiceImpl implements MybatisUserMetaObjectService {
        @Override
        public String userId() {
            SuposUser suposUser = AppTokenContext.getInstance().get();
            return suposUser == null?null:suposUser.getUsername();
        }
    }
}
