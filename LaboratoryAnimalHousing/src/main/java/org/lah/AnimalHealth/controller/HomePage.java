package org.lah.AnimalHealth.controller;
import org.lah.Commons.LahConstants;
import org.lah.Commons.service.LoginService;
import org.lah.Commons.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/AnimalHealthlog")
public class HomePage {
    @RequestMapping(value = "/Page", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView toLogin(@RequestParam("pagename") String pagename,
                                HttpSession session,
                                ModelAndView mv) {
        if(pagename.equals("EntryPage"))
        {
            mv.setViewName("AnimalHealth/V_AnimalEntryPage");
        }
        else
        {
            mv.setViewName("AnimalHealth/V_AnimalMovePage");
        }
        return mv;
    }
}
