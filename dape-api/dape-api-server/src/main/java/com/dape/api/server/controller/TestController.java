package com.dape.api.server.controller;

import com.dape.api.rpc.api.ApiService;
import com.dape.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台controller
 * ncoffice on 2017/2/19.
 */
@Controller
@Api(value = "test", description = "test")
public class TestController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private ApiService apiService;

	@ApiOperation(value = "test")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(ModelMap modelMap) {
		return apiService.hello("world");
	}

}