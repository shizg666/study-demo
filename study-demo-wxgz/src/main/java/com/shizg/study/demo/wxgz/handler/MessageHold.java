package com.shizg.study.demo.wxgz.handler;


import com.google.common.collect.Lists;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MessageHold
 * @Description: TODO
 * @Author shizg
 * @Date 2021/1/15
 * @Version V1.0
 **/
@Component
public class MessageHold {
    private volatile static int index = 1;
    private volatile static AtomicInteger aindex = new AtomicInteger(1);
    private volatile static AtomicInteger bindex = new AtomicInteger(1);
    private volatile static int adata = 0;
    private volatile static int bdata = 0;
    private volatile static AtomicInteger aRe = new AtomicInteger(1);
    private volatile static AtomicInteger bRe = new AtomicInteger(1);
    private static List<String> a = Lists.newArrayListWithCapacity(50);
    private static List<String> a1 = Lists.newArrayListWithCapacity(50);
    private static List<String> b = Lists.newArrayListWithCapacity(50);
    private static List<String> b1 = Lists.newArrayListWithCapacity(50);

    @Autowired
    private TPaMessageService tPaMessageService;

    void init(){
        List<String> data = tPaMessageService.getList(1,1);
        List<String> data2 = tPaMessageService.getList(2,1);
        a.addAll(data);
        b.addAll(data2);
    }

    String geAtMessageNex(){
        if (aindex.get() == 30){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getData1();
                }
            });
        }
        if (aindex.get() == 51){
            if (adata == 0){
                adata = 1;
            }else {
                adata = 0;
            }
        }
        if (adata == 0){
            return a.get(aindex.getAndAdd(1));
        }
        return a1.get(aindex.getAndAdd(1));
    }

    String geBtMessageNex(){
        if (bindex.get() == 30){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getData2();
                }
            });
        }
        if (bindex.get() == 51){
            if (bdata == 0){
                bdata = 1;
            }else {
                bdata = 0;
            }
        }
        if (bdata == 0){
            return a.get(bindex.getAndAdd(1));
        }
        return a1.get(bindex.getAndAdd(1));
    }


     void getData1() {
        List<String> data = tPaMessageService.getList(1,aRe.get()*50);
        if (CollectionUtils.isEmpty(data)){
            aindex = new AtomicInteger(1);
            adata = 1;
            aRe = new AtomicInteger(1);
            getData1();
        }
        a1.addAll(data);
        aRe.getAndAdd(1);
    }

    void getData2() {
        List<String> data = tPaMessageService.getList(2,aRe.get()*50);
        if (CollectionUtils.isEmpty(data)){
            bindex = new AtomicInteger(1);
            bdata = 1;
            bRe = new AtomicInteger(1);
            getData1();
        }
        b1.addAll(data);
        bRe.getAndAdd(1);
    }
}
