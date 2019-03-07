package com.dape.datax.web.controller.manage;

import com.dape.common.base.BaseController;
import com.dape.datax.common.constant.DataxResult;
import com.dape.datax.common.constant.DataxResultConstant;
import com.dape.datax.dao.model.DataxSourceType;
import com.dape.datax.dao.model.DataxSourceTypeExample;
import com.dape.datax.rpc.api.DataxSourceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value = "数据源类型", description = "数据源类型")
@RequestMapping("/manage/dataSourceType")
@Controller
public class DataSourceTypeController extends BaseController {


    @Autowired
    private DataxSourceTypeService dataxSourceTypeService;

    @ApiOperation(value = "首页跳转")
    @RequiresPermissions("datax:sourceType:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/datasource/index.jsp";
    }

    @ApiOperation(value = "用户列表")
    @RequiresPermissions("datax:sourceType:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        DataxSourceTypeExample dataxSourceTypeExample = new DataxSourceTypeExample();

        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            dataxSourceTypeExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
           // dataxSourceTypeExample.or().andDriverNameLike("%" + search + "%");
        }

        List<DataxSourceType> rows = dataxSourceTypeService.selectByExampleForOffsetPage(dataxSourceTypeExample, offset, limit);
        long total = dataxSourceTypeService.countByExample(dataxSourceTypeExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "删除文章")
    @RequiresPermissions("datax:sourceType:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = dataxSourceTypeService.deleteByPrimaryKeys(ids);
        return new DataxResult(DataxResultConstant.FAILED.SUCCESS, count);
    }

    @ApiOperation(value = "修改文章")
    @RequiresPermissions("datax:sourceType:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        DataxSourceTypeExample cmsTopicExample = new DataxSourceTypeExample();
        cmsTopicExample.setOrderByClause("ctime desc");
        List<DataxSourceType> cmsTopics = dataxSourceTypeService.selectByExample(cmsTopicExample);
        DataxSourceType article = dataxSourceTypeService.selectByPrimaryKey(id);
        modelMap.put("cmsTopics", cmsTopics);
        modelMap.put("article", article);
        return "/manage/article/update.jsp";
    }
}
