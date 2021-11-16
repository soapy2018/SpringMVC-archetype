#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * @description:
 * @author: yuyimao
 * @created: 2020/6/9 15:37
 */
@Configuration
public class DataSourceConfig {
    @Value("${symbol_dollar}{spring.datasource.url}")
    private String url;
    @Value("${symbol_dollar}{spring.datasource.username}")
    private String username;
    @Value("${symbol_dollar}{spring.datasource.password}")
    private String password;
    @Value("${symbol_dollar}{spring.datasource.hikari.maximumPoolSize}")
    private int maximumPoolSize;
    @Value("${symbol_dollar}{spring.datasource.hikari.minimumIdle}")
    private int minimumIdle;
    @Value("${symbol_dollar}{spring.datasource.hikari.idleTimeout}")
    private int idleTimeout;
    @Value("${symbol_dollar}{spring.datasource.hikari.connectionTimeout}")
    private int connectionTimeout;
    @Value("${symbol_dollar}{spring.datasource.hikari.maxLifetime}")
    private int maxLifetime;

    private HikariDataSource dataSource;

    public HikariDataSource instance() {
        if (dataSource != null) {
            return dataSource;
        }
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setConnectionTimeout(connectionTimeout);
        config.setMaxLifetime(maxLifetime);
        config.setIdleTimeout(idleTimeout);

        dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean(name = "dataSource")
    @DependsOn("dataSourceHelper")
    public DataSource dataSource() {
        return instance();
    }
}
