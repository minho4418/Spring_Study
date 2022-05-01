package com.spring.my;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.my.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//forward방식으로 view에 데이터 전달
		model.addAttribute("serverTime", formattedDate );
		// servlet-content.xml의
		// prefix : /WEB-INF/views/ 생략
		// suffix : .jsp 생략
		// home.jsp로 forward 방식으로 이동
		//return "forward:/WEB-INF/views/home.jsp";
		return "home";
	}
	// method 생략 : 모든 method 허용
	//매핑정보만 필요시 value기본
	@RequestMapping("m20220427_01")
	public String m20220427_01(Model model) {
		model.addAttribute("msg" , "hello");
		model.addAttribute("name", "박자바");
		return "20220427_01";
	}
	//리턴값이 void
	@RequestMapping("20220427_02")
	public void m20220427_02(Model model) {	
		//매핑정보와 return값이 같다면 return을 생략할수 있다
		model.addAttribute("msg","매핑정보와 return값이 같다면 return을 생략할수 있다");
	}
	@RequestMapping("m20220427_03")
	public String m20220427_03() {
		return "20220427_03";
	}
	
	//이름이 동일할경우 생략 : @RequestParam("userid") String userid
	//@RequestParam 생략가능 하나 명시해주는것이 오타를 막을수 있다
	@RequestMapping("m20220427_03_param")
	public String m20220427_03_param(
			// String userid, string passwd 만 써도 되는데
			// requestparam안쓰면 변수가 오타가 나면 에러안나고 null
			@RequestParam("userid") String userid,
			@RequestParam("passwd") String passwd,
			Model model) {
		
		logger.info("userid : " + userid);
		logger.info("passwd : " + passwd);
		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		
		return "20220427_03";
	}
	
		//매핑정보는 유일해야 한다.단 메소드가 다를경우는 가능
		//20220427_04_area로 이동
		@RequestMapping(value="m20220427_04", method = RequestMethod.GET)
		public String m20220427_04() {
			return "20220427_04_area";
		}
		
		//defaultValue = "0" : 값이 공백일경우 0으로 대체
		@RequestMapping(value = "m20220427_04", method = RequestMethod.POST)
		public String m20220427_04(@RequestParam(defaultValue = "0") int radius, Model model) {
			logger.info("radius:" + radius);
			double area = radius * radius * Math.PI;
			logger.info("area:" + area);
			//view로 전달
			model.addAttribute("area", area);
			
			return "20220427_04_area";
		}
		
		//회원가입 jsp 이동
		@RequestMapping(value = "m20220427_05", method= RequestMethod.GET)
		public String m20220427_05() {
			return "20220427_05_join";
		}
		
		//회원가입버튼 클릭시
		//@ModelAttribute : view까지 데이터 전달
		//memInfo(전달변수명)은 생략하면 변수명(member)으로 전달
		@RequestMapping(value="m20220427_05", method = RequestMethod.POST)
		public String m20220427_05(@ModelAttribute("memInfo") Member member) {
			logger.info(member.toString());
			return "20220427_05_join";
		}
	
}
