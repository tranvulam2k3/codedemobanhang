package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.dbo.dangnhapMapper;
import com.example.demo.mapper.dbo.hanghoaMapper;
import com.example.demo.mapper.dbo.sanphamMapper;
import com.example.demo.model.dangnhap;
import com.example.demo.model.hanghoa;
import com.example.demo.model.hanghoaExample;
import com.example.demo.model.sanpham;
import com.example.demo.model.sanphamExample;

@Controller
public class hemoPageController {
	@Autowired
	hanghoaMapper hanghoa;

	@Autowired
	dangnhapMapper dangnhapMapper;

	@Autowired
	sanphamMapper sanphamMapper;

	@GetMapping("/")
	public ModelAndView hellopage() {
		ModelAndView modelAndView = new ModelAndView("login.html");
		hanghoaExample example = new hanghoaExample();
		List<hanghoa> hh = hanghoa.selectByExample(example);
		for (hanghoa value : hh) {
			System.out.println("mat hang: " + value.getTenhang());
		}

		return modelAndView;
	}

	@GetMapping("/update")
	public ModelAndView update(Model model) {
		ModelAndView modelAndView = new ModelAndView("index");
		int hh1 = hanghoa.updateByExample("iphone 15 pro max", "iphone");
		hanghoaExample example = new hanghoaExample();
		List<hanghoa> hh = hanghoa.selectByExample(example);
		for (hanghoa value : hh) {
			System.out.println("mat hang: " + value.getTenhang());
		}
		// set hh == hh trong ""
		model.addAttribute("hh", hh.get(0));
		model.addAttribute("hh", hh.get(0));

		return modelAndView;
	}

	@GetMapping("/insert")
	public ModelAndView insert() {
		ModelAndView modelAndView = new ModelAndView("index");
		int hh2 = hanghoa.insert("nokia", 3);
		hanghoaExample example = new hanghoaExample();
		List<hanghoa> hh = hanghoa.selectByExample(example);
		for (hanghoa value : hh) {
			System.out.println("mat hang: " + value.getTenhang());
		}
		return modelAndView;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("checklogin")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		dangnhap dn = dangnhapMapper.checklogin(username, password);
		String message = "loi ten dang nhap hoac mat khau";
		if (dn != null) {
			return "view";
		} else

			return "redirect:/login";
	}

//	@PostMapping("quenmk")
//	public String quenmk() {
//	//	dangnhap dn = dangnhapMapper.doipass(username, newpassword);
//		return "resetpass";
//	}
	@PostMapping("doimk")
	public String doimk() {
		// dangnhap dn = dangnhapMapper.doipass(username, newpassword);
		return "doipass";
	}

	@PostMapping("login")
	public String checkpass(@RequestParam("newpassword") String newpassword,@RequestParam("password") String password) {
		int dn = dangnhapMapper.doipass(newpassword, password);
		return "login";
	}
//dang ky====================================================
	@GetMapping("create")
	public String create() {
		return "signup";
	}
	@GetMapping("back")
	public String back() {
		return "login";
	}
	@GetMapping("backadd")
	public String backadd() {
		return "view";
	}
	@GetMapping("backup")
	public String backup() {
		return "view";
	}
	@PostMapping("signup")
	public String sighup(@RequestParam("username") String username, @RequestParam("password") String password) {
		int dn = dangnhapMapper.signup(username, password);
		return "login";
	}
//=============================================================
//them sp=======================================
//	@GetMapping("/home")
//	public String home() {
//		return "addSP";
//	}
//	@PostMapping("addSP")
//	public String addSP(@RequestParam("tensanpham") String tensanpham, @RequestParam("gia") String gia,
//			@RequestParam("mota") String mota) {
//		int sp = sanphamMapper.addSP(tensanpham, gia, mota);
//		return "view";
//	}
//================================================
	@PostMapping("/showPage")
	public String show(Model model, @RequestParam("lam") String username) {
		ModelAndView modelAndView = new ModelAndView("show");
		sanphamExample example = new sanphamExample();
		List<sanpham> sp = sanphamMapper.selectByExample(example);
		model.addAttribute("sp", sp);
		if("1".equals(username)) {
			return "show";
		}
		return "1";
	}
	
	@GetMapping("add")
	public String add() {
		return "addSP";
	}
	@PostMapping("addSP")
	public String addSP(@RequestParam("tensanpham") String tensanpham, @RequestParam("gia") String gia,
			@RequestParam("mota") String mota) {
		int sp = sanphamMapper.addSP(tensanpham, gia, mota);
		return "view";
	}
	@GetMapping("delete")
	public String delete(@RequestParam("tensanpham") String tensanpham) {
		if("tensanpham".equals(tensanpham)) {
		int sp = sanphamMapper.delete(tensanpham);
		}
		return "show";
	}
	
	@GetMapping("updata")
	public String updata() {
		return "updata";
	}
	@PostMapping("updataSP")
	public String updatasp(@RequestParam("giamoi") String giamoi,@RequestParam("tensanpham") String tensanpham) {
		int sp = sanphamMapper.upgia(giamoi, tensanpham);
		return "view";
	}
}
