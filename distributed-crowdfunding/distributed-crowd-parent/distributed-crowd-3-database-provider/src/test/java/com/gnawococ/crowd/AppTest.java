package com.gnawococ.crowd;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private DataSource dataSource;
    @Test
    public void test() throws SQLException {

        /**
         * @Author:  wang_sir
         * @Description: test database connection
         * @Date: 9:11 2020/5/29
         * @Param: []
         * @return: void
         **/
        Connection connection = dataSource.getConnection();

        System.out.println("-------->"+connection);

    }
}
