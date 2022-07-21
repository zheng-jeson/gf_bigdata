package com.ruoyi.project.business.queueTicketInfo.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 排队信息对象 queue_ticket_info
 * 
 * @author jeson
 * @date 2022-05-26
 */
public class QueueTicketInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** unid */
    private String unid;

    /** 队列标识 */
    @Excel(name = "队列标识")
    private String queueCode;

    /** 队列名称 */
    @Excel(name = "队列名称")
    private String queueName;

    /** 排队机标识 */
    @Excel(name = "排队机标识")
    private String machineCode;

    /** 网点标识 */
    @Excel(name = "网点标识")
    private String siteCode;

    /** 区划代码 */
    @Excel(name = "区划代码")
    private String areaCode;

    /** 排队号 */
    @Excel(name = "排队号")
    private String ticketNumber;

    /** 取号时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "取号时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date queueTime;

    /** 叫号时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "叫号时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date calledTime;

    /** 等待时长 */
    @Excel(name = "等待时长")
    private Long waitSecondCount;

    /** 离开时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    @Excel(name = "离开时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date leftTime;

    /** 取号渠道 */
    @Excel(name = "取号渠道")
    private String ticketChannel;

    /** 业务办理时长 */
    @Excel(name = "业务办理时长")
    private Long handleSecondCount;

    /** 评价状态 */
    @Excel(name = "评价状态")
    private Integer evaluateStatus;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "评价时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date evaluateTime;

    /** 窗口编码 */
    @Excel(name = "窗口编码")
    private String windowCode;

    /** 窗口名称 */
    @Excel(name = "窗口名称")
    private String windowName;

    /** 窗口人员 */
    @Excel(name = "窗口人员")
    private String windowEmpName;

    /** 窗口人员工号 */
    @Excel(name = "窗口人员工号")
    private String windowEmpNum;

    /** 排队信息状态 */
    @Excel(name = "排队信息状态")
    private Integer ticketStatus;

    /** 群众姓名 */
    @Excel(name = "群众姓名")
    private String userName;

    /** 群众电话 */
    @Excel(name = "群众电话")
    private String userMobile;

    /** 群众身份证号 */
    @Excel(name = "群众身份证号")
    private String userCardNumber;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentTime;

    /** 群众地址 */
    @Excel(name = "群众地址")
    private String userAddress;

    /** 群众性别 */
    @Excel(name = "群众性别")
    private String userSex;

    /** 群众头像地址 */
    @Excel(name = "群众头像地址")
    private String userPhotoPath;

    /** 同步状态 */
    @Excel(name = "同步状态")
    private Integer synStatus;

    /** 同步时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date synTime;

    /** 同步云服务unid */
    @Excel(name = "同步云服务unid")
    private String synUnid;

    /** 同步云服务url */
    @Excel(name = "同步云服务url")
    private String synUrl;

    /** 全网唯一标识 */
    @Excel(name = "全网唯一标识")
    private String guid;

    /** 叫号标识 */
    @Excel(name = "叫号标识")
    private Integer calledStatus;

    /** 离开标识 */
    @Excel(name = "离开标识")
    private Integer leftStatus;

    /** 部门code */
    @Excel(name = "部门code")
    private String deptCode;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 办理人员unid */
    @Excel(name = "办理人员unid")
    private String windowEmpUnid;

    /** 预约标识 */
    @Excel(name = "预约标识")
    private Integer isApp;

    /** 排队日期标识，距2020-01-01天数,增加查询速度索引用 */
    @Excel(name = "排队日期标识，距2020-01-01天数,增加查询速度索引用")
    private Long queueTimeNum;

    /** 窗口号 */
    @Excel(name = "窗口号")
    private String windowNum;

    public void setUnid(String unid)
    {
        this.unid = unid;
    }

    public String getUnid()
    {
        return unid;
    }
    public void setQueueCode(String queueCode)
    {
        this.queueCode = queueCode;
    }

    public String getQueueCode()
    {
        return queueCode;
    }
    public void setQueueName(String queueName)
    {
        this.queueName = queueName;
    }

    public String getQueueName()
    {
        return queueName;
    }
    public void setMachineCode(String machineCode)
    {
        this.machineCode = machineCode;
    }

    public String getMachineCode()
    {
        return machineCode;
    }
    public void setSiteCode(String siteCode)
    {
        this.siteCode = siteCode;
    }

    public String getSiteCode()
    {
        return siteCode;
    }
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setTicketNumber(String ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber()
    {
        return ticketNumber;
    }
    public void setQueueTime(Date queueTime)
    {
        this.queueTime = queueTime;
    }

    public Date getQueueTime()
    {
        return queueTime;
    }
    public void setCalledTime(Date calledTime)
    {
        this.calledTime = calledTime;
    }

    public Date getCalledTime()
    {
        return calledTime;
    }
    public void setWaitSecondCount(Long waitSecondCount)
    {
        this.waitSecondCount = waitSecondCount;
    }

    public Long getWaitSecondCount()
    {
        return waitSecondCount;
    }
    public void setLeftTime(Date leftTime)
    {
        this.leftTime = leftTime;
    }

    public Date getLeftTime()
    {
        return leftTime;
    }
    public void setTicketChannel(String ticketChannel)
    {
        this.ticketChannel = ticketChannel;
    }

    public String getTicketChannel()
    {
        return ticketChannel;
    }
    public void setHandleSecondCount(Long handleSecondCount)
    {
        this.handleSecondCount = handleSecondCount;
    }

    public Long getHandleSecondCount()
    {
        return handleSecondCount;
    }
    public void setEvaluateStatus(Integer evaluateStatus)
    {
        this.evaluateStatus = evaluateStatus;
    }

    public Integer getEvaluateStatus()
    {
        return evaluateStatus;
    }
    public void setEvaluateTime(Date evaluateTime)
    {
        this.evaluateTime = evaluateTime;
    }

    public Date getEvaluateTime()
    {
        return evaluateTime;
    }
    public void setWindowCode(String windowCode)
    {
        this.windowCode = windowCode;
    }

    public String getWindowCode()
    {
        return windowCode;
    }
    public void setWindowName(String windowName)
    {
        this.windowName = windowName;
    }

    public String getWindowName()
    {
        return windowName;
    }
    public void setWindowEmpName(String windowEmpName)
    {
        this.windowEmpName = windowEmpName;
    }

    public String getWindowEmpName()
    {
        return windowEmpName;
    }
    public void setWindowEmpNum(String windowEmpNum)
    {
        this.windowEmpNum = windowEmpNum;
    }

    public String getWindowEmpNum()
    {
        return windowEmpNum;
    }
    public void setTicketStatus(Integer ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public Integer getTicketStatus()
    {
        return ticketStatus;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile;
    }

    public String getUserMobile()
    {
        return userMobile;
    }
    public void setUserCardNumber(String userCardNumber)
    {
        this.userCardNumber = userCardNumber;
    }

    public String getUserCardNumber()
    {
        return userCardNumber;
    }
    public void setAppointmentTime(Date appointmentTime)
    {
        this.appointmentTime = appointmentTime;
    }

    public Date getAppointmentTime()
    {
        return appointmentTime;
    }
    public void setUserAddress(String userAddress)
    {
        this.userAddress = userAddress;
    }

    public String getUserAddress()
    {
        return userAddress;
    }
    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }

    public String getUserSex()
    {
        return userSex;
    }
    public void setUserPhotoPath(String userPhotoPath)
    {
        this.userPhotoPath = userPhotoPath;
    }

    public String getUserPhotoPath()
    {
        return userPhotoPath;
    }
    public void setSynStatus(Integer synStatus)
    {
        this.synStatus = synStatus;
    }

    public Integer getSynStatus()
    {
        return synStatus;
    }
    public void setSynTime(Date synTime)
    {
        this.synTime = synTime;
    }

    public Date getSynTime()
    {
        return synTime;
    }
    public void setSynUnid(String synUnid)
    {
        this.synUnid = synUnid;
    }

    public String getSynUnid()
    {
        return synUnid;
    }
    public void setSynUrl(String synUrl)
    {
        this.synUrl = synUrl;
    }

    public String getSynUrl()
    {
        return synUrl;
    }
    public void setGuid(String guid)
    {
        this.guid = guid;
    }

    public String getGuid()
    {
        return guid;
    }
    public void setCalledStatus(Integer calledStatus)
    {
        this.calledStatus = calledStatus;
    }

    public Integer getCalledStatus()
    {
        return calledStatus;
    }
    public void setLeftStatus(Integer leftStatus)
    {
        this.leftStatus = leftStatus;
    }

    public Integer getLeftStatus()
    {
        return leftStatus;
    }
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setWindowEmpUnid(String windowEmpUnid)
    {
        this.windowEmpUnid = windowEmpUnid;
    }

    public String getWindowEmpUnid()
    {
        return windowEmpUnid;
    }
    public void setIsApp(Integer isApp)
    {
        this.isApp = isApp;
    }

    public Integer getIsApp()
    {
        return isApp;
    }
    public void setQueueTimeNum(Long queueTimeNum)
    {
        this.queueTimeNum = queueTimeNum;
    }

    public Long getQueueTimeNum()
    {
        return queueTimeNum;
    }
    public void setWindowNum(String windowNum)
    {
        this.windowNum = windowNum;
    }

    public String getWindowNum()
    {
        return windowNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unid", getUnid())
            .append("queueCode", getQueueCode())
            .append("queueName", getQueueName())
            .append("machineCode", getMachineCode())
            .append("siteCode", getSiteCode())
            .append("areaCode", getAreaCode())
            .append("ticketNumber", getTicketNumber())
            .append("queueTime", getQueueTime())
            .append("calledTime", getCalledTime())
            .append("waitSecondCount", getWaitSecondCount())
            .append("leftTime", getLeftTime())
            .append("ticketChannel", getTicketChannel())
            .append("handleSecondCount", getHandleSecondCount())
            .append("evaluateStatus", getEvaluateStatus())
            .append("evaluateTime", getEvaluateTime())
            .append("windowCode", getWindowCode())
            .append("windowName", getWindowName())
            .append("windowEmpName", getWindowEmpName())
            .append("windowEmpNum", getWindowEmpNum())
            .append("ticketStatus", getTicketStatus())
            .append("userName", getUserName())
            .append("userMobile", getUserMobile())
            .append("userCardNumber", getUserCardNumber())
            .append("appointmentTime", getAppointmentTime())
            .append("userAddress", getUserAddress())
            .append("userSex", getUserSex())
            .append("userPhotoPath", getUserPhotoPath())
            .append("synStatus", getSynStatus())
            .append("synTime", getSynTime())
            .append("synUnid", getSynUnid())
            .append("synUrl", getSynUrl())
            .append("guid", getGuid())
            .append("calledStatus", getCalledStatus())
            .append("leftStatus", getLeftStatus())
            .append("deptCode", getDeptCode())
            .append("deptName", getDeptName())
            .append("windowEmpUnid", getWindowEmpUnid())
            .append("isApp", getIsApp())
            .append("queueTimeNum", getQueueTimeNum())
            .append("windowNum", getWindowNum())
            .toString();
    }
}
