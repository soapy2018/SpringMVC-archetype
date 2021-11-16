#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 蓝卓App
 * @author Shirman
 * @date 2020/04
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bluetron.app")
@EnableFeignClients({"com.bluetron.app"})
@EnableTransactionManagement
@EnableDiscoveryClient(autoRegister = false)
@EnableAsync
public class AppServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppServiceApplication.class, args);
    }

}
