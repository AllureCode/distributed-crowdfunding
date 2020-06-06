package com.gnawococ.crowd.api;


import com.gnawococ.crowd.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "redis-provider")
/**
 *@Author: wang_sir
 * @Description: 对redis的远程操作接口
 * @Date: 14:21 2020/6/6
 * @Param:
 * @return:
 **/
public interface RedisOperationRemoteService {
    /**
     * 将字符串中的键值保存到redis
     * @param normalKey   保存的键
     * @param normalValue  保存的值
     * @param timeoutMinute 超时时间 单位：分钟
     * @return
     */
    @PostMapping("save/normal/string/key/value")
    ResultEntity<String> saveNormalStringKeyValue(@RequestParam("normalKey")String normalKey,@RequestParam("normalValue")String normalValue,@RequestParam("timeoutMinute")Integer timeoutMinute);

    /**
     *
     * @param normalKey 保存的键
     * @return
     */
    @GetMapping("/retrieve/string/value/by/string/key")
    ResultEntity<String> retrieveStringValueByStringKey(@RequestParam("normalKey")String normalKey);

    /**
     *
     * @param key 根据键删除值
     * @return
     */
    @DeleteMapping("/redis/remove/by/key")
    ResultEntity<String> removeByKey(@RequestParam("key")String key);
}
