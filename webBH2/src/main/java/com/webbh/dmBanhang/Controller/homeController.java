package com.webbh.dmBanhang.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.webbh.dmBanhang.Model.account;
import com.webbh.dmBanhang.Model.cartExample;
import com.webbh.dmBanhang.Model.giay;
import com.webbh.dmBanhang.Model.giayExample;
import com.webbh.dmBanhang.Model.hoten;
import com.webbh.dmBanhang.Model.ngaythang;
import com.webbh.dmBanhang.Model.sanpham;
import com.webbh.dmBanhang.Model.sanphamExample;
import com.webbh.dmBanhang.Model.sdt;
import com.webbh.dmBanhang.mapper.dbo.accountMapper;
import com.webbh.dmBanhang.mapper.dbo.cartMapper;
import com.webbh.dmBanhang.mapper.dbo.giayMapper;
import com.webbh.dmBanhang.mapper.dbo.hotenMapper;
import com.webbh.dmBanhang.mapper.dbo.ngaythangMapper;
import com.webbh.dmBanhang.mapper.dbo.sanphamMapper;
import com.webbh.dmBanhang.mapper.dbo.sdtMapper;
import com.webbh.dmBanhang.Model.cart;

import jakarta.validation.Valid;

@Controller
public class homeController {

	@Autowired
	sanphamMapper sanphamMapper;

	@Autowired
	giayMapper giayMapper;

	@Autowired
	hotenMapper hotenMapper;

	@Autowired
	sdtMapper sdtMapper;

	@Autowired
	accountMapper accountMapper;

	@Autowired
	ngaythangMapper ngaythangMapper;

	@Autowired
	cartMapper cartMapper;

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
		if ("1".equals(magiay)) {
			List<sanpham> sp = sanphamMapper.getsanphamByID(magiay);
			model.addAttribute("sp", sp);
			giayExample example = new giayExample();
			List<giay> giay = giayMapper.selectByExample(example);
			model.addAttribute("giay", giay);
			return "category";
		} else if ("2".equals(magiay)) {
			List<sanpham> sp = sanphamMapper.getsanphamByID(magiay);
			model.addAttribute("sp", sp);
			giayExample example = new giayExample();
			List<giay> giay = giayMapper.selectByExample(example);
			model.addAttribute("giay", giay);
			return "category";
		} else if ("3".equals(magiay)) {
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
	public String searchByName(Model model, @RequestParam("ten") String ten) {
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
		List<sdt> sdt = sdtMapper.getSDT();
		List<String> sdtList = new ArrayList<>();
		List<String> hoTenList = new ArrayList<>();
		for (hoten hoten : ht) {
			hoTenList.add(hoten.getHo() + " " + hoten.getTen());
		}
		for (sdt a : sdt) {
			sdtList.add(a.getSodau() + "-" + a.getSogiua() + "-" + a.getSocuoi());
		}
		model.addAttribute("hoTenList", hoTenList);
		model.addAttribute("sdtList", sdtList);
		return "test";
	}

	@GetMapping("/{id}")
	public String productByID(Model model, @PathVariable("id") int id) {
		sanpham sp = sanphamMapper.productByID(id);
		model.addAttribute("sp", sp);
		return "productDetel";
	}

	// đăng nhập đăng kí
	@GetMapping("/login")
	public String login(account account) {
		return "login";
	}

	@GetMapping("/signup")
	public String sigup(account account) {
		return "signup";
	}

//	@PostMapping("/checklogin")
//	public String checkLogin(@Validated account account, BindingResult bindingResult,
//			Model model, @RequestParam("username") String username , @RequestParam("pass") String pass) {
//		model.addAttribute("account", account );
//		if(bindingResult.hasErrors()) {
//				return "login";
//		}else {
//			account dn = accountMapper.checkLogin(username, pass);
//			if(dn != null) {
//				return "redirect:/home";
//			}else {
//				model.addAttribute("mess", "Error User or Pass");
//				return "login";
//			}
//		}
//	}
	@PostMapping("/checklogin")
	public String checkSigup(@Validated account account, BindingResult bindingResult, Model model,
			@RequestParam("username") String username, @RequestParam("pass") String pass) {
		model.addAttribute("account", account);
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			account dn = accountMapper.checkLogin(username, pass);
			if (dn != null) {
				return "redirect:/home";
			} else {
				model.addAttribute("mess", "Error User or Pass");
				return "login";
			}
		}
	}

	@PostMapping("/signup")
	public String checkSigup(@Validated account account, BindingResult bindingResult, Model model,
			@RequestParam("username") String username, @RequestParam("pass") String pass,
			@RequestParam("repass") String repass, @RequestParam("email") String email) {
		model.addAttribute("account", account);
		if (bindingResult.hasErrors()) {
			return "signup";
		} else {
			if (pass.equals(repass) == false) {
				return "signup";
			} else {
				account checkuser = accountMapper.checkuser(username);
				if (checkuser == null) {
					int sigup = accountMapper.signup(username, pass, repass, email);
					return "login";
				}
			}
			return "signup";
		}
	}

	// Thêm, Sửa , Xóa
	@GetMapping("/crud")
	public String crud(Model model, @RequestParam(name = "offset", defaultValue = "1") int offset,
			@RequestParam(name = "pagesize", defaultValue = "5") int pagesize) {
		int page = (offset - 1) * pagesize;
		List<sanpham> sp = sanphamMapper.phantrang(page, pagesize);
		List<sanpham> getAll = sanphamMapper.getAll();
		int sotrang;
		if (getAll.size() % pagesize != 0) {
			sotrang = getAll.size() / pagesize + 1;
		} else {
			sotrang = getAll.size() / pagesize;
		}
		model.addAttribute("sp", sp);
		model.addAttribute("sotrang", sotrang);
		model.addAttribute("offset", offset);
		giayExample example2 = new giayExample();
		List<giay> giay = giayMapper.selectByExample(example2);
		model.addAttribute("giay", giay);
		return "crud";
	}

	@PostMapping("/addSP")
	public String addSP(Model model, @RequestParam("ten") String ten, @RequestParam("hinhanh") String hinhanh,
			@RequestParam("gia") int gia, @RequestParam("mota") String mota, @RequestParam("magiay") int magiay) {
		int addsp = sanphamMapper.addsp(ten, hinhanh, gia, mota, magiay);
		return "redirect:/crud";
	}

	@GetMapping("/edit/{id}")
	public String editbyID(Model model, @PathVariable("id") int id) {
		sanpham findbyid = sanphamMapper.productByID(id);
		giayExample example2 = new giayExample();
		List<giay> giay = giayMapper.selectByExample(example2);
		model.addAttribute("findbyid", findbyid);
		model.addAttribute("giay", giay);
		return "edit";
	}

	@PostMapping("/updateSp")
	public String updatesp(Model model, @RequestParam("ten") String ten, @RequestParam("hinhanh") String hinhanh,
			@RequestParam("gia") int gia, @RequestParam("mota") String mota, @RequestParam("magiay") int magiay,
			@RequestParam("id") int id) {
		int update = sanphamMapper.updatebyID(ten, hinhanh, gia, mota, magiay, id);
		return "redirect:/crud";
	}

	@RequestMapping("/delete/{id}")
	public String deletebyID(Model model, @PathVariable("id") int id) {
		int deletesp = sanphamMapper.deletebyID(id);
		return "redirect:/crud";
	}

	// gio hang
	@RequestMapping("/addcartsp/{id}")
	public String addtocart(Model model, @PathVariable("id") int id) {
		int addtocart = cartMapper.addtocart(id);
		return "redirect:/{id}";
	}

	@GetMapping("/cart")
	public String cart(Model model) {
		cartExample cartExample = new cartExample();
		List<cart> sp = cartMapper.selectByExample(cartExample);
		model.addAttribute("sp", sp);
		return "cart";
	}

	@GetMapping("/z")
	public String t() {
		return "ngaythang";
	}

	@PostMapping("/save")
	public String save(@RequestParam("thang") int thang, @RequestParam(value = "tuan") int[] tuan, Model model) {
		StringBuilder result = new StringBuilder();
		result.append("Tháng ").append(thang);
		if (tuan.length == 4) {
			result.append("");
		} else if (tuan != null && tuan.length > 0) {
			result.append(" (Tuần");
			int[] newArray = Arrays.copyOf(tuan, tuan.length);
			Arrays.sort(newArray);
			for (int i = 0; i < newArray.length; i++) {
				result.append(" ").append(newArray[i]);
				int save = ngaythangMapper.save(thang, newArray[i]);
				if (i < newArray.length - 1) {
					result.append(", ");
				}
			}
			result.append(")");
		}

		model.addAttribute("result", result.toString());
		return "ngaythang";

	}

}
