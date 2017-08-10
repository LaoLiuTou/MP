package com.smgp.server.inf;

import com.smgp.bean.Deliver;
import com.smgp.bean.Login;
import com.smgp.bean.Submit;
import com.smgp.server.result.LoginResult;
import com.smgp.server.result.SubmitResult;

public interface ServerEventInterface {
     public SubmitResult onSumit(Submit submit,String account);
     public LoginResult  onLogin(Login login);
     public void SendDeliver(Deliver deliver);
     public void ListConnected();
     public void Exit();
}
