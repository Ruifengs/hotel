package com.dgut.hotel.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dgut.hotel.model.Test;
import com.dgut.hotel.mapper.TestMapper;
import com.dgut.hotel.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ruifeng
 * @since 2021-02-03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
}
