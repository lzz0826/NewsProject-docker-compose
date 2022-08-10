package tw.tony.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index1() {
		return "index";
	
	}
	
	@GetMapping("/login")
	public String lobin() {
		return "login";
	
	}
	

	@GetMapping("/news")
	public String news() {
		return "news";
	
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	
	}
	
	@GetMapping("/indexAdmin")
	public String indexAdmin() {
		return "indexAdmin";
	
	}

	
	@GetMapping("/newsAdmin")
	public String newsAdmin() {
		return "newsAdmin";
	
	}
	
	
	@GetMapping("/cretaeNews")
	public String cretaeNews() {
		return "cretaeNews";
	
	}
	
	
	
	

}
