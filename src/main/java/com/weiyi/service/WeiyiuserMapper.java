package com.weiyi.service;

import java.util.List;

import com.weiyi.entity.pojo.Weiyiuser;

public interface WeiyiuserMapper {

	/**
	 * 查询
	 * @param weiyiuser
	 * @return
	 */
	List<Weiyiuser> sel(Weiyiuser weiyiuser);
	
	/**
	 * 添加
	 * @param weiyiuser
	 * @return
	 */
	int insert(Weiyiuser weiyiuser);
	
	/**
	 *修改
	 * @param weiyiuser
	 * @return
	 */
	int update(Weiyiuser weiyiuser);
	
	/**
	 * 删除
	 * @param weiyiuser
	 * @return
	 */
	int del(int id);
	
}
