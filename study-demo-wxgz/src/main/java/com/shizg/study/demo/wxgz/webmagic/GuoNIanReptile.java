package com.shizg.study.demo.wxgz.webmagic;

import com.shizg.study.demo.wxgz.domain.bo.TPaMessageBO;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @ClassName HearReptile
 * @Description: TODO
 * @Author shizg
 * @Date 2020/12/30
 * @Version V1.0
 **/
@Component
public class GuoNIanReptile implements PageProcessor {
    //regex of URL:http://www.xbiquge.la/
    public static final String[] FIRST_URL2 = {"https://www.diyijuzi.com/zhufuyu/43566.html","https://www.diyijuzi.com/zhufuyu/43619.html","https://www.diyijuzi.com/zhufuyu/42533.html","https://www.diyijuzi.com/zhufuyu/44449.html","https://www.diyijuzi.com/zhufuyu/44447.html","https://www.diyijuzi.com/zhufuyu/44427.html"};
    public static final Integer FIRST = 2;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Autowired
    private TPaMessageService tPaMessageService;


    @Override
    public Site getSite() {
        // TODO Auto-generated method stub
        return site;
    }

    @Override
    public void process(Page page) {


//        if(page.getUrl().regex(FIRST_URL).match()){
//        }
                List<String> urls = page.getHtml().links().all();
//        List<String> urls = page.getHtml().links().regex(TARGET_URL).all();
//        List<String> a = new ArrayList<>();
//        a.add("https://www.diyijuzi.com/aiqing/44260.html");

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().xpath("//div[@id='relate-article']").links().all());

        List<String> s = page.getHtml().xpath("//div[@class='con']/p/text()").all();
        List<String> data = Lists.newArrayList();
        if (CollectionUtils.isEmpty(s)){
          return;
        }
        s.forEach(str->{
            String[] ss = str.split("、");
            if (ss.length >= 2){
                data.add(ss[1]);
            }
        });
        TPaMessageBO message = new TPaMessageBO();
        message.setTests(data);
        message.setType(FIRST);
        page.putField("value",message);
//        List<String> dd = page.getHtml().xpath("//div[@id='relate-article']").links().all();
//        List<String> AA = dd;

//        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
//        String sss = page.getHtml().xpath("//div[@class='con']").get();
//        page.putField("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",sss);
//        //作者
//        page.putField("author",page.getHtml().xpath("//div[@id='info']/p/text()").get());
//        //标题
//        page.putField("title",page.getHtml().xpath("//div[@id='info']/h1/text()").get());
//        //如果title为空则跳过
//        if (page.getResultItems().get("title") == null) {
//            page.setSkip(true);
//        }
//
//        //内容
//        page.putField("author",page.getHtml().xpath("//div[@id='info']/p/text()").get());
//
//        //简介
//        page.putField("info",page.getHtml().xpath("//div[@id='intro']/p[2]/text()").get());
//
//        //首图url
//        page.putField("image",page.getHtml().xpath("//div[@id='fmimg']/img").get());

//        //下一深度的网页爬取章节和内容
//        if(page.getUrl().regex(HELP_URL).match()){
//
//            List<String> links = page.getHtml().links().regex(TARGET_URL).all();
//            page.addTargetRequests(links);
//
//            //章节
//            page.putField("chapter", page.getHtml().xpath("//div[@class='bookname']/h1/text()").get());
//
//            //内容
//            page.putField("content", page.getHtml().xpath("//div[@id='content']/text()").get());
//        }
    }

    public  void start(){
        Spider.create(new GuoNIanReptile()).addUrl(FIRST_URL2)
                //输出到控制台
                .addPipeline(new ConsolePipeline())
                //传输到数据库
                .addPipeline(new MysqlPipeline(tPaMessageService))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }

    public static void main(String[] args){
        Spider.create(new GuoNIanReptile()).addUrl(FIRST_URL2)
                //输出到控制台
//                .addPipeline(new ConsolePipeline())
                //传输到数据库
                 .addPipeline(new MysqlPipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
