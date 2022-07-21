package com.ruoyi.project.business.queueTicketInfo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.business.queueTicketInfo.domain.QueueTicketInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 排队信息Mapper接口
 * 
 * @author jeson
 * @date 2022-05-26
 */
public interface QueueTicketInfoMapper 
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
     * 删除排队信息
     * 
     * @param unid 排队信息主键
     * @return 结果
     */
    public int deleteQueueTicketInfoByUnid(String unid);

    /**
     * 批量删除排队信息
     * 
     * @param unids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQueueTicketInfoByUnids(String[] unids);

    Integer countTakeNumber(@Param("map")HashMap<String, String> map);

    Integer countCallNumber(@Param("map")HashMap<String, String> map);

    Integer findCurrentTakedCount(@Param("map")HashMap<String, String> map);

    Integer findCurrentCalledCount(@Param("map")HashMap<String, String> map);

    Integer findCurrentWaitCount(@Param("map")HashMap<String, String> map);

    Integer findCurrentAvgWaitTime(@Param("map")HashMap<String, String> map);

    Integer findCurrentAvgHandleTime(@Param("map")HashMap<String, String> map);

    Integer findCurrentMaxWaitTime(@Param("map")HashMap<String, String> map);

    Integer findCurrentMaxHandleTime(@Param("map")HashMap<String, String> map);

    Integer findCurrentMinWaitTime(@Param("map")HashMap<String, String> map);

    Integer findCurrentMinHandleTime(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> windowRank(@Param("map")HashMap<String, String> map);

    Integer selectProcessTimeMoreThanThirtyMinute(@Param("map")HashMap<String, Object> map);

    Integer selectProcessTimeLessThanThreeMinute(@Param("map")HashMap<String, Object> map);

    Integer selectProcessTimeBetweenThreeAndThirtyMinute(@Param("map")HashMap<String, Object> map);

    List<Map<String, Object>> selectAgeData(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> selectSexData(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> selectQuYuHandle(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> selectWindowHandle(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> selectAvgWorkDay(@Param("map")HashMap<String, String> map);

    List<Map<String, Object>> queueRank(@Param("map")HashMap<String, String> map);
}
