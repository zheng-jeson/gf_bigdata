package com.ruoyi.web.vo;



import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 数据表 Entity
 *
 * @author Jeson
 * @date 2021-07-19 14:19:37
 */
@Data
@Accessors(chain = true)
public class Bigdata {



    /**
     * 网点编号
     */
    private String siteCode;

    /**
     * 网点名称
     */
    private String siteName;


    /**
     * 
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构别名
     */
    private String orgNickname;

    /**
     * 取号人数
     */
    private Integer fetchNum;

    /**
     * 办理人数
     */
    private Integer processNum;

    /**
     * 等待人数
     */
    private Integer waitNum;

    /**
     * 平均办理时间
     */
    private Integer avgProcessTime;

    /**
     * 平均等待时间
     */
    private Integer avgWaitTime;

    /**
     * 最大办理时间
     */
    private Integer maxProcessTime;

    /**
     * 最大等待时间
     */
    private Integer maxWaitTime;

    /**
     * 最小办理时间
     */
    private Integer minProcessTime;

    /**
     * 最小等待时间
     */
    private Integer minWaitTime;

    /**
     * 创建时间
     */
    private Date createTime;

}
