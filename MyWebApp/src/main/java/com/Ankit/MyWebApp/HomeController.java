package com.Ankit.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping("home")
        public ModelAndView home(@RequestParam("name") String name)
    {
        ModelAndView mv=new ModelAndView();
        mv.addObject("name",name);
        mv.setViewName("home2");
        return mv;

    }
    @RequestMapping("about")
    public ModelAndView home(Alien alien)
    {
        ModelAndView mv=new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("about");
        return mv;

    }
    //    public String home(@RequestParam("name") String name,HttpSession session)
//    {
////        HttpSession session=req.getSession();
////        String name=req.getParameter("name");
//        System.out.println("Hi "+name);
//        session.setAttribute("name",name);
//        return "home2";
//
//    }


}
