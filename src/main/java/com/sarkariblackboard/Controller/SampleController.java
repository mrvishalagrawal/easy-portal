package com.sarkariblackboard.Controller;

import com.sarkariblackboard.Entity.Product;
import com.sarkariblackboard.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SampleController {
    @Autowired
    private ProductService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
    private static final String INTIALIZED=": process initialized";

    @RequestMapping("/sample")
    public String viewSampleHomePageWithoutUI(Model model) {
        LOGGER.info("sample page called");
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }
}
