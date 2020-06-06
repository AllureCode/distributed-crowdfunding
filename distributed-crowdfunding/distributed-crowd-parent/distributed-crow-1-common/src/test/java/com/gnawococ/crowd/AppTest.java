package com.gnawococ.crowd;

import static org.junit.Assert.assertTrue;

import com.gnawococ.crowd.utils.CrowUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    /**
     * @Author:  wang_sir
     * @Description: 测试短信发送
     * @Date: 9:52 2020/6/5
     * @Param: []
     * @return: void
     **/
    public void shouldAnswerWithTrue() throws Exception {
        assertTrue( true );
       String appcode = "cb67b38ba0844e79a008b5268678abcd";
       String phoneNum = "15398069231";
       String randomCode = CrowUtils.randomCode(4);
       CrowUtils.sendShortMessage(appcode,randomCode, phoneNum);
    }
}
