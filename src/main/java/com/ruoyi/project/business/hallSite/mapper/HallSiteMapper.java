package com.ruoyi.project.business.hallSite.mapper;

import java.util.List;
import com.ruoyi.project.business.hallSite.domain.HallSite;

/**
 * 大厅网点Mapper接口
 * 
 * @author jeson
 * @date 2022-05-27
 */
public interface HallSiteMapper 
{
    /**
     * 查询大厅网点
     * 
     * @param unid 大厅网点主键
     * @return 大厅网点
     */
    public HallSite selectHallSiteByUnid(String unid);

    /**
     * 查询大厅网点列表
     * 
     * @param hallSite 大厅网点
     * @return 大厅网点集合
     */
    public List<HallSite> selectHallSiteList(HallSite hallSite);

    /**
     * 新增大厅网点
     * 
     * @param hallSite 大厅网点
     * @return 结果
     */
    public int insertHallSite(HallSite hallSite);

    /**
     * 修改大厅网点
     * 
     * @param hallSite 大厅网点
     * @return 结果
     */
    public int updateHallSite(HallSite hallSite);

    /**
     * 删除大厅网点
     * 
     * @param unid 大厅网点主键
     * @return 结果
     */
    public int deleteHallSiteByUnid(String unid);

    /**
     * 批量删除大厅网点
     * 
     * @param unids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHallSiteByUnids(String[] unids);
}
