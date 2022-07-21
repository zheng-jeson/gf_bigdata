package com.ruoyi.web.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.business.queueTicketInfo.service.IQueueTicketInfoService;
import com.ruoyi.web.service.WebService;
import com.ruoyi.web.vo.Bigdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @program: WebController
 * @author: ZHJ
 * @create: 2021-07-15 15:01
 */

@RequestMapping("/bigData")
@RestController
@CrossOrigin("*")
public class WebController {
    @Autowired
    private WebService webService;
    @Autowired
    private IQueueTicketInfoService queueTicketInfoService;


    /**
     * 大厅累计接待量，办件量
     * 根据起止时间和网点编码查询
     * @param request
     * @return
     */
    @RequestMapping("/hallSumData")
    public AjaxResult hallSumData(HttpServletRequest request){

        Integer days = null;
        String siteCode = request.getParameter("siteCode");
        if(StrUtil.isNotEmpty(request.getParameter("days"))){
            days = Integer.parseInt(request.getParameter("days"));
        }

        Map map = webService.hallSumData(siteCode,days);
        return AjaxResult.success(map);
    }

    /**
     * 大厅当前状况
     * 根据sitecode查询
     * 返回当前取号量，办理量，平均...，最大...，最小...
     * @param request
     * @return
     */
    @RequestMapping("/hallCurData")
    public AjaxResult hallCurData(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        Bigdata data =  webService.hallCurData(siteCode);
        return AjaxResult.success(data);
    }


    /**
     * 窗口工作量排行
     * 根据sitecode查询
     * 返回该大厅下所有的窗口名称，orgcode，办件量
     * @param request
     * @return
     */
    @RequestMapping("/windowRank")
    public AjaxResult windowRank(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        List<Map<String, Object>> list =  webService.windowRank(siteCode);
        return AjaxResult.success(list);
    }

    /**
     * 办件时长监控
     * 返回办件时长大于30分钟，小于3分钟，3-30分钟的数量
     * @param request
     * @return
     */
    @RequestMapping("/processTimeMonitor")
    public AjaxResult processTimeMonitor(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        Map<String,Object> map =  webService.processTimeMonitor(siteCode,areaCode);
        return AjaxResult.success(map);
    }

    /**
     * 取号量监测
     * @param request
     * @return
     */
    @RequestMapping("/fetchMonitor")
    public AjaxResult fetchMonitor(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        List<Map<String,String>> list =  webService.fetchMonitor(siteCode);
        return AjaxResult.success(list);
    }

    /**
     * 计算年龄分布
     * @param request
     * @return
     */
    @RequestMapping("/ageData")
    public AjaxResult ageData(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        List<Map<String,Object>> list =  webService.ageData(siteCode,areaCode);
        return AjaxResult.success(list);
    }


    /**
     * 计算性别比例
     * @param request
     * @return
     */
    @RequestMapping("/sexData")
    public AjaxResult sexData(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        List<Map<String,Object>> list =  webService.sexData(siteCode,areaCode);
        return AjaxResult.success(list);
    }


    /**
     * 本月最排行
     *返回办件量最多分厅，办件量对多窗口，最忙工作日，最闲工作日，最忙时间段，最闲时段
     * @param request
     * @return
     */
    @RequestMapping("/monthBest")
    public AjaxResult monthBest(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        Map<String,Object> map =  webService.monthBest(siteCode,areaCode);
        return AjaxResult.success(map);
    }

    /**
     * 本月工作日平均办理量
     *返回周一到周五每天平均办理量
     * @param request
     * @return
     */
    @RequestMapping("/avgWorkDay")
    public AjaxResult avgWorkDay(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        List<Map<String,Object>> list =  webService.avgWorkDay(siteCode,areaCode);
        return AjaxResult.success(list);
    }

    /**
     * 事项排行
     * 按条件办件量倒序
     * @param request
     * @return
     */
    @RequestMapping("/queueRank")
    public AjaxResult queueRank(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        List<Map<String, Object>> list =  webService.queueRank(siteCode,areaCode);
        return AjaxResult.success(list);
    }


    @RequestMapping("/pullQueueTicketAll")
    public AjaxResult pullQueueTicketAll(HttpServletRequest request){
        String siteCode = request.getParameter("siteCode");
        String areaCode = request.getParameter("areaCode");
        queueTicketInfoService.pullQueueTicketInfoAll();
        return AjaxResult.success();
    }


}
