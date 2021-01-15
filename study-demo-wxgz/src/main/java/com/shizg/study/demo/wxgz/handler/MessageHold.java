package com.shizg.study.demo.wxgz.handler;


import com.google.common.collect.Lists;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MessageHold
 * @Description: TODO
 * @Author shizg
 * @Date 2021/1/15
 * @Version V1.0
 **/
@Component
public class MessageHold {
    private volatile int index = 1;
    private volatile int aindex = 1;
    private volatile int bindex = 1;
    private volatile Long aId = 1L;
    private volatile int bid = 1;
    private List<String> a = Lists.newArrayListWithCapacity(100);
    private List<String> a1 = Lists.newArrayListWithCapacity(100);
    private List<String> b = Lists.newArrayListWithCapacity(100);
    private List<String> b1 = Lists.newArrayListWithCapacity(100);

    @Autowired
    private TPaMessageService tPaMessageService;

    void init(){
        List<String> data = tPaMessageService.getList(1,aId);

    }
}
