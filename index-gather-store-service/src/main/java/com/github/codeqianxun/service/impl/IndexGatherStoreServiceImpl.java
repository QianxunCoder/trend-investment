package com.github.codeqianxun.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.codeqianxun.api.service.IndexService;
import com.github.codeqianxun.common.RedisKeyConstants;
import com.github.codeqianxun.service.IndexGatherStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
@DubboService
public class IndexGatherStoreServiceImpl implements IndexGatherStoreService {
    @DubboReference
    private IndexService indexService;
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 获取指数信息
     * @param code 代码
     * @return 指数信息
     */
    public String getIndexInfo(String code) {
        // 先从 Redis 缓存中获取
        String index = stringRedisTemplate.opsForValue().get(StrUtil.format(RedisKeyConstants.INDEX_INFO_KEY, code));
        if (StrUtil.isBlank(index)) {
            // 缓存不存在，调用第三方数据服务获取
            try {
                index = indexService.getIndex(code);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
            if (StrUtil.isNotBlank(index)) {
                // 缓存数据
                stringRedisTemplate.opsForValue().set(StrUtil.format(RedisKeyConstants.INDEX_INFO_KEY, code), index);
                return index;
            } else {
                log.info("第三方服务返回数据为空");
            }
        }
        return index;
    }
}