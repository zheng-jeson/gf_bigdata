package com.ruoyi.project.business.queueTicketInfo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.business.queueTicketInfo.domain.QueueTicketInfo;

/**
 * 排队信息Service接口
 * 
 * @author jeson
 * @date 2022-05-26
 */
public interface IQueueTicketInfoService 
{
    /**
     * 查询排队信息
     * 
     * @param unid 排队信息主键
     * @return 排队信息
     */
    public QueueTicketInfo selectQueueTicketInfoByUnid(String unid);

    /**
     * 查询排队信息列表
     * 
     * @param queueTicketInfo 排队信息
     * @return 排队信息集合
     */
    public List<QueueTicketInfo> selectQueueTicketInfoList(QueueTicketInfo queueTicketInfo);

    /**
     * 新增排队信息
     * 
     * @param queueTicketInfo 排队信息
     * @return 结果
     */
    public int insertQueueTicketInfo(QueueTicketInfo queueTicketInfo);

    /**
     * 修改排队信息
     * 
     * @param queueTicketInfo 排队信息
     * @return 结果
     */
    public int updateQueueTicketInfo(QueueTicketInfo queueTicketInfo);

    /**
     * 批量删除排队信息
     * 
     * @param unids 需要删除的排队信息主键集合
     * @return 结果
     */
    public int deleteQueueTicketInfoByUnids(String unids);

    /**
     * 删除排队信息信息
     * 
     * @param unid 排队信息主键
     * @return 结果
     */
    public int deleteQueueTicketInfoByUnid(String unid);

    Integer findCurrentTakedCount(HashMap<String, String> map);

    Integer findCurrentCalledCount(HashMap<String, String> map);

    Integer findCurrentWaitCount(HashMap<String, String> map);

    Integer findCurrentAvgWaitTime(HashMap<String, String> map);

    Integer findCurrentAvgHandleTime(HashMap<String, String> map);

    Integer findCurrentMaxWaitTime(HashMap<String, String> map);

    Integer findCurrentMaxHandleTime(HashMap<String, String> map);

    Integer findCurrentMinWaitTime(HashMap<String, String> map);

    Integer findCurrentMinHandleTime(HashMap<String, String> map);

    List<Map<String, Object>> windowRank(HashMap<String, String> map);

    Integer selectProcessTimeMoreThanThirtyMinute(HashMap<String, Object> map);

    Integer selectProcessTimeLessThanThreeMinute(HashMap<String, Object> map);

    Integer selectProcessTimeBetweenThreeAndThirtyMinute(HashMap<String, Object> map);

    List<Map<String, Object>> selectAgeData(HashMap<String, String> map);

    List<Map<String, Object>> selectSexData(HashMap<String, String> map);

    HashMap<String, Object> monthBest(HashMap<String, String> map);

    List<Map<String, Object>> avgWorkDay(HashMap<String, String> map);

    List<Map<String, Object>> queueRank(HashMap<String, String> map);


    void pullQueueTicketInfo();
    void pullQueueTicketInfoAll();
}
