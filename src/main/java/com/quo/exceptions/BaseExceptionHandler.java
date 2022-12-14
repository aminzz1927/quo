
package com.quo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.utils.Result;
import com.quo.utils.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的公共异常处理器 1.声明异常处理器 2.对异常统一处理
 */
@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(value = Exception.class)

	@ResponseBody
	public Result error(HttpServletRequest request, HttpServletResponse response, Exception e) {
		if (e.getClass() == CommonException.class) { 
			// 类型转型 
			CommonException ce = (CommonException) e;
			Result result = new Result(ce.getResultCode());
			return result;
		} else {
			Result result = new Result(ResultCode.SERVER_ERROR);
			return result;
		}
	}
}
