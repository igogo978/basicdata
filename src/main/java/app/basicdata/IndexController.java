/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.basicdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author igogo
 */
@Controller
@EnableAutoConfiguration
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    AppProperties appProperties;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        logger.info("hello, logger");

        model.addAttribute("url", appProperties.getUrl());
        return "index";
    }

}
