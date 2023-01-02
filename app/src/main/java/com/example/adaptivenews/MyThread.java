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
           // socket = new Socket("20.197.17.179", 8080);
           // socket = new Socket("10.1.135.64", 5002);
            socket = new Socket("192.168.1.12", 5002);
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
