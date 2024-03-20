package com.WBH.dmWBH.controller;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

import com.WBH.dmWBH.mapper.dbo.accountMapper;
import com.WBH.dmWBH.mapper.dbo.giayMapper;
import com.WBH.dmWBH.mapper.dbo.sanphamMapper;
import com.WBH.dmWBH.model.account;
import com.WBH.dmWBH.model.giay;
import com.WBH.dmWBH.model.giayExample;
import com.WBH.dmWBH.model.sanpham;
import com.WBH.dmWBH.model.sanphamExample;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class homeController {

	@Autowired
	sanphamMapper sanphamMapper;
	@Autowired
	giayMapper giayMapper;
	@Autowired
	accountMapper accountMapper;

	@GetMapping("/back")
	public String back() {
		return "login";
	}

	@GetMapping("/login")
	public String login(account account) {
		return "login";
	}

	@GetMapping("/create")
	public String signup(account account) {
		return "signup";
	}

//	@GetMapping("/home")
//	public String home(Model model) {
//		sanphamExample example = new sanphamExample();
//		List<sanpham> sp = sanphamMapper.selectByExample(example);
//		model.addAttribute("sp", sp);
//		giayExample exampleG = new giayExample();
//		List<giay> g = giayMapper.selectByExample(exampleG);
//		model.addAttribute("g", g);
//		sanpham newsp = sanphamMapper.newsp(example);
//		model.addAttribute("newsp", newsp);
//		int pageSize = 3;
//		List<sanpham> ssp = sanphamMapper.getAll();
//		
//		if(ssp.size() % pageSize != 0) {
//			int sotrang = ssp.size()/pageSize + 1;
//		}else
//			int sotrang = ssp.size()/pageSize
//				
//		model.addAttribute("sotrang", sotrang);
//		return "home";
//	}

	@GetMapping("/home")
	public String getall(Model model, @RequestParam(name = "offset", defaultValue = "1") int offset,
			@RequestParam(defaultValue = "3") int pagesize) {
		sanphamExample example = new sanphamExample();
		giayExample exampleG = new giayExample();
		List<giay> g = giayMapper.selectByExample(exampleG);
		model.addAttribute("g", g);
		sanpham newsp = sanphamMapper.newsp(example);
		model.addAttribute("newsp", newsp);
		int page = (offset - 1) * pagesize;
		List<sanpham> sp = sanphamMapper.getSPbySize(page, pagesize);
		List<sanpham> ssp = sanphamMapper.getAll();
		int sotrang;
		if (ssp.size() % pagesize != 0) {
			sotrang = ssp.size() / pagesize + 1;
		} else
			sotrang = ssp.size() / pagesize;
		model.addAttribute("sp", sp);
		model.addAttribute("sotrang", sotrang);
		model.addAttribute("offset", offset);
		return "home";
	}

	@GetMapping("/Sp/{cid}")
	public String loadsptheoid(Model model, @PathVariable("cid") int cid) {
		List<sanpham> list = sanphamMapper.selectbycID(cid);
		model.addAttribute("sp", list);
		giayExample exampleG = new giayExample();
		List<giay> g = giayMapper.selectByExample(exampleG);
		model.addAttribute("g", g);
		sanphamExample example = new sanphamExample();
		sanpham newsp = sanphamMapper.newsp(example);
		model.addAttribute("newsp", newsp);
		model.addAttribute("tag", cid);
		return "a";
	}

	@GetMapping("/detal/{id}")
	public String chitiet(Model model, @PathVariable("id") int id) {
		sanpham ctsp = sanphamMapper.chitietSP(id);
		model.addAttribute("ctsp", ctsp);
		return "chitietSP";
	}

	@PostMapping("/home")
	public String search(@RequestParam("ten") String ten, Model model) {
		List<sanpham> listS = sanphamMapper.searchByName(ten);
		model.addAttribute("listS", listS);
		giayExample exampleG = new giayExample();
		List<giay> g = giayMapper.selectByExample(exampleG);
		model.addAttribute("g", g);
		sanphamExample example = new sanphamExample();
		sanpham newsp = sanphamMapper.newsp(example);
		model.addAttribute("newsp", newsp);
		model.addAttribute("ten", ten);
		return "search";
	}

	@PostMapping("/check")
	public String login(@Valid account account, BindingResult bindingResult, HttpSession session, Model model,
			@RequestParam("username") String username, @RequestParam("pass") String pass) {
		model.addAttribute("account", account);
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			account dangnhap = accountMapper.checklogin(username, pass);
			if (dangnhap != null) {
				session.setAttribute("acc", dangnhap);
				session.setAttribute("acc3", dangnhap.getIssell());
				session.setAttribute("acc1", dangnhap.getIsadmin());
				session.setAttribute("acc2", dangnhap.getUsername());
				session.setMaxInactiveInterval(5400);
				return "redirect:/home";
			} else
				model.addAttribute("mess", "sai tên đăng nhập hoặc mật khẩu");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("acc");
		session.removeAttribute("acc1");
		session.removeAttribute("acc2");
		return "redirect:/home";
	}

	@PostMapping("/signup")
	public String signup(@Valid account account, BindingResult bindingResult, Model model,
			@RequestParam("username") String username, @RequestParam("pass") String pass,
			@RequestParam("repass") String repass) {
		model.addAttribute("account", account);
//		if (bindingResult.hasErrors()) {		
//            return "signup"; 
//        }else {    	
//            return "redirect:/login";
//        }
		if (!pass.equals(repass)) {

			return "signup";
		} else if (bindingResult.hasErrors()) {
			return "signup";
		} else {
			account checkuser = accountMapper.checkuser(username);
			if (checkuser == null) {
				int dangky = accountMapper.dangky(username, pass, repass);
				return "login";
			}
		}
		return "signup";
	}

	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		account dangnhap = (account) session.getAttribute("acc");
		int manv = dangnhap.getAid();
		List<sanpham> list = sanphamMapper.selectbysellID(manv);
		model.addAttribute("list", list);
		giayExample exampleG = new giayExample();
		List<giay> g = giayMapper.selectByExample(exampleG);
		model.addAttribute("g", g);
		return "show";
	}

	@PostMapping("addSP")
	public String add(HttpSession session, Model model, @RequestParam("ten") String ten,
			@RequestParam("hinhanh") String hinhanh, @RequestParam("gia") int gia, @RequestParam("mota") String mota,
			@RequestParam("magiay") int magiay, @RequestParam("manv") int manv) {
		int add = sanphamMapper.insertSP(ten, hinhanh, gia, mota, magiay, manv);
		return "redirect:/show";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		int delete = sanphamMapper.deletebyID(id);
		return "redirect:/show";
	}

	@GetMapping("/edit/{id}")
	public String a(Model model, @PathVariable("id") int id) {
		sanpham sp = sanphamMapper.findById(id);
		model.addAttribute("sp", sp);
		giayExample exampleG = new giayExample();
		List<giay> g = giayMapper.selectByExample(exampleG);
		model.addAttribute("g", g);
		return "edit";
	}

	@PostMapping("/updateSp")
	public String update(Model model, @RequestParam("ten") String ten, @RequestParam("hinhanh") String hinhanh,
			@RequestParam("gia") int gia, @RequestParam("mota") String mota, @RequestParam("magiay") int magiay,
			@RequestParam("id") int id) {
		int up = sanphamMapper.updatebyID(ten, hinhanh, gia, mota, magiay, id);
		return "redirect:/show";
	}

	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}

}
