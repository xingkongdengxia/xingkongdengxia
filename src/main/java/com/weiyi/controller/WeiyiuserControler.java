package com.weiyi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weiyi.entity.pojo.Weiyiuser;
import com.weiyi.operation.WeiyiuserService;
@Controller
@RequestMapping("/weiyiuserControler")
public class WeiyiuserControler {
	private static Logger log = Logger.getLogger(WeiyiuserControler.class);

	@Autowired
	private WeiyiuserService weiyiuserService;
	
    
    /**
     * 登录
     * @param data
     * @return
     */
    @RequestMapping(value = "/index/login", method = RequestMethod.POST)    
    @ResponseBody    
    public ResponseEntity<Object> recharge(@RequestBody Map<String, String> data,HttpServletRequest request) { 
    	Map<String, String> map = weiyiuserService.recharge(data, request);
    	return new ResponseEntity<Object>(map, HttpStatus.OK);    
    }

    /**
     * 
     * 跳转主页
     * @param model
     * @return
     */
    @RequestMapping("/zhuye")
    public String login() {
        return "homepage";
    }
    /**
     * 
     * 查询
     * @param model
     * @return
     */
    @RequestMapping("/usertableData")
    @ResponseBody   
    public ResponseEntity<Object> usertableData() {
    	log.info("WeiyiuserControler  usertableData  data");
    	List<Weiyiuser> list = weiyiuserService.sel(null);
    	return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
    
    /**
     * 
     * 根据id查询数据
     * @param id
     * @return
     */
    @RequestMapping(value="/WeiyiuserByid", method=RequestMethod.POST)
    @ResponseBody   
    public ResponseEntity<Object> getWeiyiuserByid(@RequestBody Map<String, String> data) {
    	log.info("WeiyiuserControler  getWeiyiuserByid  data"+data.toString());
    	Weiyiuser weiyiuser = new Weiyiuser();
    	String id = data.get("id");
    	weiyiuser.setId(Integer.parseInt(id));
    	Map<String,Weiyiuser> map=new HashMap<>();
    	List<Weiyiuser> list = weiyiuserService.sel(weiyiuser);
    	map.put("user", list.get(0));
    	return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
    
    /**
     * 
     * 修改
     * @param weiyiuser
     * @return
     */
    @RequestMapping(value="/WeiyiuserByupdate", method=RequestMethod.POST)
    @ResponseBody   
    public ResponseEntity<Object> updateWeiyiuser(@RequestBody Map<String, String> data) {
		boolean update = weiyiuserService.getWeiyiUpdate(data);
		return new ResponseEntity<Object>(update,HttpStatus.OK);
    }
    /**
     * 
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/WeiyiuserBydel", method=RequestMethod.POST)
    @ResponseBody   
    public ResponseEntity<Object> delWeiyiuser(@RequestBody String weiyiuser) {
    	boolean weiyidel = weiyiuserService.getWeiyidel(weiyiuser);
    	return new ResponseEntity<Object>(weiyidel, HttpStatus.OK);
    }
    /**
     * 
     * 添加
     * @param id
     * @return
     */
    @RequestMapping(value="/WeiyiuserByinsert", method=RequestMethod.POST)
    @ResponseBody   
    public ResponseEntity<Object> insertWeiyiuser(@RequestBody Map<String, String> data) {
    	boolean insert = weiyiuserService.insert(data);
    	return new ResponseEntity<Object>(insert, HttpStatus.OK);
    }
}
