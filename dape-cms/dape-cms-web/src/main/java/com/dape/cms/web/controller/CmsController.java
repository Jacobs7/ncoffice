package com.dape.cms.web.controller;

import com.dape.cms.dao.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.dape.common.base.BaseController.thymeleaf;

@Controller
@RequestMapping(value = "/cms")
public class CmsController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {


        return thymeleaf("/user/login");
    }

    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String reg(Model model) {


        return thymeleaf("/user/reg");
    }
}
