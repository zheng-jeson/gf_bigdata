package com.ruoyi.project.business.machine.controller;

import java.util.List;

import com.ruoyi.project.business.hallSite.domain.HallSite;
import com.ruoyi.project.business.hallSite.service.IHallSiteService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.business.machine.domain.Machine;
import com.ruoyi.project.business.machine.service.IMachineService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 取号机Controller
 * 
 * @author jeson
 * @date 2022-05-30
 */
@Controller
@RequestMapping("/business/machine")
public class MachineController extends BaseController
{
    private String prefix = "business/machine";

    @Autowired
    private IMachineService machineService;
    @Autowired
    private IHallSiteService hallSiteService;

    @RequiresPermissions("business:machine:view")
    @GetMapping()
    public String machine()
    {
        return prefix + "/machine";
    }

    /**
     * 查询取号机列表
     */
    @RequiresPermissions("business:machine:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Machine machine)
    {
        startPage();
        List<Machine> list = machineService.selectMachineList(machine);
        return getDataTable(list);
    }

    /**
     * 导出取号机列表
     */
    @RequiresPermissions("business:machine:export")
    @Log(title = "取号机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Machine machine)
    {
        List<Machine> list = machineService.selectMachineList(machine);
        ExcelUtil<Machine> util = new ExcelUtil<Machine>(Machine.class);
        return util.exportExcel(list, "取号机数据");
    }

    /**
     * 新增取号机
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<HallSite> hallSites = hallSiteService.selectHallSiteList(null);
        mmap.put("hallSites", hallSites);
        return prefix + "/add";
    }

    /**
     * 新增保存取号机
     */
    @RequiresPermissions("business:machine:add")
    @Log(title = "取号机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Machine machine)
    {
        return toAjax(machineService.insertMachine(machine));
    }

    /**
     * 修改取号机
     */
    @RequiresPermissions("business:machine:edit")
    @GetMapping("/edit/{unid}")
    public String edit(@PathVariable("unid") String unid, ModelMap mmap)
    {
        List<HallSite> hallSites = hallSiteService.selectHallSiteList(null);
        Machine machine = machineService.selectMachineByUnid(unid);
        mmap.put("hallSites", hallSites);
        mmap.put("machine", machine);
        return prefix + "/edit";
    }

    /**
     * 修改保存取号机
     */
    @RequiresPermissions("business:machine:edit")
    @Log(title = "取号机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Machine machine)
    {
        return toAjax(machineService.updateMachine(machine));
    }

    /**
     * 删除取号机
     */
    @RequiresPermissions("business:machine:remove")
    @Log(title = "取号机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(machineService.deleteMachineByUnids(ids));
    }
}
