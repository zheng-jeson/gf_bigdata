package com.ruoyi.project.business.queueTicketInfo.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.constant.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.queueTicketInfo.mapper.QueueTicketInfoMapper;
import com.ruoyi.project.business.queueTicketInfo.domain.QueueTicketInfo;
import com.ruoyi.project.business.queueTicketInfo.service.IQueueTicketInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 排队信息Service业务层处理
 * 
 * @author jeson
 * @date 2022-05-26
 */
@Service
public class QueueTicketInfoServiceImpl implements IQueueTicketInfoService 
{
    @Autowired
    private QueueTicketInfoMapper queueTicketInfoMapper;

    /**
     * 查询排队信息
     * 
     * @param unid 排队信息主键
     * @return 排队信息
     */
    @Override
    public QueueTicketInfo selectQueueTicketInfoByUnid(String unid)
    {
        return queueTicketInfoMapper.selectQueueTicketInfoByUnid(unid);
    }

    /**
     * 查询排队信息列表
     * 
     * @param queueTicketInfo 排队信息
     * @return 排队信息
     */
    @Override
    public List<QueueTicketInfo> selectQueueTicketInfoList(QueueTicketInfo queueTicketInfo)
    {
        return queueTicketInfoMapper.selectQueueTicketInfoList(queueTicketInfo);
    }

    /**
     * 新增排队信息
     * 
     * @param queueTicketInfo 排队信息
     * @return 结果
     */
    @Override
    public int insertQueueTicketInfo(QueueTicketInfo queueTicketInfo)
    {
        return queueTicketInfoMapper.insertQueueTicketInfo(queueTicketInfo);
    }

    /**
     * 修改排队信息
     * 
     * @param queueTicketInfo 排队信息
     * @return 结果
     */
    @Override
    public int updateQueueTicketInfo(QueueTicketInfo queueTicketInfo)
    {
        return queueTicketInfoMapper.updateQueueTicketInfo(queueTicketInfo);
    }

    /**
     * 批量删除排队信息
     * 
     * @param unids 需要删除的排队信息主键
     * @return 结果
     */
    @Override
    public int deleteQueueTicketInfoByUnids(String unids)
    {
        return queueTicketInfoMapper.deleteQueueTicketInfoByUnids(Convert.toStrArray(unids));
    }

    /**
     * 删除排队信息信息
     * 
     * @param unid 排队信息主键
     * @return 结果
     */
    @Override
    public int deleteQueueTicketInfoByUnid(String unid)
    {
        return queueTicketInfoMapper.deleteQueueTicketInfoByUnid(unid);
    }

    @Override
    public Integer findCurrentTakedCount(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentTakedCount(map);
    }

    @Override
    public Integer findCurrentCalledCount(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentCalledCount(map);
    }

    @Override
    public Integer findCurrentWaitCount(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentWaitCount(map);
    }

    @Override
    public Integer findCurrentAvgWaitTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentAvgWaitTime(map);
    }

    @Override
    public Integer findCurrentAvgHandleTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentAvgHandleTime(map);
    }

    @Override
    public Integer findCurrentMaxWaitTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentMaxWaitTime(map);
    }

    @Override
    public Integer findCurrentMaxHandleTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentMaxHandleTime(map);
    }

    @Override
    public Integer findCurrentMinWaitTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentMinWaitTime(map);
    }

    @Override
    public Integer findCurrentMinHandleTime(HashMap<String, String> map) {
        return queueTicketInfoMapper.findCurrentMinHandleTime(map);
    }

    @Override
    public List<Map<String, Object>> windowRank(HashMap<String, String> map) {
        return queueTicketInfoMapper.windowRank(map);
    }

    @Override
    public Integer selectProcessTimeMoreThanThirtyMinute(HashMap<String, Object> map) {
        return queueTicketInfoMapper.selectProcessTimeMoreThanThirtyMinute(map);
    }

    @Override
    public Integer selectProcessTimeLessThanThreeMinute(HashMap<String, Object> map) {
        return queueTicketInfoMapper.selectProcessTimeLessThanThreeMinute(map);
    }

    @Override
    public Integer selectProcessTimeBetweenThreeAndThirtyMinute(HashMap<String, Object> map) {
        return queueTicketInfoMapper.selectProcessTimeBetweenThreeAndThirtyMinute(map);
    }

    @Override
    public List<Map<String, Object>> selectAgeData(HashMap<String, String> map) {
        return queueTicketInfoMapper.selectAgeData(map);
    }

    @Override
    public List<Map<String, Object>> selectSexData(HashMap<String, String> map) {
        return queueTicketInfoMapper.selectSexData(map);
    }

    @Override
    public HashMap<String, Object> monthBest(HashMap<String, String> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String startDate = DateUtil.format(DateUtil.beginOfMonth(new Date()), "yyyy-MM-dd");
        String endDate = DateUtil.format(DateUtil.endOfMonth(new Date()), "yyyy-MM-dd");
        map.put("startTime",startDate);
        map.put("endTime",endDate);
        List<Map<String, Object>> list1 =queueTicketInfoMapper.selectQuYuHandle(map);
        List<Map<String, Object>> list2 =queueTicketInfoMapper.selectWindowHandle(map);
        hashMap.put("maxFt",list1.get(0).get("machine_code").toString());
        hashMap.put("maxWindow",list2.get(0).get("window_num").toString());
        return hashMap;
    }

    @Override
    public List<Map<String, Object>> avgWorkDay(HashMap<String, String> map) {
        ArrayList<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        String startDate = DateUtil.format(DateUtil.beginOfMonth(new Date()), "yyyy-MM-dd");
        String endDate = DateUtil.format(DateUtil.endOfMonth(new Date()), "yyyy-MM-dd");
        List<Map<String, Object>> list = queueTicketInfoMapper.selectAvgWorkDay(map);
        if(CollUtil.isEmpty(list)) return resultList;
        list = list.stream().sorted((a, b) -> (Integer.parseInt(a.get("process_num").toString()) - Integer.parseInt(b.get("process_num").toString()))).collect(Collectors.toList());
        for (Map<String, Object> m : list) {
            String week = "";
            switch (m.get("week").toString()){
                case "Monday":
                    week="周一";break;
                case "Tuesday":
                    week="周二";break;
                case "Wednesday":
                    week="周三";break;
                case "Thursday":
                    week="周四";break;
                case "Friday":
                    week="周五";break;
                case "Saturday":
                    week="周六";break;
                case "Sunday":
                    week = "周日";break;

            }
            if(week.equals("周六") || week.equals("周日")) continue;
            HashMap<String, Object> map1 = new HashMap<>();
            //int handleCount = cn.hutool.core.convert.Convert.toInt(m.get("process_num") )/ cn.hutool.core.convert.Convert.toInt(m.get("num"));
            int handleCount = cn.hutool.core.convert.Convert.toInt(m.get("process_num") );
            map1.put("week",week);
            map1.put("handleCount",handleCount);
            resultList.add(map1);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queueRank(HashMap<String, String> map) {

        return queueTicketInfoMapper.queueRank(map);
    }

    /**
     * 从排队云端拉取排队数据
     * 定时任务每3分钟拉取一次
     * @author Zhenghaojie
     * @date 2022/5/27 10:25
     */
    @Override
    public void pullQueueTicketInfo() {
            //调用接口获取数据
            String url = UrlConstants.QUEUETICKET_URL+"getTicketInfoListByCard";
            String result = "";
            //构造请求参数
            String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            String startTime = DateUtil.format(DateUtil.beginOfDay(new Date()), "yyyy-MM-dd HH:mm:ss");
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("siteCode", "zz_zdxq");//此处暂时指定中原科技城
            paramMap.put("startDate",startTime );
            paramMap.put("endDate", endTime);
            //调用接口
            try {
                result = HttpUtil.get(url, paramMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONUtil.parseObj(result);
            if(jsonObject!=null && CollUtil.isNotEmpty(jsonObject.getJSONArray("data"))) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = JSONUtil.parseObj(o);
                    QueueTicketInfo ticketInfo = new QueueTicketInfo();

                    ticketInfo.setUnid(json.getStr("unid"));
                    ticketInfo.setQueueCode(json.getStr("queueCode"));
                    ticketInfo.setQueueName(json.getStr("queueName"));
                    ticketInfo.setMachineCode(json.getStr("machineCode"));
                    ticketInfo.setSiteCode(json.getStr("siteCode"));
                    ticketInfo.setAreaCode(json.getStr("areaCode"));
                    ticketInfo.setTicketNumber(json.getStr("ticketNumber"));
                    ticketInfo.setQueueTime(json.getDate("queueTime"));
                    ticketInfo.setCalledTime(json.getDate("calledTime"));
                    ticketInfo.setWaitSecondCount(json.getLong("waitSecondCount"));
                    ticketInfo.setLeftTime(json.getDate("leftTime"));
                    ticketInfo.setTicketChannel(json.getStr("ticketChannel"));
                    ticketInfo.setHandleSecondCount(json.getLong("handleSecondCount"));
                    ticketInfo.setEvaluateStatus(json.getInt("evaluateStatus"));
                    ticketInfo.setEvaluateTime(json.getDate("evaluateTime"));
                    ticketInfo.setWindowCode(json.getStr("windowCode"));
                    ticketInfo.setWindowName(json.getStr("windowName"));
                    ticketInfo.setWindowEmpName(json.getStr("windowEmpName"));
                    ticketInfo.setWindowEmpNum(json.getStr("windowEmpNum"));
                    ticketInfo.setTicketStatus(json.getInt("ticketStatus"));
                    ticketInfo.setUserName(json.getStr("userName"));
                    ticketInfo.setUserMobile(json.getStr("userMobile"));
                    ticketInfo.setUserCardNumber(json.getStr("userCardNumber"));
                    ticketInfo.setAppointmentTime(json.getDate("appointmentTime"));
                    ticketInfo.setUserAddress(json.getStr("userAddress"));
                    ticketInfo.setUserSex(json.getStr("userSex"));
                    ticketInfo.setUserPhotoPath(json.getStr("userPhotoPath"));
                    ticketInfo.setSynStatus(json.getInt("synStatus"));
                    ticketInfo.setSynTime(json.getDate("synTime"));
                    ticketInfo.setSynUnid(json.getStr("synUnid"));
                    ticketInfo.setSynUrl(json.getStr("synUrl"));
                    ticketInfo.setGuid(json.getStr("guid"));
                    ticketInfo.setCalledStatus(json.getInt("calledStatus"));
                    ticketInfo.setLeftStatus(json.getInt("leftStatus"));
                    ticketInfo.setDeptCode(json.getStr("deptCode"));
                    ticketInfo.setDeptName(json.getStr("deptName"));
                    ticketInfo.setWindowEmpUnid(json.getStr("windowEmpUnid"));
                    ticketInfo.setWindowNum(json.getStr("windowNum"));
                    //根据id判断数据库是否存在
                    if (queueTicketInfoMapper.selectQueueTicketInfoByUnid(json.getStr("unid")) != null) {
                        this.updateQueueTicketInfo(ticketInfo);
                    } else {
                        this.insertQueueTicketInfo(ticketInfo);
                    }

                }
            }
    }

    /**
     * 从排队云端拉取排队数据全量
     * @author Zhenghaojie
     * @date 2022/5/27 10:25
     */
    @Override
    public void pullQueueTicketInfoAll() {
        //调用接口获取数据
        String url = UrlConstants.QUEUETICKET_URL+"getTicketInfoListByCard";
        String result = "";
        //构造请求参数
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("siteCode", "zz_zdxq");//此处暂时指定中原科技城
        //调用接口
        try {
            result = HttpUtil.get(url, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if(jsonObject!=null && CollUtil.isNotEmpty(jsonObject.getJSONArray("data"))) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = JSONUtil.parseObj(o);


                QueueTicketInfo ticketInfo = new QueueTicketInfo();

                ticketInfo.setUnid(json.getStr("unid"));
                ticketInfo.setQueueCode(json.getStr("queueCode"));
                ticketInfo.setQueueName(json.getStr("queueName"));
                ticketInfo.setMachineCode(json.getStr("machineCode"));
                ticketInfo.setSiteCode(json.getStr("siteCode"));
                ticketInfo.setAreaCode(json.getStr("areaCode"));
                ticketInfo.setTicketNumber(json.getStr("ticketNumber"));
                ticketInfo.setQueueTime(json.getDate("queueTime"));
                ticketInfo.setCalledTime(json.getDate("calledTime"));
                ticketInfo.setWaitSecondCount(json.getLong("waitSecondCount"));
                ticketInfo.setLeftTime(json.getDate("leftTime"));
                ticketInfo.setTicketChannel(json.getStr("ticketChannel"));
                ticketInfo.setHandleSecondCount(json.getLong("handleSecondCount"));
                ticketInfo.setEvaluateStatus(json.getInt("evaluateStatus"));
                ticketInfo.setEvaluateTime(json.getDate("evaluateTime"));
                ticketInfo.setWindowCode(json.getStr("windowCode"));
                ticketInfo.setWindowName(json.getStr("windowName"));
                ticketInfo.setWindowEmpName(json.getStr("windowEmpName"));
                ticketInfo.setWindowEmpNum(json.getStr("windowEmpNum"));
                ticketInfo.setTicketStatus(json.getInt("ticketStatus"));
                ticketInfo.setUserName(json.getStr("userName"));
                ticketInfo.setUserMobile(json.getStr("userMobile"));
                ticketInfo.setUserCardNumber(json.getStr("userCardNumber"));
                ticketInfo.setAppointmentTime(json.getDate("appointmentTime"));
                ticketInfo.setUserAddress(json.getStr("userAddress"));
                ticketInfo.setUserSex(json.getStr("userSex"));
                ticketInfo.setUserPhotoPath(json.getStr("userPhotoPath"));
                ticketInfo.setSynStatus(json.getInt("synStatus"));
                ticketInfo.setSynTime(json.getDate("synTime"));
                ticketInfo.setSynUnid(json.getStr("synUnid"));
                ticketInfo.setSynUrl(json.getStr("synUrl"));
                ticketInfo.setGuid(json.getStr("guid"));
                ticketInfo.setCalledStatus(json.getInt("calledStatus"));
                ticketInfo.setLeftStatus(json.getInt("leftStatus"));
                ticketInfo.setDeptCode(json.getStr("deptCode"));
                ticketInfo.setDeptName(json.getStr("deptName"));
                ticketInfo.setWindowEmpUnid(json.getStr("windowEmpUnid"));
                ticketInfo.setWindowNum(json.getStr("windowNum"));
                //根据id判断数据库是否存在
                if (queueTicketInfoMapper.selectQueueTicketInfoByUnid(json.getStr("unid")) != null) {
                    this.updateQueueTicketInfo(ticketInfo);
                } else {
                    this.insertQueueTicketInfo(ticketInfo);
                }

            }
        }
    }
}
