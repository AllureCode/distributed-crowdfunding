package com.gnawococ.crowd.controller;

import com.gnawococ.crowd.entity.ResultEntity;
import com.gnawococ.crowd.utils.CrowUtils;
import com.gnawococ.crowd.utils.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @program: distributed-crowdfunding
 * @description: redis远程操作的控制类
 * @author: wang_sir
 * @create: 2020-06-06 14:33
 **/
@RestController
public class RedisOperationController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 将字符串中的键值保存到redis
     *
     * @param normalKey     保存的键
     * @param normalValue   保存的值
     * @param timeoutMinute 超时时间 单位：分钟
     *                      -1表示没有过期时间
     *                      0 null 不接受
     *                      正数代表过期时间
     * @return
     */
    @PostMapping("save/normal/string/key/value")
    ResultEntity<String> saveNormalStringKeyValue(@RequestParam("normalKey") String normalKey,
                                                  @RequestParam("normalValue") String normalValue,
                                                  @RequestParam("timeoutMinute") Integer timeoutMinute) {
        //对输入数据的验证
        if (!CrowUtils.strEffectiveCheck(normalKey) || !CrowUtils.strEffectiveCheck(normalValue)) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_KEY_INVALID);
        }
        //判断timeoutMinute
        if (timeoutMinute == null || timeoutMinute == 0) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_KEY_TIME_OUT_INVALID);
        }
        //不设置过期时间
        if (timeoutMinute == -1) {
            try {
                redisTemplate.opsForValue().set(normalKey, normalValue);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
            return ResultEntity.successNoData();
        }
        //设置过期时间保存
        try {
            redisTemplate.opsForValue().set(normalKey, normalValue, timeoutMinute, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        return ResultEntity.successNoData();
    }

    /**
     * @param normalKey 保存的键
     * @return
     */
    @GetMapping("/retrieve/string/value/by/string/key")
    ResultEntity<String> retrieveStringValueByStringKey(@RequestParam("normalKey") String normalKey) {
        //对输入数据的验证
        if (!CrowUtils.strEffectiveCheck(normalKey)) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_KEY_INVALID);
        }
        try {
            String value = (String) redisTemplate.opsForValue().get(normalKey);
            return ResultEntity.successWithData(value);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_RESULT_INVALID);
        }
    }

    /**
     * @param key 根据键删除值
     * @return
     */
    @DeleteMapping("/redis/remove/by/key")
    ResultEntity<String> removeByKey(@RequestParam("key") String key) {
        //对输入数据的验证
        if (!CrowUtils.strEffectiveCheck(key)) {
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_KEY_INVALID);
        }
        try {
            Boolean deleteFlag = redisTemplate.delete(key);
            return ResultEntity.successNoData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(CrowdConstant.MESSAGE_REDIS_RESULT_INVALID);
        }
    }
}
