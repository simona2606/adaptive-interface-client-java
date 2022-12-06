package com.example.adaptivenews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoginActivity extends AppCompatActivity {
    Button login_btn;
    MyThread myThread;
    EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        name = findViewById(R.id.name);

        myThread = new MyThread();
        new Thread(myThread).start();

        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }

    private class MyThread implements Runnable {
        private volatile String msg = "";
        Socket socket;
        DataOutputStream dos;

        @Override
        public void run() {
            try {
                socket = new Socket("192.168.1.12", 5001);
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

    public void btnClickSnd(View v) {
        String msg = name.getText().toString();
        myThread.sendMsgParam(msg);
    }


}
