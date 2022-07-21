package com.ruoyi.project.business.machine.mapper;

import java.util.List;
import com.ruoyi.project.business.machine.domain.Machine;

/**
 * 取号机Mapper接口
 * 
 * @author jeson
 * @date 2022-05-30
 */
public interface MachineMapper 
{
    /**
     * 查询取号机
     * 
     * @param unid 取号机主键
     * @return 取号机
     */
    public Machine selectMachineByUnid(String unid);

    /**
     * 查询取号机列表
     * 
     * @param machine 取号机
     * @return 取号机集合
     */
    public List<Machine> selectMachineList(Machine machine);

    /**
     * 新增取号机
     * 
     * @param machine 取号机
     * @return 结果
     */
    public int insertMachine(Machine machine);

    /**
     * 修改取号机
     * 
     * @param machine 取号机
     * @return 结果
     */
    public int updateMachine(Machine machine);

    /**
     * 删除取号机
     * 
     * @param unid 取号机主键
     * @return 结果
     */
    public int deleteMachineByUnid(String unid);

    /**
     * 批量删除取号机
     * 
     * @param unids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMachineByUnids(String[] unids);
}
