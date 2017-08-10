package com.smgp.inf;

import com.smgp.bean.Deliver;
import com.smgp.bean.SubmitResp;

public interface ClientEventInterface {
    public void onDeliver(Deliver deliver);
    public void OnSubmitResp(SubmitResp submitResp);
}
