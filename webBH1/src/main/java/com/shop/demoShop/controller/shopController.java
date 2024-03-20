package com.shop.demoShop.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.shop.demoShop.mapper.dbo.accoutMapper;
import com.shop.demoShop.mapper.dbo.cartitemMapper;
import com.shop.demoShop.mapper.dbo.gheMapper;
import com.shop.demoShop.mapper.dbo.loaigheMapper;
import com.shop.demoShop.model.accout;
import com.shop.demoShop.model.ghe;
import com.shop.demoShop.model.gheExample;
import com.shop.demoShop.model.loaighe;
import com.shop.demoShop.model.loaigheExample;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class shopController {
	
	@Autowired
	gheMapper gheMapper;
	
	@Autowired
	loaigheMapper loaigheMapper;
	
	@Autowired
	accoutMapper accoutMapper;
	
	@Autowired
	cartitemMapper cartitemMapper;
	@GetMapping("/index")
	public String index(Model model ) {
		loaigheExample example = new loaigheExample();
		List<loaighe> lg = loaigheMapper.selectByExample(example);
		model.addAttribute("lg", lg);
		return "index";
	}
	@GetMapping("/shop")
	public String shop(Model model, @RequestParam(name="offset" , defaultValue = "1") int offset , @RequestParam(name = "pagesize" , defaultValue = "8") int pagesize) {
		int page = (offset - 1) * pagesize;
		List<ghe> g = gheMapper.getSPbySize(page, pagesize);
		List<ghe> ssp = gheMapper.getAll();
		int sotrang;
		if (ssp.size() % pagesize != 0) {
			sotrang = ssp.size() / pagesize + 1;
		} else
			sotrang = ssp.size() / pagesize;
		model.addAttribute("g", g);
		model.addAttribute("sotrang", sotrang);
		model.addAttribute("offset", offset);
		return "shop";
	}
	@GetMapping("/{idg}")
	public String detel(Model model , @PathVariable("idg") int idg, @RequestParam(name="offset" , defaultValue = "1") int offset , @RequestParam(name = "pagesize" , defaultValue = "8") int pagesize) {
		int page = (offset - 1) * pagesize;
		List<ghe> g = gheMapper.phantrangtheomaghe(idg, page, pagesize);
		List<ghe> ssp = gheMapper.phanloaighe(idg);
		int sotrang;
		if (ssp.size() % pagesize != 0) {
			sotrang = ssp.size() / pagesize + 1;
		} else
			sotrang = ssp.size() / pagesize;
		model.addAttribute("g", g);
		model.addAttribute("sotrang", sotrang);
		model.addAttribute("offset", offset);
		return "shop";
	}
	@GetMapping("/search")
	public String timkiem(Model model , @RequestParam("ten") String ten , @RequestParam(name="offset" , defaultValue = "1") int offset , @RequestParam(name = "pagesize" , defaultValue = "4") int pagesize) {
		int page = (offset - 1) * pagesize;
		List<ghe> g = gheMapper.phantrangtheoSearch(ten, page, pagesize);
		List<ghe> ssp = gheMapper.search(ten);
		int sotrang;
		if (ssp.size() % pagesize != 0) {
			sotrang = ssp.size() / pagesize + 1;
		} else
			sotrang = ssp.size() / pagesize;
		model.addAttribute("g", g);
		model.addAttribute("sotrang", sotrang);
		model.addAttribute("offset", offset);
		model.addAttribute("ten", ten);
		return "search";
	}
	@GetMapping("/login")
	public String login(accout accout) {
		return "login";
	}
	@GetMapping("/dangki")
	public String dangki() {
		return "dangki";
	}
	@PostMapping("/checkdangnhap")
	public String checkdangnhap(@Valid accout accout , BindingResult bindingResult, HttpSession session,Model model , @RequestParam("username") String username , @RequestParam("passwork") String passwork) {
		model.addAttribute("accout", accout );
		if(bindingResult.hasErrors()) {
			return "login";
		}else {
			accout dn = accoutMapper.dangnhap(username, passwork);
			if(dn != null) {
				session.setAttribute("accdangnhap", dn);
				session.setAttribute("accgetissell", dn.getIssell());
				session.setAttribute("accgetisadmin", dn.getIsadmin());
				session.setAttribute("accgetusername", dn.getUsername());
	//			session.setMaxInactiveInterval(5000);
				return "redirect:/index";
			}else {
				model.addAttribute("mes", "Sai Username or Passwork");
				return "login";
			}
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("acc");
		return"redirect:/index";
	}
	@PostMapping("/checkdangki")
	public String checkdangki(   Model model , @RequestParam("username") String username , @RequestParam("email") String email,
			@RequestParam("passwork") String passwork,@RequestParam("repasswork") String repasswork) {
		
			if(!passwork.equals(repasswork)) {
				model.addAttribute("messpass", "Không giống passwork");
				return "dangki";
			}else {
				accout checkuser = accoutMapper.checkuser(username);
				if(checkuser == null) {
					int dangki = accoutMapper.dangki(username, email, passwork, repasswork);
					return "login";
				}			
			}
			model.addAttribute("messuser", "username tồn tại");
			return "dangki";
		}		
	
	
	@GetMapping("/detel/{id}")
	public String chitetsanpham(Model model , @PathVariable("id") int id) {
		ghe chitietsanpham = gheMapper.detel(id);
		model.addAttribute("chitietsanpham", chitietsanpham);
		return "detel";
	}
	
	@GetMapping("/show")
	public String CRUD(Model model , HttpSession session) {
		accout dangnhap = (accout) session.getAttribute("accdangnhap");
		int mnv = dangnhap.getAid();
		List<ghe> list = gheMapper.getByMaNv(mnv);
		model.addAttribute("list", list);
		loaigheExample example = new loaigheExample();
		List<loaighe> lg = loaigheMapper.selectByExample(example);
		model.addAttribute("lg", lg);
		return"CRUD";
	}
	
	@PostMapping("/addSP")
	public String addsp(HttpSession session , Model model , @RequestParam("ten") String ten,
			@RequestParam("hinhanh") String hinhanh, @RequestParam("gia") int gia, @RequestParam("mota") String mota,
			@RequestParam("maghe") int maghe) {
		accout dangnhap = (accout) session.getAttribute("accdangnhap");
		int manv = dangnhap.getAid();
		int insert = gheMapper.insertSP(ten, hinhanh, gia, mota, maghe, manv);
		return "redirect:/show";
	}
	@GetMapping("/edit/{id}")
	public String editbyID(Model model, @PathVariable("id") int id) {
		ghe findbyid = gheMapper.findById(id);
		model.addAttribute("findbyid", findbyid);
		loaigheExample example = new loaigheExample();
		List<loaighe> lg = loaigheMapper.selectByExample(example);
		model.addAttribute("lg", lg);
		return "edit";
	}
	@PostMapping("/updateSp")
	public String update(Model model , @RequestParam("ten") String ten,
			@RequestParam("hinhanh") String hinhanh, @RequestParam("gia") int gia, @RequestParam("mota") String mota,
			@RequestParam("maghe") int maghe , @RequestParam("id") int id) {
		int up = gheMapper.updatebyID(ten, hinhanh, gia, mota, maghe, id);
		return "redirect:/show";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletebyID(Model model , @PathVariable("id") int id) {
		int delete = gheMapper.deletebyID(id);
		return "redirect:/show";
	}
	
	@PostMapping("/addtocart")
	public ResponseEntity<String> addtocart(){
//		accout dangnhap = (accout) session.getAttribute("accdangnhap");
//		int idnguoidung = dangnhap.getAid();
//		int addtocart = cartitemMapper.addtocart(hinhanhc, idnguoidung, idsanpham, soluong);
		return ResponseEntity.ok("Sản phẩm đã được thêm vào giỏ hàng");
	}
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
}
