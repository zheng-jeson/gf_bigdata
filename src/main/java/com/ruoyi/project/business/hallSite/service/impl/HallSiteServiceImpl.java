package com.ruoyi.project.business.hallSite.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.constant.UrlConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.hallSite.mapper.HallSiteMapper;
import com.ruoyi.project.business.hallSite.domain.HallSite;
import com.ruoyi.project.business.hallSite.service.IHallSiteService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 大厅网点Service业务层处理
 * 
 * @author jeson
 * @date 2022-05-27
 */
@Service
public class HallSiteServiceImpl implements IHallSiteService 
{
    @Autowired
    private HallSiteMapper hallSiteMapper;

    /**
     * 查询大厅网点
     * 
     * @param unid 大厅网点主键
     * @return 大厅网点
     */
    @Override
    public HallSite selectHallSiteByUnid(String unid)
    {
        return hallSiteMapper.selectHallSiteByUnid(unid);
    }

    /**
     * 查询大厅网点列表
     * 
     * @param hallSite 大厅网点
     * @return 大厅网点
     */
    @Override
    public List<HallSite> selectHallSiteList(HallSite hallSite)
    {
        return hallSiteMapper.selectHallSiteList(hallSite);
    }

    /**
     * 新增大厅网点
     * 
     * @param hallSite 大厅网点
     * @return 结果
     */
    @Override
    public int insertHallSite(HallSite hallSite)
    {
        if(StrUtil.isEmpty(hallSite.getUnid())){
            hallSite.setUnid(SnowflakeIdWorker.getUUID());
        }
        hallSite.setCreateTime(DateUtils.getNowDate());
        return hallSiteMapper.insertHallSite(hallSite);
    }

    /**
     * 修改大厅网点
     * 
     * @param hallSite 大厅网点
     * @return 结果
     */
    @Override
    public int updateHallSite(HallSite hallSite)
    {
        return hallSiteMapper.updateHallSite(hallSite);
    }

    /**
     * 批量删除大厅网点
     * 
     * @param unids 需要删除的大厅网点主键
     * @return 结果
     */
    @Override
    public int deleteHallSiteByUnids(String unids)
    {
        return hallSiteMapper.deleteHallSiteByUnids(Convert.toStrArray(unids));
    }

    /**
     * 删除大厅网点信息
     * 
     * @param unid 大厅网点主键
     * @return 结果
     */
    @Override
    public int deleteHallSiteByUnid(String unid)
    {
        return hallSiteMapper.deleteHallSiteByUnid(unid);
    }

    /**
     * 从排队系统导入网点信息
     * @author Zhenghaojie
     * @date 2022/5/31 11:05
     * @return int
     */
    @Override
    public int importHallSite() {
        int i = 0;
        //调用接口获取数据
        String url = UrlConstants.QUEUETICKET_URL+"getHallSiteList";
        String result = "";
        //调用接口
        try {
            result = HttpUtil.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if(jsonObject!=null && CollUtil.isNotEmpty(jsonObject.getJSONArray("data"))) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (Object o : jsonArray) {
                JSONObject json = JSONUtil.parseObj(o);
                HallSite hallSite = new HallSite();

                hallSite.setUnid(json.getStr("unid"));
                hallSite.setSiteName(json.getStr("unid"));
                hallSite.setSiteCode(json.getStr("unid"));
                hallSite.setAreaCode(json.getStr("unid"));
                hallSite.setSiteAddress(json.getStr("unid"));
                hallSite.setSiteCoordinateX(json.getStr("unid"));
                hallSite.setSiteCoordinateY(json.getStr("unid"));
                hallSite.setSiteAccepttime(json.getStr("unid"));
                hallSite.setSitePhone(json.getStr("unid"));
                hallSite.setIsDel(0);
                hallSite.setSiteIntroduction(json.getStr("unid"));
                //根据id判断数据库是否存在
                if (this.selectHallSiteByUnid(json.getStr("unid")) != null) {
                    i += this.updateHallSite(hallSite);
                } else {
                    i += this.insertHallSite(hallSite);
                }
            }
        }
        return i;
    }
}
