package com.deli.core.service;

import java.util.List;

import com.deli.core.pojo.Brand;
import com.deli.core.tools.PageHelper.Page;

/**
 * 品牌服务类接口
 * 
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 根据条件查询
	 * 
	 * @return
	 */
	public List<Brand> findByExample(Brand brand);
	/**
	 * 根据条件查询
	 * 
	 * @return
	 */
	public Page findByExample(Brand brand,Integer pageNum,Integer pageSize);
	/**
	 * 根据id去查询对应的品牌
	 * @param id
	 * @return
	 */
	public Brand findById(Long id);
	/**
	 * 修改品牌的信息
	 * @param brand
	 */
	public void updateBrand(Brand brand);

}
