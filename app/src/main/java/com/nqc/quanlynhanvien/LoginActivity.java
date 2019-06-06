package com.nqc.quanlynhanvien;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nqc.api.NhanVienAPI;
import com.nqc.constan.Const;
import com.nqc.impl.CallbackLogin;
import com.nqc.model.NhanVien;
import com.nqc.sharepreference.ManagerSharePreference;
import com.shashank.sony.fancytoastlib.FancyToast;

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
        ManagerSharePreference.loadData(edtMaNhanVien,edtPassword,chkNhoMatKhau);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtMaNhanVien.getText().toString().equals("") && !edtPassword.getText().toString().equals("")) {
                    if (chkNhoMatKhau.isChecked())
                        //lưu lại thông tin đăng nhập
                        ManagerSharePreference.saveData(edtMaNhanVien.getText().toString(),edtPassword.getText().toString(),chkNhoMatKhau);
                    else
                        ManagerSharePreference.clearData();
                    xuLyLogin();
                } else
                    FancyToast.makeText(LoginActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
            }
        });
        txtQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void xuLyLogin() {
        CallbackLogin callbackLogin = new CallbackLogin() {
            @Override
            public void ThongTinNhanVien(NhanVien nhanVien) {
                if (nhanVien.getMatKhau() != null) {
                    if (nhanVien.getMatKhau().equals(edtPassword.getText().toString())) {
                        FancyToast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();

                        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("NHANVIEN",nhanVien);
                        startActivity(intent);
                        finish();
                    } else
                        FancyToast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
                } else
                    FancyToast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG, FancyToast.ERROR, false).show();
            }
        };
        NhanVienAPI nhanVienAPI = new NhanVienAPI();
        nhanVienAPI.LaychiTietNhanVienTheoMa(edtMaNhanVien.getText().toString(), LoginActivity.this, callbackLogin);
    }

    private void addControls() {
        edtMaNhanVien = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        chkNhoMatKhau = findViewById(R.id.chkRemember);
        txtQuenMatKhau = findViewById(R.id.txtQuenMatKhau);
    }
}
