package com.shizg.study.demo.wxgz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;

import java.util.List;

/**
 * <p>
 * 项目户型表 Mapper 接口
 * </p>
 *
 * @author wenyilu
 * @since 2020-08-11
 */
public interface TPaMessageService extends IService<TPaMessage> {

    List<String> getList(Integer s,Long idNo);
}
