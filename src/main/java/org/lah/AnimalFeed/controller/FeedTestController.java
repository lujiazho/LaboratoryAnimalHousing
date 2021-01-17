package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.FeedTest;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.FeedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;



/**
 * 处理设备相关请求
 */
@Controller
public class FeedTestController {
    /**
     * 自动注入FeedTestService
     * */
    @Autowired
    private FeedTestService feedtestService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(FeedTestController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findFeedTest")
    public String findFeedTest(Integer FeedWaterTestNumber, Date TestDate,Integer FeedReceiveNumber,boolean IfFeedStandard, String PersonnelNumber,
                               String FeedAppearanceTest,String FeedMyeteTest,String FeedToxinTest,Float WaterBacterialCount,Float WaterColiformCount,
                               String AbnormalCondition, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<FeedTest> pi = feedtestService.findPageInfo(FeedWaterTestNumber, TestDate,FeedReceiveNumber,IfFeedStandard, PersonnelNumber,
                FeedAppearanceTest,FeedMyeteTest,FeedToxinTest,WaterBacterialCount,WaterColiformCount, AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((FeedWaterTestNumber!=null && FeedWaterTestNumber!=0)||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("FeedWaterTestNumber", FeedWaterTestNumber);
            model.addAttribute("IfFeedStandard", IfFeedStandard);
            model.addAttribute("PersonnelNumber", PersonnelNumber);
        }
        return "/AnimalFeed/ShowFeedTest";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportfeedtestlist", method = RequestMethod.POST)
    @ResponseBody
    public List<FeedTest> exportFeedTest(){
        List<FeedTest> feedtestList = feedtestService.getAll();
        return feedtestList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteFeedTest")
    @ResponseBody
    public String deleteFeedTest(Integer FeedWaterTestNumber) {
        int s = feedtestService.deleteFeedTest(FeedWaterTestNumber);
        return "/AnimalFeed/ShowFeedTest";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addFeedTest" ,method = RequestMethod.POST)
    public String addFeedTest(@ModelAttribute FeedTest feedtest) {
        logger.info("\n\nmmd"+feedtest+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = feedtestService.addFeedTest(feedtest);
        return "redirect:/findFeedTest";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateFeedTest" ,method = RequestMethod.POST )
    public String updateFeedTest( FeedTest feedtest) {
        feedtestService.updateFeedTest(feedtest);
        int s = feedtestService.updateFeedTest(feedtest);
        logger.info("\n\nmmd"+feedtest+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findFeedTest";
    }


    @RequestMapping( "/findFeedTestById")
    public String findFeedTestById(Integer FeedWaterTestNumber, HttpSession session) {

        FeedTest s= feedtestService.findFeedTestById(FeedWaterTestNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordFeedTest";
    }



}
