package com.example.adaptivenews;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyThread implements Runnable {
    private volatile String msg = "";
    Socket socket;
    DataOutputStream dos;

    @Override
    public void run() {
        try {
            socket = new Socket("192.168.1.12", 5003);
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.close();
            dos.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsgParam(String msg) {
        this.msg = msg;
        run();
    }

}
