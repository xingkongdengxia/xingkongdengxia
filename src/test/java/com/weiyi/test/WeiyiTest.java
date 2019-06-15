package com.weiyi.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weiyi.entity.pojo.Weiyiuser;
import com.weiyi.operation.WeiyiuserService;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:/spring/*.xml"}) //加载配置文件
public class WeiyiTest {
	private static Logger log = Logger.getLogger(WeiyiTest.class);
	
	
	@Autowired
	private WeiyiuserService weiyiuserService;
	
	
	/**
	 * 添加
	 */
//	@Test
//	public void insertWeiyiuser() {
//		log.info("WeiyiTest insertWeiyiuser");
//		Map<String, String> data = new HashMap<String, String>();
//		data.put("param_name", "test01");
//		data.put("param_value", "123");
//		boolean insert = weiyiuserService.insert(data);//添加
//		if(insert){
//			log.info("查询是添加成功");
//		}
//		
//		
//	}
	/**
	 * 查询
	 */
	@Test
	public void findWeiyiuser() {
		log.info("WeiyiTest findWeiyiuser");
		//查询
		Weiyiuser weiyiuser = new Weiyiuser();
    	weiyiuser.setParam_name("test01");
		List<Weiyiuser> list = weiyiuserService.sel(weiyiuser);
		String string = list.get(0).toString();
		log.info("查询是否添加成功=====string="+string);
		
		
	}
	
	
	
}
