package com.ruoyi.project.business.queueTicketInfo.controller;

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
import com.ruoyi.project.business.queueTicketInfo.domain.QueueTicketInfo;
import com.ruoyi.project.business.queueTicketInfo.service.IQueueTicketInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 排队信息Controller
 * 
 * @author jeson
 * @date 2022-05-26
 */
@Controller
@RequestMapping("/business/queueTicketInfo")
public class QueueTicketInfoController extends BaseController
{
    private String prefix = "business/queueTicketInfo";

    @Autowired
    private IQueueTicketInfoService queueTicketInfoService;

    @RequiresPermissions("business:queueTicketInfo:view")
    @GetMapping()
    public String queueTicketInfo()
    {
        return prefix + "/queueTicketInfo";
    }

    /**
     * 查询排队信息列表
     */
    @RequiresPermissions("business:queueTicketInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QueueTicketInfo queueTicketInfo)
    {
        startPage();
        List<QueueTicketInfo> list = queueTicketInfoService.selectQueueTicketInfoList(queueTicketInfo);
        return getDataTable(list);
    }

    /**
     * 导出排队信息列表
     */
    @RequiresPermissions("business:queueTicketInfo:export")
    @Log(title = "排队信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QueueTicketInfo queueTicketInfo)
    {
        List<QueueTicketInfo> list = queueTicketInfoService.selectQueueTicketInfoList(queueTicketInfo);
        ExcelUtil<QueueTicketInfo> util = new ExcelUtil<QueueTicketInfo>(QueueTicketInfo.class);
        return util.exportExcel(list, "排队信息数据");
    }

    /**
     * 新增排队信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存排队信息
     */
    @RequiresPermissions("business:queueTicketInfo:add")
    @Log(title = "排队信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QueueTicketInfo queueTicketInfo)
    {
        return toAjax(queueTicketInfoService.insertQueueTicketInfo(queueTicketInfo));
    }

    /**
     * 修改排队信息
     */
    @RequiresPermissions("business:queueTicketInfo:edit")
    @GetMapping("/edit/{unid}")
    public String edit(@PathVariable("unid") String unid, ModelMap mmap)
    {
        QueueTicketInfo queueTicketInfo = queueTicketInfoService.selectQueueTicketInfoByUnid(unid);
        mmap.put("queueTicketInfo", queueTicketInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存排队信息
     */
    @RequiresPermissions("business:queueTicketInfo:edit")
    @Log(title = "排队信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QueueTicketInfo queueTicketInfo)
    {
        return toAjax(queueTicketInfoService.updateQueueTicketInfo(queueTicketInfo));
    }

    /**
     * 删除排队信息
     */
    @RequiresPermissions("business:queueTicketInfo:remove")
    @Log(title = "排队信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(queueTicketInfoService.deleteQueueTicketInfoByUnids(ids));
    }
}
