#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: Shirman
 * @date: 2020/7/7
 */
@ActiveProfiles(profiles = "dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppServiceApplicationTest {

}