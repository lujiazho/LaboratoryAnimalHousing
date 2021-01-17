package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.PaddingTest;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.PaddingTestService;
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
public class PaddingTestController {
    /**
     * 自动注入PaddingTestService
     * */
    @Autowired
    private PaddingTestService paddingtestService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(PaddingTestController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findPaddingTest")
    public String findPaddingTest(Integer PaddingTestNumber, Integer PaddingGetNumber, boolean IfPadStandard,
                                  String PersonnelNumber,
                                 String AbnormalCondition,Integer pageIndex, Integer pageSize, Model model) {
        //logger.info("\n\nmmd"+"FUCK YOU PaddingBacterialCount:"+PaddingBacterialCount+"\n\n");
        PageInfo<PaddingTest> pi = paddingtestService.findPageInfo(PaddingTestNumber, PaddingGetNumber, IfPadStandard,PersonnelNumber,
                 AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        logger.info("\n\nmmd"+"FUCK YOU service"+"\n\n");

        if ((PaddingTestNumber!=null && PaddingTestNumber!=0)||
                PaddingGetNumber!=null && PaddingGetNumber!=0||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("PaddingTestNumber", PaddingTestNumber);
            model.addAttribute("PaddingGetNumber", PaddingGetNumber);
            model.addAttribute("PersonnelNumber", PersonnelNumber);
        }
        return "/AnimalFeed/ShowPaddingTest";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportpaddingtestlist", method = RequestMethod.POST)
    @ResponseBody
    public List<PaddingTest> exportPaddingTest(){
        List<PaddingTest> paddingtestList = paddingtestService.getAll();
        return paddingtestList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deletePaddingTest")
    @ResponseBody
    public String deletePaddingTest(Integer PaddingTestNumber) {
        int s = paddingtestService.deletePaddingTest(PaddingTestNumber);
        return "/AnimalFeed/ShowPaddingTest";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addPaddingTest" ,method = RequestMethod.POST)
    public String addPaddingTest(@ModelAttribute PaddingTest paddingtest) {
        logger.info("\n\nmmd"+paddingtest+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = paddingtestService.addPaddingTest(paddingtest);
        return "redirect:/findPaddingTest";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updatePaddingTest" ,method = RequestMethod.POST )
    public String updatePaddingTest( PaddingTest paddingtest) {
        paddingtestService.updatePaddingTest(paddingtest);
        int s = paddingtestService.updatePaddingTest(paddingtest);
        logger.info("\n\nmmd"+paddingtest+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findPaddingTest";
    }


    @RequestMapping( "/findPaddingTestById")
    public String findPaddingTestById(Integer PaddingTestNumber, HttpSession session) {

        PaddingTest s= paddingtestService.findPaddingTestById(PaddingTestNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordPaddingTest";
    }



}
