package com.ruoyi.project.business.machine.service.impl;

import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.business.machine.mapper.MachineMapper;
import com.ruoyi.project.business.machine.domain.Machine;
import com.ruoyi.project.business.machine.service.IMachineService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 取号机Service业务层处理
 * 
 * @author jeson
 * @date 2022-05-30
 */
@Service
public class MachineServiceImpl implements IMachineService 
{
    @Autowired
    private MachineMapper machineMapper;

    /**
     * 查询取号机
     * 
     * @param unid 取号机主键
     * @return 取号机
     */
    @Override
    public Machine selectMachineByUnid(String unid)
    {
        return machineMapper.selectMachineByUnid(unid);
    }

    /**
     * 查询取号机列表
     * 
     * @param machine 取号机
     * @return 取号机
     */
    @Override
    public List<Machine> selectMachineList(Machine machine)
    {
        return machineMapper.selectMachineList(machine);
    }

    /**
     * 新增取号机
     * 
     * @param machine 取号机
     * @return 结果
     */
    @Override
    public int insertMachine(Machine machine)
    {
        if( StrUtil.isEmpty(machine.getUnid())){
            machine.setUnid(SnowflakeIdWorker.getUUID());
        }
        machine.setCreateTime(DateUtils.getNowDate());
        return machineMapper.insertMachine(machine);
    }

    /**
     * 修改取号机
     * 
     * @param machine 取号机
     * @return 结果
     */
    @Override
    public int updateMachine(Machine machine)
    {
        return machineMapper.updateMachine(machine);
    }

    /**
     * 批量删除取号机
     * 
     * @param unids 需要删除的取号机主键
     * @return 结果
     */
    @Override
    public int deleteMachineByUnids(String unids)
    {
        return machineMapper.deleteMachineByUnids(Convert.toStrArray(unids));
    }

    /**
     * 删除取号机信息
     * 
     * @param unid 取号机主键
     * @return 结果
     */
    @Override
    public int deleteMachineByUnid(String unid)
    {
        return machineMapper.deleteMachineByUnid(unid);
    }
}
