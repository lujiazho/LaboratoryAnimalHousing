package org.lah.AnimalHealth.controller;
import org.lah.AnimalHealth.domain.Qua;
import org.lah.AnimalHealth.service.AnimalSelectService;
import org.lah.AnimalHealth.service.Impl.AnimalLoginServiceImpl;
import org.lah.AnimalHealth.service.QuaService;
import org.lah.Commons.LahConstants;
import org.lah.AnimalHealth.service.AnimalLonginService;
import org.lah.AnimalHealth.domain.Animal;
import org.lah.Commons.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/AnimalHealthLogin")
public class AnimalLoginController {
    @Autowired
    @Qualifier("AnimalLoginService")
    private AnimalLonginService service;
    @Autowired
    @Qualifier("QuaService")
    private QuaService qservice;
    @Autowired
    @Qualifier("AnimalSelectService")
    private AnimalSelectService service2;
    private static final Log logger = LogFactory.getLog(AnimalLoginController.class);
    @RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView login(@ModelAttribute Animal animal,
                                Model model,
                                ModelAndView mv) {
        if(animal.getId()==null)
        {
            mv.setViewName("/AnimalHealth/AddAnimal");
            return mv;
        }
        //System.out.println(animal.toString());
        service.login(animal);
        mv.setViewName("/AnimalHealth/AddAnimal");
        return mv;
    }
    @RequestMapping(value="/qualogin",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView qualogin(@ModelAttribute Qua qua,
                              Model model,
                              ModelAndView mv) {
        if(qua.getId()==null)
        {
            mv.setViewName("/AnimalHealth/AddQua");
            return mv;
        }
        //System.out.println(animal.toString());
        qservice.login(qua);
        service.update(qua.getId(),qua.getCons());
        mv.setViewName("/AnimalHealth/AddQua");
        return mv;
    }

    @RequestMapping(value="/select",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select();
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/AnimalTable");
        return mv;
    }
    @RequestMapping(value="/select2",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select2(
            @RequestParam("id") String id,
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select2(id);
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/AnimalTable");
        return mv;
    }
    @RequestMapping(value="/select3",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select3(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select();
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/AnimalTableEditable");
        return mv;
    }
    @RequestMapping(value="/qselect",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView qselect(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Qua> quas=qservice.select();
        model.addAttribute("quas",quas);
        mv.setViewName("/AnimalHealth/QuaSelect");
        return mv;
    }
    @RequestMapping(value="/qselect2",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView qselect2(
            @RequestParam("id") String id,
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Qua> quas=qservice.select2(id);
        model.addAttribute("quas",quas);
        mv.setViewName("/AnimalHealth/QuaSelect");
        return mv;
    }
    @RequestMapping(value="/qselect3",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView qselect3(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Qua> quas=qservice.select();
        model.addAttribute("quas",quas);
        mv.setViewName("/AnimalHealth/QuaSelect");
        return mv;
    }
    @RequestMapping(value="/homepage",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView homepage(ModelAndView mv)
    {
        mv.setViewName("AnimalHealth/V_AnimalEntryPage");
        return mv;
    }
    @RequestMapping(value="/movepage",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView movepage(ModelAndView mv)
    {
        mv.setViewName("AnimalHealth/V_AnimalMovePage");
        return mv;
    }
    @RequestMapping(value="/getjson",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public Map<String,Object> getjson()
    {
        List<Animal> animals=service2.select();
        Map<String,Object> resultMap = new HashMap<String, Object>();

        int size=animals.size();

        resultMap.put("code",0);

        resultMap.put("msg","");

        resultMap.put("count",String.valueOf(size));

        resultMap.put("data",animals);

// String json = JSON.toJSONString(bg01s);

// String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+bg01s.size()+",\"data\":"+json+"}";

        return resultMap;
    }
}
