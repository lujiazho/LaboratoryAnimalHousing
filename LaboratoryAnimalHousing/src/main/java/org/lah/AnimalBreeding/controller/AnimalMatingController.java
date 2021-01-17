package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.AnimalMating;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.AnimalMatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理动物配种记录表相关请求
 */
@Controller
public class AnimalMatingController {
    /**
     * 自动注入AnimalMatingService
     * */
    @Autowired
    private AnimalMatingService animalMatingService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(AnimalMatingController.class);

    /**
     * 分页查询动物配种记录表信息
     */
    @RequestMapping(value = "/findAnimalMating")
    public String findAnimalMating(Integer AnimalMatingNumber,String BoarNumber,String SowNumber,Integer RoomNumber,String MatingStartTime,
                                   String MatingEndTime,String Note, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<AnimalMating> pi = animalMatingService.findPageInfo(AnimalMatingNumber,BoarNumber,SowNumber, RoomNumber,MatingStartTime,MatingEndTime,Note,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalMatingNumber!=null){
            model.addAttribute("AnimalMatingNumber", AnimalMatingNumber);
        }
        return "/AnimalBreeding/ShowAnimalMating";
    }

    /**
     * 删除动物配种记录表信息
     */
    @RequestMapping( "/deleteAnimalMating")
    @ResponseBody
    public String deleteStudent(Integer AnimalMatingNumber) {
        int s = animalMatingService.deleteAnimalMating(AnimalMatingNumber);
        return "/AnimalBreeding/ShowAnimalMating";
    }

    /**
     * 添加动物配种记录表信息
     */
    @RequestMapping(value = "/addAnimalMating" ,method = RequestMethod.POST)
    public String addAnimalMating(@ModelAttribute AnimalMating animalMating) {
        logger.info("\n\nmmd"+animalMating+"\n\n");
        int s = animalMatingService.addAnimalMating(animalMating);
        return "redirect:/findAnimalMating";
    }

    /**
     * 修改动物配种记录表信息
     */
    @RequestMapping(value = "/updateAnimalMating" ,method = RequestMethod.POST )
    public String updateAnimalMating( AnimalMating animalMating) {
        animalMatingService.updateAnimalMating(animalMating);
        int s = animalMatingService.updateAnimalMating(animalMating);
        return "redirect:/findAnimalMating";
    }

    /**
     * 根据ID查找动物配种记录表信息
     */
    @RequestMapping( "/findAnimalMatingById")
    public String findAnimalMatingById(Integer AnimalMatingNumber, HttpSession session) {
        AnimalMating animalMating= animalMatingService.findAnimalMatingById(AnimalMatingNumber);
        session.setAttribute("animalMating",animalMating);
        return "/AnimalBreeding/RecordAnimalMating";
    }
}
