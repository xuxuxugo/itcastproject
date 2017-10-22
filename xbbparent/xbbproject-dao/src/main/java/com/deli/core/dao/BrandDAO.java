package com.deli.core.dao;

import java.util.List;

import com.deli.core.pojo.Brand;
import com.deli.core.tools.PageHelper.Page;

public interface BrandDAO {

	/**
	 * 根据条件查询
	 * @return
	 */
	public List<Brand> findByExample(Brand brand);

	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Brand findById(Long id);


	/**
	 * 修改指定品牌的信息
	 * @param brand
	 */
	public void updateBrand(Brand brand);
	


}
