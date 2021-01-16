package com.shizg.study.demo.wxgz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import com.shizg.study.demo.wxgz.mapper.TPaMessageMapper;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目户型表 Mapper 接口
 * </p>
 *
 * @author wenyilu
 * @since 2020-08-11
 */
@Service
public class TPaMessageServiceImpl extends ServiceImpl<TPaMessageMapper, TPaMessage> implements TPaMessageService {


    @Override
    public List<String> getList(Integer s,int idNo) {
        return this.baseMapper.getList(s,idNo);
    }
}
