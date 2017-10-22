package com.deli.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deli.core.dao.BrandDAO;
import com.deli.core.pojo.Brand;
import com.deli.core.tools.PageHelper;
import com.deli.core.tools.PageHelper.Page;

/**
 * 品牌服务类
 * 
 * @author Administrator
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDAO brandDAO;
	
	@Override
	public List<Brand> findByExample(Brand brand) {
		return brandDAO.findByExample(brand);
	}
	
	public Page findByExample(Brand brand, Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);// 开始分页
		List<Brand> brands = brandDAO.findByExample(brand);
		Page endPage = PageHelper.endPage();// 结束分页
		return endPage;
	}

	public Brand findById(Long id) {
		return brandDAO.findById(id);
	}

	@Override
	public void updateBrand(Brand brand) {
		brandDAO.updateBrand(brand);
		
	}

}
