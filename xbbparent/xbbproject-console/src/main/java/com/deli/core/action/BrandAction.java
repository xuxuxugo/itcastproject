package com.deli.core.action;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deli.core.pojo.Brand;
import com.deli.core.service.BrandService;
import com.deli.core.tools.Encoding;
import com.deli.core.tools.PageHelper.Page;

/**
 * 品牌管理控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class BrandAction {

	@Autowired
	private BrandService brandService;
	//通用的入口
	@RequestMapping(value="console/brand/{pageName}.do")
	public String consoleBrandShow(@PathVariable(value="pageName")String pageName){
		return "brand/"+pageName;
	}
	
	// 品牌
	/**
	 * 显示所有的品牌信息
	 * @param model
	 * @param name 名称
	 * @param isDisplay 是否展示
	 * @param pageNum 页数
	 * @param pageSize 一页显示多少数据
	 * @return
	 */
	@RequestMapping(value = "console/brand/list.do")
	public String consoleBrandShowList(
			Model model,String name, Integer isDisplay,
			Integer pageNum, Integer pageSize) {
			// 品牌查询
			// 设置查询条件
			Brand brand = new Brand();
			brand.setName(name);
			brand.setIsDisplay(isDisplay);
			// 开始分页查询
			Page<Brand> pageBrands= brandService.findByExample(brand, pageNum,pageSize);
			// 将查询出来的品牌集合传递给页面
			model.addAttribute("pageBrand", pageBrands);
			// 设置查询数据回显之将查询数据传回给页面
			model.addAttribute("name", name);
			model.addAttribute("isDisplay", isDisplay);
		return "/brand/list";
	}

	/**
	 * 根据指定的品牌修改
	 * @return
	 */
	@RequestMapping(value="console/brand/edit.do")
	public String consoleBrandFindById(Long id ,Model model){
		Brand brand = brandService.findById(id);
		model.addAttribute("brand", brand);
		return "/brand/edit";
	}
	
	/**
	 * 修改指定的品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping(value="console/brand/update.do")
	public String consoleBrandUpdate(Brand brand){
		brandService.updateBrand(brand);
		return "redirect:/console/brand/list.do";
	}
	
}

