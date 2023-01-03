package com.example.adaptivenews;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
    private final String SERVER_IP = "192.168.1.12";
    private final int SERVER_PORT = 5003;
    private Socket socket;
    private BufferedReader input;
    private User user;
    private String flag;

    public void setClient(User user, String flag) {
        this.flag = flag;
        this.user = user;
    };

    @Override
    public void run() {
        try {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
            socket = new Socket(serverAddr, SERVER_PORT);
            String tmp = new String();
            tmp = user.getName() + "-" + user.getPassword() + "-" + user.getAccess() + "-" + flag;
            sendMessage(tmp);

            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!Thread.currentThread().isInterrupted()) {
                String message = input.readLine();
                System.out.println("*******************************");
                System.out.println(message);
                if (message == null || "Disconnect".contentEquals(message)) {
                    boolean interrupted = Thread.interrupted();
                    message = "Server Disconnected: " + interrupted;
                    break;
                }

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(final String message) {
        new Thread(() -> {
            try {
                if (null != socket) {
                    PrintWriter out = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),
                            true);
                    out.println(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


}





