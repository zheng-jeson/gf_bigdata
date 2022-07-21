package com.ruoyi.project.business.machine.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 取号机对象 buss_machine
 * 
 * @author jeson
 * @date 2022-05-30
 */
public class Machine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String unid;

    /** 取号机名称 */
    @Excel(name = "取号机名称")
    private String machineName;

    /** 取号机唯一标识 */
    @Excel(name = "取号机唯一标识")
    private String machineCode;

    /** 网点标识 */
    @Excel(name = "网点标识")
    private String siteUnid;

    /** 网点名称 */
    @Excel(name = "网点名称")
    private String siteName;

    /** 网点编码 */
    @Excel(name = "网点编码")
    private String siteCode;

    /** 区划标识 */
    @Excel(name = "区划标识")
    private String areaCode;

    /** 所属楼层 */
    @Excel(name = "所属楼层")
    private Integer floorNumber;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productNumber;

    /** 机器投放使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "机器投放使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date placeDate;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactMan;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTel;

    /** 厂商 */
    @Excel(name = "厂商")
    private String company;

    /** mac地址 */
    @Excel(name = "mac地址")
    private String macAddress;

    /** 是否推送数据 */
    @Excel(name = "是否推送数据")
    private Integer isPush;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 机器类型；machine-取号机，window_machine-窗口终端，wait_screen-综合显示屏 */
    @Excel(name = "机器类型；machine-取号机，window_machine-窗口终端，wait_screen-综合显示屏")
    private String machineType;

    public void setUnid(String unid)
    {
        this.unid = unid;
    }

    public String getUnid()
    {
        return unid;
    }
    public void setMachineName(String machineName)
    {
        this.machineName = machineName;
    }

    public String getMachineName()
    {
        return machineName;
    }
    public void setMachineCode(String machineCode)
    {
        this.machineCode = machineCode;
    }

    public String getMachineCode()
    {
        return machineCode;
    }
    public void setSiteUnid(String siteUnid)
    {
        this.siteUnid = siteUnid;
    }

    public String getSiteUnid()
    {
        return siteUnid;
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
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
    public void setFloorNumber(Integer floorNumber)
    {
        this.floorNumber = floorNumber;
    }

    public Integer getFloorNumber()
    {
        return floorNumber;
    }
    public void setProductNumber(String productNumber)
    {
        this.productNumber = productNumber;
    }

    public String getProductNumber()
    {
        return productNumber;
    }
    public void setPlaceDate(Date placeDate)
    {
        this.placeDate = placeDate;
    }

    public Date getPlaceDate()
    {
        return placeDate;
    }
    public void setContactMan(String contactMan)
    {
        this.contactMan = contactMan;
    }

    public String getContactMan()
    {
        return contactMan;
    }
    public void setContactTel(String contactTel)
    {
        this.contactTel = contactTel;
    }

    public String getContactTel()
    {
        return contactTel;
    }
    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getCompany()
    {
        return company;
    }
    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getMacAddress()
    {
        return macAddress;
    }
    public void setIsPush(Integer isPush)
    {
        this.isPush = isPush;
    }

    public Integer getIsPush()
    {
        return isPush;
    }
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }
    public void setMachineType(String machineType)
    {
        this.machineType = machineType;
    }

    public String getMachineType()
    {
        return machineType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unid", getUnid())
            .append("machineName", getMachineName())
            .append("machineCode", getMachineCode())
            .append("siteUnid", getSiteUnid())
            .append("siteName", getSiteName())
            .append("siteCode", getSiteCode())
            .append("areaCode", getAreaCode())
            .append("floorNumber", getFloorNumber())
            .append("remark", getRemark())
            .append("productNumber", getProductNumber())
            .append("placeDate", getPlaceDate())
            .append("contactMan", getContactMan())
            .append("contactTel", getContactTel())
            .append("company", getCompany())
            .append("macAddress", getMacAddress())
            .append("isPush", getIsPush())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("machineType", getMachineType())
            .toString();
    }
}
