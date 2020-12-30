package com.shizg.study.demo.wxgz.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HearReptile
 * @Description: TODO
 * @Author shizg
 * @Date 2020/12/30
 * @Version V1.0
 **/
public class HearReptile implements PageProcessor {
    //regex of URL:http://www.xbiquge.la/
    public static final String FIRST_URL = "http://www\\.xbiquge\\.la/\\w+";
    public static final String FIRST_URL2 = "http://www.diyijuzi.com/aiqing/44264.html";
    public static final String HELP_URL = "/\\d+/\\d+/";
    public static final String TARGET_URL = "/\\d+/aiqing/\\d+\\.html/";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

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
        List<String> a = new ArrayList<>();
        a.add("http://www.diyijuzi.com/aiqing/44264.html");

        page.addTargetRequests(a);
        String s = page.getHtml().xpath("//div[@class='con']").get();
        page.putField("ssssssssssssssssssssssss",s);
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

    public static void main(String[] args){
        Spider.create(new HearReptile()).addUrl(FIRST_URL2)
                //输出到控制台
                .addPipeline(new ConsolePipeline())
                //传输到数据库
                // .addPipeline(new MysqlPipelineBiQuGe())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
