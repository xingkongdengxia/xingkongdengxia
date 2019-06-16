package com.weiyi.operation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.weiyi.entity.pojo.Weiyiuser;
import com.weiyi.operation.WeiyiuserService;
import com.weiyi.service.WeiyiuserMapper;

@Service
public class WeiyiuserServiceimpl implements WeiyiuserService{
	private static Logger log = Logger.getLogger(WeiyiuserServiceimpl.class);
	
	@Autowired 
    private WeiyiuserMapper weiyiuserMapper;

	
	
	
	public List<Weiyiuser> sel(Weiyiuser weiyiuser) {
		List<Weiyiuser> weiyiuser2 = weiyiuserMapper.sel(weiyiuser);
		return weiyiuser2;
	}

	/**
	 * 添加
	 */
	@Override
	public boolean insert(Map<String, String> data) {
		log.info("WeiyiuserServiceimpl insert="+data.toString());
		String param_name = data.get("param_name");
		String param_value = data.get("param_value");
		String power = data.get("power");
		Weiyiuser weiyiuser = new Weiyiuser();
		weiyiuser.setParam_name(param_name);
		weiyiuser.setParam_value(param_value);
		weiyiuser.setPower(power);
		int i = weiyiuserMapper.insert(weiyiuser);
		boolean flag = false;
		if(i==1){
			flag = true;
		}
		return flag;
	} 
	
	/**
	 * 登录
	 * @param weiyiuser
	 * @return
	 */
	@Override
	public Map<String,String> recharge(Map<String, String> data,HttpServletRequest request) {
		Map<String,String> map=new HashMap<>();
		String param_name=data.get("ming").trim();        
    	String param_value=data.get("mi").trim(); 
    	
    	//创建Subject
    	Subject currentUser = SecurityUtils.getSubject();
    	
    	//判断当前用户是否登录
    	if(currentUser.isAuthenticated() == false){
    		//将当前用户记密码封装UsernamePasswordToken
    		UsernamePasswordToken token = new UsernamePasswordToken(param_name, param_value);
    		try {
				currentUser.login(token);
			} catch (AuthenticationException e) {
				map.put("xiaoxi", "用户名或密码错误！！！");
			}
    	
    	}
    	Weiyiuser weiyiuser = new Weiyiuser();
    	weiyiuser.setParam_name(param_name);
    	weiyiuser.setParam_value(param_value);
    	List<Weiyiuser> list = weiyiuserMapper.sel(weiyiuser);
    	HttpSession session = request.getSession();
    	session.setAttribute("user", list.get(0));
    	log.info("访问成功！！！");
		return map;
	}



	/**
	 * 修改
	 */
	@Override
	public boolean getWeiyiUpdate(Map<String, String> data) {
		log.info("WeiyiuserServiceimpl getWeiyiUpdate="+data.toString());
		String id = data.get("id");
		String param_name = data.get("param_name");
		String param_value = data.get("param_value");
		String power = data.get("power");
		Weiyiuser weiyiuser = new Weiyiuser();
		weiyiuser.setId(Integer.parseInt(id));
		weiyiuser.setParam_name(param_name);
		weiyiuser.setParam_value(param_value);
		weiyiuser.setPower(power);
		
		boolean flag = false;
		int i = weiyiuserMapper.update(weiyiuser);
		if(i==1){
			flag = true;
		}
		return flag;
	}



	/**
	 * 删除
	 */
	@Override
	public boolean getWeiyidel(String id) {
		log.info("WeiyiuserServiceimpl getWeiyidel="+id);
		String[] split = null;
		if(!StringUtils.isEmpty(id)){
			split= id.split(",");
		}
		boolean flag = false;
		int j = 0;
		for(int i=0;i<split.length;i++){
			String string = split[i];
			int parseInt = Integer.parseInt(string);
			j = weiyiuserMapper.del(parseInt);
		}
		if(j==1){
			flag = true;
		}
		return flag;
	}
}
