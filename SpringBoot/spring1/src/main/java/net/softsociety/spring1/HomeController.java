package net.softsociety.spring1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"", "/"})		// restapi get. 여러개일때 중괄호
	public String home() {
		return "index";			// return 파일명; resources/template/index.html;
	}
	
	@GetMapping("imgtest")
	public String imgTest() {
		System.out.println("test1() 실행");
		return "imgtest";
	}
	@GetMapping("jstest")
	public String jstest() {
		System.out.println("test2() 실행");
		return "jstest";
	}
}
                                                                       