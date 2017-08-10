package com.smgp.message;

import com.smgp.protocol.RequestId;
import com.utils.TypeConvert;

public class ActiveTestMessage  extends Message{
    public ActiveTestMessage(){
        int len = 12;
        this.buf = new byte[len];
        TypeConvert.int2byte(len, this.buf, 0);
        TypeConvert.int2byte(RequestId.ActiveTest, this.buf, 4);
    } 
    public ActiveTestMessage(int seq){
        int len = 12;
        this.buf = new byte[len];
        TypeConvert.int2byte(len, this.buf, 0);
        TypeConvert.int2byte(RequestId.ActiveTest, this.buf, 4);//requestID
        TypeConvert.int2byte(this.sequence_Id, this.buf, 8); // sequence_Id
    } 
}
