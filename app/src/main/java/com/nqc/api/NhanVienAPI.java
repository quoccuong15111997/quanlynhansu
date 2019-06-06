package com.nqc.api;

import android.os.AsyncTask;

import com.nqc.constan.Const;
import com.nqc.model.NhanVien;

import java.net.HttpURLConnection;
import java.net.URL;

public class NhanVienAPI {
    private String maNhanVien;
    private String tenNhanVien;
    private NhanVien nhanVien;

    public NhanVienAPI() {
    }

    public NhanVienAPI(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }


    public NhanVien LaychiTietNhanVienTheoMa(String maNhanVien){
        nhanVien= new NhanVien();
        LayChiTietNhanVienTheoMaNhanVienTask task= new LayChiTietNhanVienTheoMaNhanVienTask();
        task.execute(maNhanVien);
        return nhanVien;
    }
    public class LayChiTietNhanVienTheoMaNhanVienTask extends AsyncTask<String,Void, NhanVien> {
        @Override
        protected void onPostExecute(NhanVien nhanVien) {
            super.onPostExecute(nhanVien);
            nhanVien=nhanVien;
        }

        @Override
        protected NhanVien doInBackground(String... strings) {
            try{
                URL url= new URL(Const.url+"NhanVien/"+strings[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }
    }
}
