package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/*
 * Add annotations here
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
	
 	private final JdbcTemplate jdbcTemplate;

 	//Add an annotation here
	@Autowired
 	public SampleController(JdbcTemplate jdbcTemplate) {
 		this.jdbcTemplate = jdbcTemplate;
 	}
	
	@GetMapping("/test")
	public String test(Model model) {

		String sql = "SELECT id, name, email FROM inquiry WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);

		String sql2 = "SELECT id, name, email FROM inquiry WHERE id = 2";
		Map<String, Object> map2 = jdbcTemplate.queryForMap(sql2);

		model.addAttribute("title", "Inquiry Form");
		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));

		model.addAttribute("name2", map2.get("name"));
		model.addAttribute("email2", map2.get("email"));
		return "test";
	}
}
