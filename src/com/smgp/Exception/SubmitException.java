package com.smgp.Exception;

import com.smgp.bean.Result;

public class SubmitException extends Exception {

	private static final long serialVersionUID = 1L;
	private Result result=new Result();
	public Result getResult() {
		return result;
	}
	public SubmitException(Result result){
		this.result=result;
	}
	public void setResult(Result result) {
		this.result = result;
	}

}
