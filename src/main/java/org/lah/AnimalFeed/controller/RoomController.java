package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.Room;
import org.lah.AnimalFeed.domain.PageInfo;
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


/**
 * 处理设备相关请求
 */
@Controller
public class RoomController {
    /**
     * 自动注入RoomService
     * */
    @Autowired
    private RoomService roomService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(RoomController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findRoom")
    public String findRoom(Integer RoomNumber, String AnimalNumber, String RoomType, boolean IfLeave, String LeaveReason,Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<Room> pi = roomService.findPageInfo(RoomNumber, AnimalNumber,IfLeave,
                LeaveReason,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((RoomNumber!=null && RoomNumber!=0)||
                AnimalNumber!=null && !AnimalNumber.equals("")||
                RoomType!=null && !RoomType.equals("")){
            model.addAttribute("RoomNumber", RoomNumber);
            model.addAttribute("AnimalNumber", AnimalNumber);
            model.addAttribute("RoomType", RoomType);
        }
        return "/AnimalFeed/ShowRoom";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportroomlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Room> exportRoom(){
        List<Room> roomList = roomService.getAll();
        return roomList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteRoom")
    @ResponseBody
    public String deleteRoom(String AnimalNumber) {
        int s = roomService.deleteRoom(AnimalNumber);
        return "/AnimalFeed/ShowRoom";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addRoom" ,method = RequestMethod.POST)
    public String addRoom(@ModelAttribute Room room) {
        logger.info("\n\nmmd"+room+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = roomService.addRoom(room);
        return "redirect:/findRoom";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateRoom" ,method = RequestMethod.POST )
    public String updateRoom( Room room) {
        roomService.updateRoom(room);
        int s = roomService.updateRoom(room);
        logger.info("\n\nmmd"+room+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findRoom";
    }


    @RequestMapping( "/findRoomById")
    public String findRoomById(String AnimalNumber, HttpSession session) {
        logger.info("\n\nmmd"+AnimalNumber+"\n\n");
        Room s= roomService.findRoomById(AnimalNumber);
        session.setAttribute("s",s);
        logger.info("\n\nmmd"+s.getAnimalNumber()+"\n\n");
        return "/AnimalFeed/RecordRoom";
    }



}
