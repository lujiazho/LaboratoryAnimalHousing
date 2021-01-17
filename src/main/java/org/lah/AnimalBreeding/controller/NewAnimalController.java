package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.NewAnimal;
import org.lah.AnimalBreeding.service.NewAnimalService;
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
public class NewAnimalController {
    /**
     * 自动注入NewAnimalService
     * */
    @Autowired
    private NewAnimalService nService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(NewAnimalController.class);
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/seeNewAnimal")
    public String findNewAnimal(String AnimalNumber, String RecordDate, String AnimalSex, String IncineratorPerson,
                                String BroodChamber, String SowNumber,String HealthCondition,Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<NewAnimal> pi = nService.findPageInfo(AnimalNumber, RecordDate, AnimalSex, IncineratorPerson, BroodChamber,
                SowNumber ,HealthCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(10);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null && !AnimalNumber.equals(""))
        {
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/NewAnimalInfo";
    }

    /**
     * 删除信息
     */
    @RequestMapping( "/deleteNewAnimal")
    @ResponseBody
    public String deleteNewAnimal(String AnimalNumber) {
        int s = nService.deleteNewAnimal(AnimalNumber);
        return "/AnimalBreeding/NewAnimalInfo";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addNewAnimal" ,method = RequestMethod.POST)
    public String addNewAnimal(@ModelAttribute NewAnimal newanimal) {
        logger.info("\n\nmmd"+newanimal+"\n\n");
        int s = nService.addNewAnimal(newanimal);
        return "redirect:/seeNewAnimal";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateNewAnimal" ,method = RequestMethod.POST )
    public String updateNewAnimal(NewAnimal newanimal)
    {
        int s = nService.updateNewAnimal(newanimal);
        return "redirect:/seeNewAnimal";
    }


    @RequestMapping( "/findNewAnimalByAN")
    public String findNewAnimalByAN(String AnimalNumber, HttpSession session) {

        NewAnimal newanimal= nService.findNewAnimalByAN(AnimalNumber);
        session.setAttribute("newanimal",newanimal);

        return "/AnimalBreeding/EditNewAnimal";
    }



}
