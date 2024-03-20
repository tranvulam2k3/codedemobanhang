package com.webbh.dmBanhang.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbh.dmBanhang.Model.account;
import com.webbh.dmBanhang.Model.giay;
import com.webbh.dmBanhang.Model.giayExample;
import com.webbh.dmBanhang.Model.hoten;
import com.webbh.dmBanhang.Model.sanpham;
import com.webbh.dmBanhang.Model.sanphamExample;
import com.webbh.dmBanhang.mapper.dbo.accountMapper;
import com.webbh.dmBanhang.mapper.dbo.giayMapper;
import com.webbh.dmBanhang.mapper.dbo.hotenMapper;
import com.webbh.dmBanhang.mapper.dbo.sanphamMapper;

@Controller
public class homeController {
	
	@Autowired
	sanphamMapper sanphamMapper;
	
	@Autowired
	giayMapper giayMapper;
	
	@Autowired
	hotenMapper hotenMapper;
	
	@Autowired
	accountMapper accountMapper;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<sanpham> newsp = sanphamMapper.sanphammoi();
		sanphamExample example = new sanphamExample();
		List<sanpham> sp = sanphamMapper.selectByExample(example);
		model.addAttribute("newsp", newsp);
		model.addAttribute("sp", sp);
		return "home";
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		sanphamExample example1 = new sanphamExample();
		List<sanpham> sp = sanphamMapper.selectByExample(example1);
		giayExample example = new giayExample();
		List<giay> giay = giayMapper.selectByExample(example);
		model.addAttribute("giay", giay);
		model.addAttribute("sp", sp);
		return "category";
	}
	
	@GetMapping("/sanpham")
	public String sanphambyid(Model model, @RequestParam("magiay") String magiay) {
		if("1".equals(magiay)) {
			List<sanpham> sp = sanphamMapper.getsanphamByID(magiay);
			model.addAttribute("sp", sp);
			giayExample example = new giayExample();
			List<giay> giay = giayMapper.selectByExample(example);
			model.addAttribute("giay", giay);
			return "category";
		}else if("2".equals(magiay)) {	
			List<sanpham> sp = sanphamMapper.getsanphamByID(magiay);
			model.addAttribute("sp", sp);
			giayExample example = new giayExample();
			List<giay> giay = giayMapper.selectByExample(example);
			model.addAttribute("giay", giay);
			return "category";
		}else if("3".equals(magiay)) {
			List<sanpham> sp = sanphamMapper.getsanphamByID(magiay);
			model.addAttribute("sp", sp);
			giayExample example = new giayExample();
			List<giay> giay = giayMapper.selectByExample(example);
			model.addAttribute("giay", giay);
			return "category";		
		}
		return "b";
	}
	@GetMapping("/search")
	public String searchByName(Model model , @RequestParam("ten") String ten) {
		List<sanpham> searchName = sanphamMapper.search(ten);
		List<sanpham> newsp = sanphamMapper.sanphammoi();
		model.addAttribute("newsp", newsp);
		model.addAttribute("sp", searchName);
		return "home";
	}
//	@GetMapping("/detel/{id}")
//	public String productByID(Model model , @PathVariable("id") int id) {
//		sanpham spbyid = sanphamMapper.productByID(id);
//		model.addAttribute("spbyid", spbyid);
//		return "productDetel";
//	}
	@GetMapping("/a")
	public String a(Model model) {
		List<hoten> ht = hotenMapper.hovaten();
		List<String> hoTenList = new ArrayList<>();
		for (hoten hoten : ht) {
			hoTenList.add(hoten.getHo()+" "+hoten.getTen());
		}
		model.addAttribute("hoTenList", hoTenList);
		return "test";
	}
	@GetMapping("/{id}")
	public String productByID(Model model , @PathVariable("id") int id) {
		sanpham sp = sanphamMapper.productByID(id);
		model.addAttribute("sp", sp);
		return "productDetel";
	}
	// đăng nhập đăng kí
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/sigup")
	public String sigup() {
		return "sigup";
	}
	@PostMapping("/checklogin")
	public String checkLogin(Model model, @RequestParam("username") String username , @RequestParam("pass") String pass) {
		account dn = accountMapper.checkLogin(username, pass);
		if(dn != null) {
			return "redirect:/home";
		}else {
			model.addAttribute("mess", "Error User or Pass");
			return "login";
		}
	}
}
