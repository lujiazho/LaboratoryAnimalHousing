package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.AnimalBreed;
import org.lah.AnimalBreeding.service.AnimalBreedService;
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
public class AnimalBreedController {
    /**
     * 自动注入EEquipService
     * */
    @Autowired
    private AnimalBreedService aService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(AnimalBreedController.class);
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/seeAnimalBreed")
    public String findAnimalBreed(String RecordDate, Integer AnimalMatingNumber, String SowsNumber,
                                  String SowsSituation, String BoarsNumber,String BoarsSituation ,Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<AnimalBreed> pi = aService.findPageInfo(RecordDate, AnimalMatingNumber, SowsNumber, SowsSituation, BoarsNumber,BoarsSituation
                ,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(10);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalMatingNumber!=null && AnimalMatingNumber!=0)
        {
            model.addAttribute("AnimalMatingNumber", AnimalMatingNumber);
        }
        return "/AnimalBreeding/AnimalBreedInfo";
    }

    /**
     * 删除信息
     */
    @RequestMapping( "/deleteAnimalBreed")
    @ResponseBody
    public String deleteAnimalBreed(Integer AnimalMatingNumber) {
        int s = aService.deleteAnimalBreed(AnimalMatingNumber);
        return "/AnimalBreeding/AnimalBreedInfo";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addAnimalBreed" ,method = RequestMethod.POST)
    public String addAnimalBreed(@ModelAttribute AnimalBreed a) {
        logger.info("\n\nmmd"+a+"\n\n");
        int s = aService.addAnimalBreed(a);
        return "redirect:/seeAnimalBreed";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateAnimalBreed" ,method = RequestMethod.POST )
    public String updateAnimalBreed(AnimalBreed a)
    {
        aService.updateAnimalBreed(a);
        return "redirect:/seeAnimalBreed";
    }


    @RequestMapping( "/findAnimalBreedByAN")
    public String findAnimalBreedByAN(Integer AnimalMatingNumber, HttpSession session) {

        AnimalBreed animalbreed= aService.findAnimalBreedByAN(AnimalMatingNumber);
        session.setAttribute("animalbreed",animalbreed);

        return "/AnimalBreeding/EditAnimalBreed";
    }



}
