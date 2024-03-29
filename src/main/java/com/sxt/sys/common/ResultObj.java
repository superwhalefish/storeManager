package com.sxt.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
	//登陆返回值
	public static final ResultObj  LOGIN_SUCCESS=new ResultObj(Constast.OK, "登陆成功");
	public static final ResultObj  LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR, "登陆失败,用户名或密码不正确");
	public static final ResultObj  LOGIN_ERROR_CODE=new ResultObj(Constast.ERROR, "登陆失败,验证码不正确");
	
	//退出登陆密码返回值
	public static final ResultObj CLEAR_LOGIN_SUCCESS=new ResultObj(Constast.OK,"用户已退出");
	public static final ResultObj CLEAR_LOGIN_ERROR=new ResultObj(Constast.OK,"用户退出失败");
	
	//数据更新返回值
	public static final ResultObj  UPDATE_SUCCESS=new ResultObj(Constast.OK, "更新成功");
	public static final ResultObj  UPDATE_ERROR=new ResultObj(Constast.ERROR, "更新失败");
	
	//数据添加返回值
	public static final ResultObj  ADD_SUCCESS=new ResultObj(Constast.OK, "添加成功");
	public static final ResultObj  ADD_ERROR=new ResultObj(Constast.ERROR, "添加失败");
	
	//数据删除返回值
	public static final ResultObj  DELETE_SUCCESS=new ResultObj(Constast.OK, "删除成功");
	public static final ResultObj  DELETE_ERROR=new ResultObj(Constast.ERROR, "删除失败");
	
	//密码重置返回值
	public static final ResultObj  RESET_SUCCESS=new ResultObj(Constast.OK, "重置成功");
	public static final ResultObj  RESET_ERROR=new ResultObj(Constast.ERROR, "重置失败");
	
	//数据分配返回值
	public static final ResultObj  DISPATCH_SUCCESS=new ResultObj(Constast.OK, "分配成功");
	public static final ResultObj  DISPATCH_ERROR=new ResultObj(Constast.ERROR, "分配失败");
	
	//数据操作返回值
	public static final ResultObj  OPERATE_SUCCESS=new ResultObj(Constast.OK, "操作成功");
	public static final ResultObj  OPERATE_ERROR=new ResultObj(Constast.ERROR, "操作失败");
	private Integer code;
	private String msg;
	
	

}
