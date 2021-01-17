package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.domain.RoomInfo;
import org.lah.AnimalFeed.service.RoomInfoService;
import org.lah.AnimalFeed.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class RoomInfoController {
    /**
     * 自动注入RoomService
     * */
    @Autowired
    private RoomInfoService roomInfoService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(RoomInfoController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findRoomInfo")
    public String findRoomInfo(Integer RoomNumber,String RoomType,Integer AccommodateNumber,Integer AccommodatedNumber,
                           String RoomAnomaly,Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<RoomInfo> pi = roomInfoService.findPageInfo(RoomNumber, RoomType,AccommodateNumber,AccommodatedNumber,
                RoomAnomaly,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((RoomNumber!=null && RoomNumber!=0)){
            model.addAttribute("RoomNumber", RoomNumber);
        }
        return "/AnimalFeed/ShowRoomInfo";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportroomInfolist", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomInfo> exportRoomInfo(){
        List<RoomInfo> roominfoList = roomInfoService.getAll();
        return roominfoList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteRoomInfo")
    @ResponseBody
    public String deleteRoomInfo(Integer RoomNumber) {
        int s = roomInfoService.deleteRoomInfo(RoomNumber);
        return "/AnimalFeed/ShowRoomInfo";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addRoomInfo" ,method = RequestMethod.POST)
    public String addRoomInfo(@ModelAttribute RoomInfo RoomInfo) {
        logger.info("\n\nmmd"+RoomInfo+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = roomInfoService.addRoomInfo(RoomInfo);
        return "redirect:/findRoomInfo";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateRoomInfo" ,method = RequestMethod.POST )
    public String updateRoomInfo( RoomInfo RoomInfo) {
        roomInfoService.updateRoomInfo(RoomInfo);
        int s = roomInfoService.updateRoomInfo(RoomInfo);
        logger.info("\n\nmmd"+RoomInfo+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findRoomInfo";
    }


    @RequestMapping( "/findRoomInfoById")
    public String findRoomInfoById(Integer RoomNumber, HttpSession session) {
        logger.info("\n\nmmd"+RoomNumber+"\n\n");
        RoomInfo s= roomInfoService.findRoomInfoById(RoomNumber);
        session.setAttribute("s",s);
        return "/AnimalFeed/RecordRoomInfo";
    }



}
