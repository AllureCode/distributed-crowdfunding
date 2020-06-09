package com.gnawococ.crowd;

import static org.junit.Assert.assertTrue;

import com.google.gson.internal.bind.JsonTreeReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test(){

        //redisTemplate.opsForValue().set("stu:1", "zhangsan");

        Object o = redisTemplate.opsForValue().get("RANDOM_CODE_15398069231");
        System.out.println(o);
    }


}
