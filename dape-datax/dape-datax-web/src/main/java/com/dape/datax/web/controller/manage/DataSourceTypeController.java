package com.dape.datax.web.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.dape.common.base.BaseController;
import com.dape.common.validator.LengthValidator;
import com.dape.datax.common.constant.DataxResult;
import com.dape.datax.common.constant.DataxResultConstant;
import com.dape.datax.dao.model.DataxSourceType;
import com.dape.datax.dao.model.DataxSourceTypeExample;
import com.dape.datax.rpc.api.DataxSourceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceTypeController.class);

    @Autowired
    private DataxSourceTypeService dataxSourceTypeService;

    @ApiOperation(value = "首页跳转")
    @RequiresPermissions("datax:sourceType:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/datasource/index.jsp";
    }

    @ApiOperation(value = "类型列表")
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



    @ApiOperation(value = "修改文章")
    @RequiresPermissions("datax:sourceType:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        DataxSourceTypeExample dataxSourceTypeExample = new DataxSourceTypeExample();
        dataxSourceTypeExample.setOrderByClause("ctime desc");
        //List<DataxSourceType> dataxSourceTypeList = dataxSourceTypeService.selectByExample(dataxSourceTypeExample);
        DataxSourceType dataxSourceType = dataxSourceTypeService.selectByPrimaryKey(id);
        //modelMap.put("cmsTopics", dataxSourceTypeList);
        modelMap.put("dataSourceType", dataxSourceType);
        return "/manage/datasource/update.jsp";
    }

    @ApiOperation(value="新增源类型弹出框")
    @RequiresPermissions("datax:sourceType:create")
    @RequestMapping(value="/create",method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        DataxSourceTypeExample dataxSourceTypeExample = new DataxSourceTypeExample();
        dataxSourceTypeExample.setOrderByClause("id desc");
        List<DataxSourceType> dataxSourceTypes = dataxSourceTypeService.selectByExample(dataxSourceTypeExample);
        modelMap.put("dataxSourceType", dataxSourceTypes);
        return "/manage/datasource/create.jsp";
    }

    @ApiOperation(value = "新增文章实际业务")
    @RequiresPermissions("datax:sourceType:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(DataxSourceType dataxSourceType) {
        ComplexResult result = FluentValidator.checkAll()
                .on(dataxSourceType.getDriverName(), new LengthValidator(1, 200, "标题"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new DataxResult(DataxResultConstant.FAILED.INVALID_LENGTH, result.getErrors());
        }
        long time = System.currentTimeMillis();
        dataxSourceType.setDriverName(dataxSourceType.getDriverName());
        dataxSourceType.setDriverStr(dataxSourceType.getDriverStr());

        int count = dataxSourceTypeService.insertSelective(dataxSourceType);

        return new DataxResult(DataxResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "修改源类型")
    @RequiresPermissions("datax:sourceType:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, DataxSourceType dataxSourceType) {
        ComplexResult result = FluentValidator.checkAll()
                .on(dataxSourceType.getDriverName(), new LengthValidator(1, 200, "标题"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new DataxResult(DataxResultConstant.INVALID_LENGTH, result.getErrors());
        }
        dataxSourceType.setId(id);
        int count = dataxSourceTypeService.updateByPrimaryKeySelective(dataxSourceType);
        return new DataxResult(DataxResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "删除文章")
    @RequiresPermissions("datax:sourceType:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = dataxSourceTypeService.deleteByPrimaryKeys(ids);
        return new DataxResult(DataxResultConstant.FAILED.SUCCESS, count);
    }



}
