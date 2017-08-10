package com.smgp.message;

import com.smgp.protocol.RequestId;
import com.utils.TypeConvert;

public class ExitMessage extends Message{
    public ExitMessage(){
        int len = 12;
        buf = new byte[len];
        TypeConvert.int2byte(len, buf, 0);
        TypeConvert.int2byte(RequestId.Exit, buf, 4);
    }
}
