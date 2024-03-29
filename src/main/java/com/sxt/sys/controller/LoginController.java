package com.sxt.sys.controller;


import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.sys.common.ActiverUser;
import com.sxt.sys.common.ResultObj;
import com.sxt.sys.common.WebUtils;
import com.sxt.sys.domain.Loginfo;
import com.sxt.sys.service.LoginfoService;

/**
 *用户登陆
 *
 */
@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginfoService loginfoService;
	//用户登陆
	@RequestMapping("login")
	public ResultObj login(String loginname,String pwd) {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token=new UsernamePasswordToken(loginname, pwd);
		try {
			subject.login(token);
			ActiverUser activerUser=(ActiverUser) subject.getPrincipal();
			WebUtils.getSession().setAttribute("user", activerUser.getUser());
			//记录登陆日志
			Loginfo entity=new Loginfo();
			entity.setLoginname(activerUser.getUser().getName()+"-"+activerUser.getUser().getLoginname());
			entity.setLogintime(new Date());
			loginfoService.save(entity);
			return ResultObj.LOGIN_SUCCESS;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResultObj.LOGIN_ERROR_PASS;
		}
	}
	//用户退出
	@RequestMapping("clearlogin")
	public ResultObj clearlogin() {
		WebUtils.getSession().removeAttribute("user");
		if(WebUtils.getSession().getAttribute("user") != null) {
			System.out.println("退出失败");
			return ResultObj.CLEAR_LOGIN_ERROR;
		
		}else {
			System.out.println("成功");
			return ResultObj.CLEAR_LOGIN_SUCCESS;
		}
		
	}
	
	
}

