package com.shizg.study.demo.wxgz.webmagic;

import com.google.common.collect.Lists;
import com.shizg.study.demo.wxgz.domain.bo.TPaMessageBO;
import com.shizg.study.demo.wxgz.domain.entry.TPaMessage;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @ClassName MysqlPipeline
 * @Description: TODO
 * @Author shizg
 * @Date 2021/1/15
 * @Version V1.0
 **/
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MysqlPipeline implements Pipeline {

    private TPaMessageService tPaMessageService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        TPaMessageBO messageBO = (TPaMessageBO)resultItems.get("value");
        List<TPaMessage> messageList = Lists.newArrayListWithExpectedSize(messageBO.getTests().size());
        messageBO.getTests().forEach(me->{
            TPaMessage message = new TPaMessage();
            message.setCt(System.currentTimeMillis());
            message.setType(messageBO.getType());
            message.setText(me);
            messageList.add(message);
        });
        tPaMessageService.saveBatch(messageList);

    }
}
