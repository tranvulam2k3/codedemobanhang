package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.dbo.dangnhapMapper;
import com.example.demo.mapper.dbo.sanphamMapper;
import com.example.demo.model.dangnhap;
import com.example.demo.model.sanpham;
import com.example.demo.model.sanphamExample;

import jakarta.servlet.http.HttpSession;

@Controller
public class hemoPageController {


	@Autowired
	dangnhapMapper dangnhapMapper;

	@Autowired
	sanphamMapper sanphamMapper;



	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("checklogin")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		dangnhap dn = dangnhapMapper.checklogin(username, password);
		if (dn != null) {
			return "view";
		} else

			return "redirect:/login";
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

	@GetMapping("/showPage")
	public String show(Model model, @RequestParam("menu") String menu) {
		ModelAndView modelAndView = new ModelAndView("show");
		sanphamExample example = new sanphamExample();
		List<sanpham> sp = sanphamMapper.selectByExample(example);
		model.addAttribute("sp", sp);
		model.addAttribute("menu", menu );
		if("1".equals(menu)) {
			return "show";
		}
		if("20".equals(menu)) {
			return "1";
		}
		return "hello";
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
	@RequestMapping("/deleteSp/{id}/{value}")
    public String deleteUser(Model model, @PathVariable("id") int id , @PathVariable("value") String value) {		
		int count = sanphamMapper.deleteTenSp(id);				
		return "redirect:/showPage?menu=" + value ;
		 
    }

	
	@GetMapping("/updataSp/{id}")
	public String updata(Model model,@PathVariable("id") int id) {
		sanpham sp = sanphamMapper.findById(id);	
		model.addAttribute("sp", sp);
		return "updataSanPham";
	}
	@PostMapping("updataSp")
	public String updatasp(@RequestParam("tensanpham") String tensanpham , @RequestParam("gia") String gia,@RequestParam("mota") String mota,@RequestParam("id") int id) {
		int sp = sanphamMapper.upgia(tensanpham, gia, mota, id);
		return "view";
	}
}
