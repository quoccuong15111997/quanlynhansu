package com.nqc.quanlynhanvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

public class ForgotPasswordActivity extends AppCompatActivity {
    private OtpTextView otpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        otpTextView = findViewById(R.id.otp_view);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                // fired when user types something in the Otpbox
            }
            @Override
            public void onOTPComplete(String otp) {
                // fired when user has entered the OTP fully.
                Toast.makeText(ForgotPasswordActivity.this, "The OTP is " + otp,  Toast.LENGTH_SHORT).show();
                otpTextView.showSuccess();
            }
        });
    }

    public void ShowError(View view) {
        otpTextView.showError();
    }

    public void ShowSusses(View view) {
        otpTextView.showSuccess();
    }
}
