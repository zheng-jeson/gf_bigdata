package com.ruoyi.project.business.hallSite.controller;

import java.util.List;
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
import com.ruoyi.project.business.hallSite.domain.HallSite;
import com.ruoyi.project.business.hallSite.service.IHallSiteService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 大厅网点Controller
 * 
 * @author jeson
 * @date 2022-05-27
 */
@Controller
@RequestMapping("/business/hallSite")
public class HallSiteController extends BaseController
{
    private String prefix = "business/hallSite";

    @Autowired
    private IHallSiteService hallSiteService;

    @RequiresPermissions("business:hallSite:view")
    @GetMapping()
    public String hallSite()
    {
        return prefix + "/hallSite";
    }

    /**
     * 查询大厅网点列表
     */
    @RequiresPermissions("business:hallSite:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HallSite hallSite)
    {
        startPage();
        List<HallSite> list = hallSiteService.selectHallSiteList(hallSite);
        return getDataTable(list);
    }

    /**
     * 从排队系统导入网点信息
     */
    @RequiresPermissions("business:hallSite:import")
    @PostMapping("/importHallSite")
    @ResponseBody
    public  AjaxResult importHallSite(){
         int i = hallSiteService.importHallSite();
         return toAjax(i);
    }



    /**
     * 导出大厅网点列表
     */
    @RequiresPermissions("business:hallSite:export")
    @Log(title = "大厅网点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HallSite hallSite)
    {
        List<HallSite> list = hallSiteService.selectHallSiteList(hallSite);
        ExcelUtil<HallSite> util = new ExcelUtil<HallSite>(HallSite.class);
        return util.exportExcel(list, "大厅网点数据");
    }

    /**
     * 新增大厅网点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存大厅网点
     */
    @RequiresPermissions("business:hallSite:add")
    @Log(title = "大厅网点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HallSite hallSite)
    {
        return toAjax(hallSiteService.insertHallSite(hallSite));
    }

    /**
     * 修改大厅网点
     */
    @RequiresPermissions("business:hallSite:edit")
    @GetMapping("/edit/{unid}")
    public String edit(@PathVariable("unid") String unid, ModelMap mmap)
    {
        HallSite hallSite = hallSiteService.selectHallSiteByUnid(unid);
        mmap.put("hallSite", hallSite);
        return prefix + "/edit";
    }

    /**
     * 修改保存大厅网点
     */
    @RequiresPermissions("business:hallSite:edit")
    @Log(title = "大厅网点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HallSite hallSite)
    {
        return toAjax(hallSiteService.updateHallSite(hallSite));
    }

    /**
     * 删除大厅网点
     */
    @RequiresPermissions("business:hallSite:remove")
    @Log(title = "大厅网点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hallSiteService.deleteHallSiteByUnids(ids));
    }
}
