package com.sarkariblackboard.Controller;

import java.util.List;

import com.sarkariblackboard.Entity.Product;
import com.sarkariblackboard.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	private static final String INTIALIZED=": process initialized";
	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		LOGGER.info("Home page called");
//		List<Product> listProducts = service.listAll();
//
//		model.addAttribute("listProducts", listProducts);

		return "dashboard";
	}

	@RequestMapping("/sample")
	public String viewSampleHomePageWithoutUI(Model model) {
		LOGGER.info("sample page called");
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);

		return "index";
	}

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		LOGGER.info("for new product"+INTIALIZED);
		Product product = new Product();
		model.addAttribute("product", product);

		return "new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		LOGGER.info("for save product"+INTIALIZED);
		service.save(product);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		LOGGER.info("for edit product"+INTIALIZED);
		ModelAndView mav = new ModelAndView("edit_product");

		Product product = service.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		LOGGER.info("for delete product"+INTIALIZED);
		service.delete(id);

		return "redirect:/";
	}
}
