package com.dape.datax.web.controller.manage;


import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.dape.common.base.BaseController;
import com.dape.common.validator.LengthValidator;
import com.dape.datax.common.constant.DataxResult;
import com.dape.datax.common.constant.DataxResultConstant;
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
import com.dape.datax.dao.model.*;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "数据源类型管理", description = "数据源类型管理")
@RequestMapping("/manage/dataSource")
@Controller
public class DataSourceController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    private DataxSourceTypeService dataxSourceTypeService;


    @ApiOperation(value = "数据源管理首页")
    @RequiresPermissions("datax:dataSource:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/dataSource/index.jsp";
    }

    @ApiOperation(value = "数据源管理列表")
    @RequiresPermissions("datax:dataSource:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {


            DataxSourceTypeExample dataxSourceTypeExample = new DataxSourceTypeExample();
           if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
               dataxSourceTypeExample.setOrderByClause(sort + " " + order);
          }
          List<DataxSourceType> rows = dataxSourceTypeService.selectByExampleForOffsetPage(dataxSourceTypeExample, offset, limit);
          long total = dataxSourceTypeService.countByExample(dataxSourceTypeExample);
        Map<String, Object> result = new HashMap(2);
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增数据源类型")
    @RequiresPermissions("datax:dataSrouce:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        DataxSourceTypeExample cmsTopicExample = new DataxSourceTypeExample();
        cmsTopicExample.setOrderByClause("ctime desc");
        List<DataxSourceType> dataxSourceTypes = dataxSourceTypeService.selectByExample(cmsTopicExample);
        modelMap.put("dataxSourceTypes", dataxSourceTypes);
        return "/manage/dataSource/create.jsp";
    }

    @ApiOperation(value = "新增文章")
    @RequiresPermissions("datax:dataSource:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(DataxSourceType dataxSourceType) {
        ComplexResult result = FluentValidator.checkAll()
                .on(dataxSourceType.getStr(), new LengthValidator(1, 200, "标题"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!result.isSuccess()) {
            return new DataxResult(DataxResultConstant.FAILED.INVALID_LENGTH, result.getErrors());
        }
        long time = System.currentTimeMillis();
        dataxSourceType.setTname(dataxSourceType.getStr());
        dataxSourceType.setStr(dataxSourceType.getStr());
        dataxSourceType.setId(dataxSourceType.getId());

        int count = dataxSourceTypeService.insertSelective(dataxSourceType);


        return new DataxResult(DataxResultConstant.SUCCESS, count);
    }

//    @ApiOperation(value = "删除文章")
//    @RequiresPermissions("cms:article:delete")
//    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
//    @ResponseBody
//    public Object delete(@PathVariable("ids") String ids) {
//        int count = cmsArticleService.deleteByPrimaryKeys(ids);
//        return new CmsResult(CmsResultConstant.SUCCESS, count);
//    }
//
//    @ApiOperation(value = "修改文章")
//    @RequiresPermissions("cms:article:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String update(@PathVariable("id") int id, ModelMap modelMap) {
//        CmsTopicExample cmsTopicExample = new CmsTopicExample();
//        cmsTopicExample.setOrderByClause("ctime desc");
//        List<CmsTopic> cmsTopics = cmsTopicService.selectByExample(cmsTopicExample);
//        CmsArticle article = cmsArticleService.selectByPrimaryKey(id);
//        modelMap.put("cmsTopics", cmsTopics);
//        modelMap.put("article", article);
//        return "/manage/article/update.jsp";
//    }
//
//    @ApiOperation(value = "修改文章")
//    @RequiresPermissions("cms:article:update")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public Object update(@PathVariable("id") int id, CmsArticle cmsArticle) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(cmsArticle.getTitle(), new LengthValidator(1, 200, "标题"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new CmsResult(CmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }
//        cmsArticle.setArticleId(id);
//        int count = cmsArticleService.updateByPrimaryKeySelective(cmsArticle);
//        return new CmsResult(CmsResultConstant.SUCCESS, count);
//    }

}
