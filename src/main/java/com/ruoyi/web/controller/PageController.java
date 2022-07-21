package com.ruoyi.web.controller;


import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * @description:
 * @program: PageController
 * @author: ZHJ
 * @create: 2021-07-15 15:02
 */
@Controller
@RequestMapping("/bigDataWeb")
public class PageController {

    private String prefix = "web/";

    @RequestMapping("/v1")
    public String v1(HttpServletRequest request){

        //Enumeration paramNames = request.getParameterNames();
        //while (paramNames.hasMoreElements()) {
        //    String paramName = (String) paramNames.nextElement();
        //    request.setAttribute(paramName,request.getParameter(paramName));
        //}
        String siteCode = request.getParameter("siteCode");
        if(StrUtil.isNotEmpty(siteCode) && StrUtil.equals(siteCode,"zz_jkq")){
            return prefix + siteCode+"/jkq";
        }
        if(StrUtil.isNotEmpty(siteCode) && StrUtil.equals(siteCode,"zz_zykjc")){
            request.setAttribute("siteCode","zz_zdxq");
            return prefix + siteCode+"/zykjc";
        }
        return prefix +"zz_zykjc/zykjc";
    }
}
