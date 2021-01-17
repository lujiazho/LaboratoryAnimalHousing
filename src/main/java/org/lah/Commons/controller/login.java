package org.lah.Commons.controller;
import org.lah.Commons.LahConstants;
import org.lah.Commons.service.LoginService;
import org.lah.Commons.domain.User;
import org.lah.Logistics.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class login {
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(login.class);

    @RequestMapping(value="/toLogin",method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView toLogin(@RequestParam("loginname") String loginname,
                              @RequestParam("password") String password,
                              HttpSession session,
                              ModelAndView mv){
        // 调用业务逻辑组件判断用户是否可以登录
        User user = loginService.login(loginname, password);
        if(user != null){
            // 将用户保存到HttpSession当中
            session.setAttribute(LahConstants.USER_SESSION, user);
            logger.info("登录名:"+loginname + " 密码:" + password);

            // 存在且不为空
            if(!user.getDepartment().equals("") && user.getDepartment()!=null
            && !user.getPosition().equals("") && user.getPosition()!=null){
                logger.info("部门:"+user.getDepartment() + " 职位:" + user.getPosition());
                logger.info("姓名:"+user.getUsername());
                // 后勤管理部门垃圾处理员登录
                if(user.getDepartment().equals("logistics") && user.getPosition().equals("cleaner")){
                    mv.setViewName("/Logistics/ReNew/cleaner_homepage");
                }
                // 后勤管理部门设备管理员（）登录
                else if (user.getDepartment().equals("logistics") && user.getPosition().equals("equipkeeper")){
                    mv.setViewName("/Logistics/ReNew/homepage");
                }
                // 动物饲养部门饲料员（）登录
                else if (user.getDepartment().equals("AnimalFeed") && user.getPosition().equals("FeedWorker")){
                    mv.setViewName("/AnimalFeed/homepage");
                }
                // 动物饲养部门垫料员（）登录
                else if (user.getDepartment().equals("AnimalFeed") && user.getPosition().equals("PaddingWorker")){
                    mv.setViewName("/AnimalFeed/homepage");
                }
                // 动物饲养部门管理员（）登录
                else if (user.getDepartment().equals("AnimalFeed") && user.getPosition().equals("AFManager")){
                    mv.setViewName("/AnimalFeed/homepage");
                }

                // 福利喂养部门登录
                else if (user.getDepartment().equals("WelfareFeeding")){
                    mv.setViewName("WelfareFeeding/index");
                }
                //动物健康管理登录
                else if (user.getDepartment().equals("AnimalHealth")&& user.getPosition().equals("HealthAdmin")){
                    mv.setViewName("/AnimalHealth/V_AnimalEntryPage");
                }
                else if (user.getDepartment().equals("AnimalHealth")&& user.getPosition().equals("MoveAdmin")){
                    mv.setViewName("/AnimalHealth/V_AnimalMovePage");
                }
                // 动物繁育部门选种员登录
                else if (user.getDepartment().equals("AnimalBreed") && user.getPosition().equals("BreedselectionWorker")){
                    mv.setViewName("/AnimalBreeding/homepage");
                }

            }else{
                // 客户端跳转到main页面
                mv.setViewName("/loginForm");
            }
        }else{
            // 设置登录失败提示信息
            mv.addObject("message", "登录名或密码错误!请重新输入");
            // 服务器内部跳转到登录页面
            mv.setViewName("/login_new");
        }
        return mv;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(Employee employee, Model model, HttpSession session) {
        session.invalidate();
        return "/login_new";

    }
}