package com.ruoyi.web.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.business.queueTicketInfo.domain.QueueTicketInfo;
import com.ruoyi.project.business.queueTicketInfo.mapper.QueueTicketInfoMapper;
import com.ruoyi.project.business.queueTicketInfo.service.IQueueTicketInfoService;
import com.ruoyi.web.vo.Bigdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @description:
 * @program: WebService
 * @author: ZHJ
 * @create: 2021-07-27 13:03
 */
@Service
public class WebService {

    @Autowired
    private QueueTicketInfoMapper queueTicketInfoMapper;
    @Autowired
    private IQueueTicketInfoService queueTicketInfoService;

    public Map hallSumData(String siteCode, Integer days) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer sumTotalCount = 0;
        Integer sumProcessedCount = 0;
        String startdate ="";
        String enddate ="";
        Date date = new Date();
        if(days==null){
            DateTime startDate = DateUtil.beginOfYear(date);
            DateTime endDate = DateUtil.endOfYear(date);
            startdate = DateUtil.format(startDate, "yyyy-MM-dd HH:mm:ss");
            enddate = DateUtil.format(endDate,"yyyy-MM-dd HH:mm:ss");
        }else if(days==30){
            startdate = DateUtil.format(DateUtil.beginOfMonth(new Date()),"yyyy-MM-dd HH:mm:ss");
            enddate = DateUtil.format(DateUtil.endOfMonth(new Date()),"yyyy-MM-dd HH:mm:ss");
        }else if(days==7){
            startdate = DateUtil.format(DateUtil.beginOfWeek(new Date()),"yyyy-MM-dd HH:mm:ss");
            enddate = DateUtil.format(DateUtil.endOfWeek(new Date()),"yyyy-MM-dd HH:mm:ss");
        }else if(days==1){
            startdate = DateUtil.format(DateUtil.beginOfDay(new Date()),"yyyy-MM-dd HH:mm:ss");
            enddate = DateUtil.format(DateUtil.endOfDay(new Date()),"yyyy-MM-dd HH:mm:ss");
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode",siteCode);
        map.put("startTime",startdate);
        map.put("endTime",enddate);
        Integer takeNum = queueTicketInfoMapper.countTakeNumber(map);
        Integer callNum = queueTicketInfoMapper.countCallNumber(map);
        resultMap.put("fetchNum",takeNum);
        resultMap.put("processNum",callNum);
        return resultMap;
    }

    public Bigdata hallCurData(String siteCode) {
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        //求当前取号量
        Integer takedCount = queueTicketInfoService.findCurrentTakedCount(map);
        //求当前叫号量
        Integer calledCount = queueTicketInfoService.findCurrentCalledCount(map);
        //求当前等待量
        Integer waitCount = queueTicketInfoService.findCurrentWaitCount(map);
        //求平均等待时长
        Integer avgWaitTime = queueTicketInfoService.findCurrentAvgWaitTime(map);
        //求平均办理时长
        Integer avgHandleTime = queueTicketInfoService.findCurrentAvgHandleTime(map);
        //求最大等待时长
        Integer maxWaitTime = queueTicketInfoService.findCurrentMaxWaitTime(map);
        //求最大办理时长
        Integer maxHandleTime = queueTicketInfoService.findCurrentMaxHandleTime(map);
        //求最小等待时长
        Integer minWaitTime = queueTicketInfoService.findCurrentMinWaitTime(map);
        //求最小办理时长
        Integer minHandleTime = queueTicketInfoService.findCurrentMinHandleTime(map);
        Bigdata bigdata = new Bigdata().setFetchNum(takedCount).setProcessNum(calledCount).setWaitNum(waitCount)
                .setAvgWaitTime(avgWaitTime).setAvgProcessTime(avgHandleTime)
                .setMaxWaitTime(maxWaitTime).setMaxProcessTime(maxHandleTime)
                .setMinProcessTime(minHandleTime).setMinWaitTime(minWaitTime);
        jsonObject.put("siteCode", siteCode);
        jsonObject.put("takedCount", takedCount);
        jsonObject.put("calledCount", calledCount);
        jsonObject.put("waitCount", waitCount);
        jsonObject.put("avgWaitTime", avgWaitTime);
        jsonObject.put("avgHandleTime", avgHandleTime);
        jsonObject.put("maxWaitTime", maxWaitTime);
        jsonObject.put("maxHandleTime", maxHandleTime);
        jsonObject.put("minWaitTime", minWaitTime);
        jsonObject.put("minHandleTime", minHandleTime);
        return bigdata;
    }

    public List<Map<String, Object>> windowRank(String siteCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        List<Map<String, Object>> list = queueTicketInfoService.windowRank(map);
        return list;
    }

    public Map<String, Object> processTimeMonitor(String siteCode, String areaCode) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("siteCode", siteCode);
        Integer x = queueTicketInfoService.selectProcessTimeMoreThanThirtyMinute(map);
        Integer y = queueTicketInfoService.selectProcessTimeLessThanThreeMinute(map);
        Integer z = queueTicketInfoService.selectProcessTimeBetweenThreeAndThirtyMinute(map);
        map.clear();
        map.put("moreThanThirty",x);
        map.put("lessThanThree",y);
        map.put("threeAndThrity",z);
        return map;
    }

    public List<Map<String, String>> fetchMonitor(String siteCode) {
        ArrayList<String> times = new ArrayList<>();
        Date date = new Date();
        String dateStr = DateUtil.format(date, "yyyy-MM-dd");
        times.add("08:00");
        times.add("08:20");
        times.add("08:40");
        times.add("09:00");
        times.add("09:20");
        times.add("09:40");
        times.add("10:00");
        times.add("10:20");
        times.add("10:40");
        times.add("11:00");
        times.add("11:20");
        times.add("11:40");
        times.add("12:00");
        times.add("13:00");
        times.add("13:20");
        times.add("13:40");
        times.add("14:00");
        times.add("14:20");
        times.add("14:40");
        times.add("15:00");
        times.add("15:20");
        times.add("15:40");
        times.add("16:00");
        times.add("16:20");
        times.add("16:40");
        times.add("17:00");
        ArrayList<Map<String, String>> listMaps = new ArrayList<>();
        for (int i = 0;i<times.size();i++) {
            if(DateUtil.parse(dateStr + " " + times.get(i) + ":00").isBefore(date)){
                if(i==0){
                    HashMap<String, String> map = new HashMap<>();
                    map.put("siteCode", siteCode);
                    map.put("startTime", dateStr+" 08:00:00");
                    map.put("endTime", dateStr + " " + times.get(i) + ":00");
                    Integer count = queueTicketInfoMapper.countTakeNumber(map);
                    map.clear();
                    map.put("time",times.get(i));
                    map.put("fetchNum",count+"");
                    listMaps.add(map);
                }else{
                    HashMap<String, String> map = new HashMap<>();
                    map.put("siteCode", siteCode);
                    map.put("startTime", dateStr+" "+times.get(i-1)+":00");
                    map.put("endTime", dateStr + " " + times.get(i) + ":00");
                    Integer count = queueTicketInfoMapper.countTakeNumber(map);
                    map.clear();
                    map.put("time",times.get(i));
                    map.put("fetchNum",count+"");
                    listMaps.add(map);
                }
            }else{
                HashMap<String, String> map = new HashMap<>();
                map.put("time",times.get(i));
                map.put("fetchNum",0+"");
                listMaps.add(map);
            }
        }

        return listMaps;
    }

    public List<Map<String, Object>> ageData(String siteCode, String areaCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        List<Map<String, Object>> list =queueTicketInfoService.selectAgeData(map);
        return list;
    }

    public List<Map<String, Object>> sexData(String siteCode, String areaCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        List<Map<String, Object>> list =queueTicketInfoService.selectSexData(map);
        return list;
    }

    public Map<String, Object> monthBest(String siteCode, String areaCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        HashMap<String, Object> resultMap  =queueTicketInfoService.monthBest(map);
        return resultMap;
    }

    public List<Map<String, Object>> avgWorkDay(String siteCode, String areaCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        List<Map<String, Object>> list =queueTicketInfoService.avgWorkDay(map);
        return list;
    }

    public List<Map<String, Object>> queueRank(String siteCode, String areaCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("siteCode", siteCode);
        List<Map<String, Object>> list =queueTicketInfoService.queueRank(map);
        return list;
    }
}
