package com.weiyi.operation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.weiyi.entity.pojo.Weiyiuser;


public interface WeiyiuserService {
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
	@Transactional
	boolean insert(Map<String, String> data);
	
	/**
	 * 登录
	 * @param weiyiuser
	 * @return
	 */
	Map<String,String> recharge(Map<String, String> data,HttpServletRequest request);
	
	/**
	 * 修改
	 * @param weiyiuser
	 * @return
	 */
	@Transactional
	boolean getWeiyiUpdate(Map<String, String> data);
	
	/**
	 * 删除
	 * @param weiyiuser
	 * @return
	 */
	@Transactional
	boolean getWeiyidel(String id);
	
}
