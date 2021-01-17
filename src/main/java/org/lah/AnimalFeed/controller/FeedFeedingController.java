package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.FeedFeeding;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.FeedFeedingService;
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
public class FeedFeedingController {
    /**
     * 自动注入FeedFeedingService
     * */
    @Autowired
    private FeedFeedingService feedFeedingService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(FeedFeedingController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findFeedFeeding")
    public String findFeedFeeding(Integer FeedingNumber, Date FeedDate,String AnimalNumber,String FeedType, Integer RoomNumber,
                                  Float FeedAmount, String PersonnelNumber,String AbnormalCondition, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<FeedFeeding> pi = feedFeedingService.findPageInfo(FeedingNumber, FeedDate, AnimalNumber,FeedType,RoomNumber,FeedAmount, PersonnelNumber,AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((FeedingNumber!=null && FeedingNumber!=0)||
                AnimalNumber!=null && !AnimalNumber.equals("")||
                RoomNumber!=null && RoomNumber!=0||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("FeedingNumber", FeedingNumber);
            model.addAttribute("AnimalNumber", AnimalNumber);
            model.addAttribute("RoomNumber", RoomNumber);
            model.addAttribute("PersonnelNumber", PersonnelNumber);

        }
        return "/AnimalFeed/ShowFeedFeeding";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportfeedFeedinglist", method = RequestMethod.POST)
    @ResponseBody
    public List<FeedFeeding> exportFeedFeeding(){
        List<FeedFeeding> feedFeedingList = feedFeedingService.getAll();
        return feedFeedingList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteFeedFeeding")
    @ResponseBody
    public String deleteFeedFeeding(Integer FeedingNumber) {
        int s = feedFeedingService.deleteFeedFeeding(FeedingNumber);
        return "/AnimalFeed/ShowFeedFeeding";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addFeedFeeding" ,method = RequestMethod.POST)
    public String addFeedFeeding(@ModelAttribute FeedFeeding feedFeeding) {
        logger.info("\n\nmmd"+feedFeeding+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = feedFeedingService.addFeedFeeding(feedFeeding);
        return "redirect:/findFeedFeeding";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateFeedFeeding" ,method = RequestMethod.POST )
    public String updateFeedFeeding( FeedFeeding feedFeeding) {
        feedFeedingService.updateFeedFeeding(feedFeeding);
        int s = feedFeedingService.updateFeedFeeding(feedFeeding);
        logger.info("\n\nmmd"+feedFeeding+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findFeedFeeding";
    }


    @RequestMapping( "/findFeedFeedingById")
    public String findFeedFeedingById(Integer FeedingNumber, HttpSession session) {

        FeedFeeding s= feedFeedingService.findFeedFeedingById(FeedingNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordFeedFeeding";
    }



}
