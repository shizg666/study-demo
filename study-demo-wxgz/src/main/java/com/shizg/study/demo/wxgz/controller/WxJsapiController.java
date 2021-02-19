package com.shizg.study.demo.wxgz.controller;

import com.shizg.study.demo.wxgz.handler.MessageHold;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.fs.FileUtils;
import me.chanjar.weixin.common.util.http.MediaUploadRequestExecutor;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Material.MEDIA_UPLOAD_URL;

/**
 * jsapi 演示接口的 controller.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-04-25
 */
@AllArgsConstructor
@RestController
@RequestMapping("/wx/jsapi/{appid}")
public class WxJsapiController {
    private final WxMpService wxService;

    @Autowired
    private MessageHold messageHold;





    @GetMapping("/getJsapiTicket")
    public String getJsapiTicket(@PathVariable String appid) throws WxErrorException {
        final WxJsapiSignature jsapiSignature = this.wxService.switchoverTo(appid).createJsapiSignature("111");
        System.out.println(jsapiSignature);
        return this.wxService.getJsapiTicket(true);
    }

    @GetMapping("/upload")
    public String upload(@PathVariable String appid) throws WxErrorException, IOException {
        InputStream in = WxJsapiController.class.getClassLoader()
                .getResourceAsStream("88.jpg");
        File tmpFile = FileUtils.createTmpFile(in, UUID.randomUUID().toString(), "jpg");
        String url = String.format(MEDIA_UPLOAD_URL.getUrl(this.wxService.getWxMpConfigStorage()), WxConsts.MediaFileType.IMAGE);
        WxMediaUploadResult result =  this.wxService.switchoverTo(appid).execute(MediaUploadRequestExecutor.create(this.wxService.getRequestHttp()), url, tmpFile);
        String id = result.getMediaId();
        messageHold.setAaa(id);
        return id;
    }
}
