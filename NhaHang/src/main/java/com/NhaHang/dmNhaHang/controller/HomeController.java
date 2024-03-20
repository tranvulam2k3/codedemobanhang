package com.NhaHang.dmNhaHang.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.NhaHang.dmNhaHang.mapper.dbo.DICHVUMapper;
import com.NhaHang.dmNhaHang.mapper.dbo.THONGTINTHIEPCUOIMapper;
import com.NhaHang.dmNhaHang.model.DICHVU;
import com.NhaHang.dmNhaHang.model.DICHVUExample;
import com.NhaHang.dmNhaHang.model.THONGTINTHIEPCUOI;
import com.NhaHang.dmNhaHang.model.THONGTINTHIEPCUOIExample;

@Controller
public class HomeController {
	
	@Autowired
	THONGTINTHIEPCUOIMapper thongtinthiepcuoiMapper;
	@Autowired
	DICHVUMapper dichvuMapper;

	@GetMapping("/home")
	public String homePage(Model model) {
		THONGTINTHIEPCUOIExample example = new THONGTINTHIEPCUOIExample();
		List<THONGTINTHIEPCUOI> tt = thongtinthiepcuoiMapper.selectByExample(example);
		model.addAttribute("tt", tt);		
		return "home";
	}
	
	@PostMapping("booking")
	public String booking(Model model) {
		DICHVUExample example = new DICHVUExample();
		List<DICHVU> dv = dichvuMapper.selectByExample(example);
		model.addAttribute("dv", dv);
		return "datlich";
	}
	@PostMapping("addthongtin")
	public String add(Model model,@RequestParam("id") int id,@RequestParam("tencodau") String tencodau,@RequestParam("tenchure") String tenchure,
			@RequestParam("soluongban") int soluongban,@RequestParam("dongia") int dongia,@RequestParam("dichvudikem") int dichvudikem,
			@RequestParam("tiendatcoc") int tiendatcoc,@RequestParam("tienthanhtoan") int tienthanhtoan,@RequestParam("ghichu") String ghichu,
			@RequestParam("thongtinthiepcuoi") Date thongtinthiepcuoi) {		
			int book = thongtinthiepcuoiMapper.addtt(id, tencodau, tenchure, soluongban, dongia, dichvudikem, tiendatcoc, tienthanhtoan, ghichu, thongtinthiepcuoi);						
			return "redirect:/home";		
	}
	@PostMapping("/home")
	public String tim(@RequestParam("tencodau") String tencodau , Model model) {
		List<THONGTINTHIEPCUOI> tk = thongtinthiepcuoiMapper.timkiem(tencodau);
		model.addAttribute("tk", tk);
		return "show";
		
	}
	
	
	
	
	
	
}
