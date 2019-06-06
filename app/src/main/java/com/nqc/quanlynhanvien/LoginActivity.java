package com.nqc.quanlynhanvien;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.nqc.api.NhanVienAPI;
import com.nqc.constan.Const;
import com.nqc.model.NhanVien;

import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private EditText edtMaNhanVien, edtPassword;
    private Button btnLogin;
    private TextView txtQuenMatKhau;
    CheckBox chkNhoMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVienAPI nhanVienAPI= new NhanVienAPI();
            }
        });
    }

    private void addControls() {
        edtMaNhanVien=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        chkNhoMatKhau=findViewById(R.id.chkRemember);
        txtQuenMatKhau=findViewById(R.id.txtQuenMatKhau);
    }
}
