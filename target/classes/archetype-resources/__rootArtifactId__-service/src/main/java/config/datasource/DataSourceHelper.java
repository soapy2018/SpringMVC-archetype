#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.datasource;

import com.sun.org.apache.xml.internal.utils.URI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description:
 * @author: yuyimao
 * @created: 2020/6/9 15:26
 */
@Configuration
@Slf4j
public class DataSourceHelper {
    @Value("${symbol_dollar}{spring.datasource.url}")
    private String url;
    @Value("${symbol_dollar}{spring.datasource.username}")
    private String username;
    @Value("${symbol_dollar}{spring.datasource.password}")
    private String password;

    @PostConstruct
    public void init() {
        try {
            URI uri = new URI(url.replace("jdbc:", ""));
            String host = uri.getHost();
            String path = uri.getPath();
            int port = uri.getPort();
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + path.replace("/", "") + "` DEFAULT CHARACTER SET = `utf8mb4` COLLATE `utf8mb4_unicode_ci`;");
            statement.close();
            connection.close();
        } catch (SQLException | URI.MalformedURIException throwables) {
            log.error(throwables.getMessage());
        }
    }
}
