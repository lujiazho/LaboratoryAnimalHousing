package org.lah.AnimalHealth.controller;
import org.lah.AnimalHealth.domain.Request;
import org.lah.AnimalHealth.service.AnimalRequestService;
import org.lah.AnimalHealth.service.AnimalSelectService;
import org.lah.AnimalHealth.service.Impl.AnimalLoginServiceImpl;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/AnimalHealthMove")
public class AnimalMoveController {
    @Qualifier("AnimalLoginService")
    private AnimalLonginService service;
    @Autowired
    @Qualifier("AnimalSelectService")
    private AnimalSelectService service2;
    @Autowired
    @Qualifier("AnimalRequestService")
    private AnimalRequestService service3;
    private String var;
    @RequestMapping(value="/select",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select();
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/AnimalForm");
        return mv;
    }
    @RequestMapping(value="/select2",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select2(@RequestParam("id") String id,
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select2(id);
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/AnimalForm");
        return mv;
    }
    @RequestMapping(value="/select3",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView select3(
                                Model model,
                                HttpSession session,
                                ModelAndView mv) {
        List<Request> request=service3.select();
        model.addAttribute("request",request);
        mv.setViewName("/AnimalHealth/RequestTable");
        return mv;
    }

    @RequestMapping(value="/select4",method={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody String select4(@RequestBody List<Animal> index) {
        String var=index.get(0).getVar();
        return var;
    }
    @RequestMapping(value="/requestselect",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView requestselect(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        List<Animal> animals=service2.select();
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/RequestSelect");
        return mv;
    }
    @RequestMapping(value="/requestselect2",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView requestselect2(
            Model model,
            HttpSession session,
            ModelAndView mv) {
        String var="猪";
        List<Animal> animals=service2.select3(var);
        model.addAttribute("animals",animals);
        mv.setViewName("/AnimalHealth/RequestSelect");
        return mv;
    }
    @RequestMapping(value="/homepage",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView homepage(ModelAndView mv)
    {
        mv.setViewName("/AnimalHealth/V_AnimalMovePage");
        return mv;
    }
    @RequestMapping(value="/entrypage",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView entrypage(ModelAndView mv)
    {
        mv.setViewName("/AnimalHealth/V_AnimalEntryPage");
        return mv;
    }
    @RequestMapping(value="/getjson",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json")
    @ResponseBody
    public Map<String,Object> getjson()
    {
        List<Request> requests=service3.select();
        Map<String,Object> resultMap = new HashMap<String, Object>();

        int size=requests.size();

        resultMap.put("code",0);

        resultMap.put("msg","");

        resultMap.put("count",String.valueOf(size));

        resultMap.put("data",requests);

// String json = JSON.toJSONString(bg01s);

// String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+bg01s.size()+",\"data\":"+json+"}";

        return resultMap;
    }
}
