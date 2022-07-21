package com.ruoyi.project.business.hallSite.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 大厅网点对象 buss_hall_site
 * 
 * @author jeson
 * @date 2022-05-27
 */
public class HallSite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String unid;

    /** 大厅名称 */
    @Excel(name = "大厅名称")
    private String siteName;

    /** 网点标识 */
    @Excel(name = "网点标识")
    private String siteCode;

    /** 电话 */
    @Excel(name = "电话")
    private String sitePhone;

    /** 地址 */
    @Excel(name = "地址")
    private String siteAddress;

    /** 坐标Y */
    @Excel(name = "坐标Y")
    private String siteCoordinateY;

    /** 坐标X */
    @Excel(name = "坐标X")
    private String siteCoordinateX;

    /** 区划代码 */
    @Excel(name = "区划代码")
    private String areaCode;

    /** 是否发送短信提醒 */
    @Excel(name = "是否发送短信提醒")
    private Integer isSendMessage;

    /** 上班时间 */
    @Excel(name = "上班时间")
    private String siteAccepttime;

    /** 大厅简介 */
    @Excel(name = "大厅简介")
    private String siteIntroduction;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDel;

    /** 数据来源；custom-自定义，zs-正数，以此类推 */
    @Excel(name = "数据来源；custom-自定义，zs-正数，以此类推")
    private String sourceFlag;

    public void setUnid(String unid)
    {
        this.unid = unid;
    }

    public String getUnid()
    {
        return unid;
    }
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getSiteName()
    {
        return siteName;
    }
    public void setSiteCode(String siteCode)
    {
        this.siteCode = siteCode;
    }

    public String getSiteCode()
    {
        return siteCode;
    }
    public void setSitePhone(String sitePhone)
    {
        this.sitePhone = sitePhone;
    }

    public String getSitePhone()
    {
        return sitePhone;
    }
    public void setSiteAddress(String siteAddress)
    {
        this.siteAddress = siteAddress;
    }

    public String getSiteAddress()
    {
        return siteAddress;
    }
    public void setSiteCoordinateY(String siteCoordinateY)
    {
        this.siteCoordinateY = siteCoordinateY;
    }

    public String getSiteCoordinateY()
    {
        return siteCoordinateY;
    }
    public void setSiteCoordinateX(String siteCoordinateX)
    {
        this.siteCoordinateX = siteCoordinateX;
    }

    public String getSiteCoordinateX()
    {
        return siteCoordinateX;
    }
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setIsSendMessage(Integer isSendMessage)
    {
        this.isSendMessage = isSendMessage;
    }

    public Integer getIsSendMessage()
    {
        return isSendMessage;
    }
    public void setSiteAccepttime(String siteAccepttime)
    {
        this.siteAccepttime = siteAccepttime;
    }

    public String getSiteAccepttime()
    {
        return siteAccepttime;
    }
    public void setSiteIntroduction(String siteIntroduction)
    {
        this.siteIntroduction = siteIntroduction;
    }

    public String getSiteIntroduction()
    {
        return siteIntroduction;
    }
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }
    public void setIsDel(Integer isDel)
    {
        this.isDel = isDel;
    }

    public Integer getIsDel()
    {
        return isDel;
    }
    public void setSourceFlag(String sourceFlag)
    {
        this.sourceFlag = sourceFlag;
    }

    public String getSourceFlag()
    {
        return sourceFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unid", getUnid())
            .append("siteName", getSiteName())
            .append("siteCode", getSiteCode())
            .append("sitePhone", getSitePhone())
            .append("siteAddress", getSiteAddress())
            .append("siteCoordinateY", getSiteCoordinateY())
            .append("siteCoordinateX", getSiteCoordinateX())
            .append("areaCode", getAreaCode())
            .append("isSendMessage", getIsSendMessage())
            .append("remark", getRemark())
            .append("siteAccepttime", getSiteAccepttime())
            .append("siteIntroduction", getSiteIntroduction())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("isDel", getIsDel())
            .append("sourceFlag", getSourceFlag())
            .toString();
    }
}
