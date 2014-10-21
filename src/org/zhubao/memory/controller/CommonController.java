/**
 * 
 */
package org.zhubao.memory.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhubao.memory.model.User;
import org.zhubao.memory.service.UserService;
import org.zhubao.memory.vo.UserVo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;

/**
 * @author jason.zhu
 * @date   2014-10-21
 * @email jasonzhu@augmentum.com.cn
 */
@Controller
public class CommonController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody UserVo getUserData(){
		UserVo userVo = new UserVo();
		userVo.setName("Jason");
		userVo.setUserId(UUID.randomUUID().toString());
		userVo.setItemIds(ImmutableList.of(1,2,3));
		userVo.setGender(1);
		userVo.setBirthDate("2014-10-21");
		return userVo;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody String getUsers(){
		List<User> users = userService.getUsers();
		return JSON.toJSONString(users);
	}
	
}
