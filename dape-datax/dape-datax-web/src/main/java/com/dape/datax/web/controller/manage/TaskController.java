package com.dape.datax.web.controller.manage;


import com.dape.common.base.BaseController;
import com.dape.datax.rpc.api.DataxSourceTypeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(value = "任务管理", description = "任务管理")
@RequestMapping("/manage/task")
@Controller
public class TaskController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired DataxSourceTypeService dataxSourceTypeService;


}
