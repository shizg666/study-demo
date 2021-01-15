package com.shizg.study.demo.wxgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import com.shizg.study.demo.wxgz.mapper.TPaMessageMapper;
import com.shizg.study.demo.wxgz.service.IMessageService;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目户型表 Mapper 接口
 * </p>
 *
 * @author wenyilu
 * @since 2020-08-11
 */
@Service
public class MessageServiceImpl extends ServiceImpl<TPaMessageMapper, TPaMessage> implements IMessageService {


    @Override
    public String getMessage(String message) {
        return null;
    }
}
