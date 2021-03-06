package com.shizg.study.demo.wxgz.handler;

import com.shizg.study.demo.wxgz.builder.ImageBuilder;
import com.shizg.study.demo.wxgz.builder.TextBuilder;
import com.shizg.study.demo.wxgz.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private MessageHold messageHold;
    public static final String s = "【我想“1”直对你说】：";

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                && weixinService.getKefuService().kfOnlineList()
                .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //TODO 组装回复消息
//        String content = "收到信息内容：" + JsonUtils.beanToJson(wxMessage);
        String message = wxMessage.getContent();
        if ("1".equals(message)) {
            message = s.concat(messageHold.geAtMessageNex());
        }else if ("2".equals(message)){
            message = s.concat(messageHold.geBtMessageNex());
        }else if ("5201314".equals(message)){
            return new ImageBuilder().build(messageHold.getAaa(), wxMessage, weixinService);
        }

        return new TextBuilder().build(message, wxMessage, weixinService);

    }

}
