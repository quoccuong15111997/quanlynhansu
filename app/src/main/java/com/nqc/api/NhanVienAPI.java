package com.nqc.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.nqc.constan.Const;
import com.nqc.impl.CallbackLogin;
import com.nqc.model.NhanVien;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVienAPI {
    CallbackLogin callbackLogin;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Context context;

    public NhanVienAPI() {
    }

    public void LaychiTietNhanVienTheoMa(String maNhanVien, Context context,CallbackLogin callbackLogin) {
        this.context=context;
        this.callbackLogin=callbackLogin;
        LayChiTietNhanVienTheoMaNhanVienTask task = new LayChiTietNhanVienTheoMaNhanVienTask();
        task.execute(maNhanVien);
    }

    public class LayChiTietNhanVienTheoMaNhanVienTask extends AsyncTask<String, Void, NhanVien> {
        @Override
        protected void onPostExecute(NhanVien nhanVien) {
            super.onPostExecute(nhanVien);
            if (nhanVien != null) {
                callbackLogin.ThongTinNhanVien(nhanVien);
                /*nv.setMaNV(nhanVien.getMaNV());
                nv.setTenNV(nhanVien.getTenNV());
                nv.setCmnd(nhanVien.getCmnd());
                nv.setEmail(nhanVien.getEmail());
                nv.setSoDienThoai(nhanVien.getSoDienThoai());
                nv.setGioiTinh(nhanVien.isGioiTinh());
                nv.setHeSoLuong(nhanVien.getHeSoLuong());
                nv.setLoaiNV(nhanVien.getLoaiNV());
                nv.setSoQuyetDinh(nhanVien.getSoQuyetDinh());
                nv.setNgaySinh(nhanVien.getNgaySinh());
                nv.setMatKhau(nhanVien.getMatKhau());*/
            }
        }

        @Override
        protected NhanVien doInBackground(String... strings) {
            NhanVien nhanVien= new NhanVien();
            try {
                URL url = new URL(Const.url + "NhanVien/" + strings[0]);
                Log.e("URL",url.toString());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

                InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
                JSONObject object = new JSONObject(builder.toString());
                String tenNV = object.getString("TenNV");
                String ngaySinh = object.getString("NgaySinh");
                boolean gioiTinh = object.getBoolean("GioiTinh");
                int cmnd = object.getInt("SoCMND");
                int soDienThoai = object.getInt("DienThoai");
                String email = object.getString("Email");
                String loaiNV = object.getString("LoaiNV");
                int heSoLuong = object.getInt("HeSoLuong");
                int soQuyetDinh = object.getInt("SoQD");
                String matKhau = object.getString("MatKhau");

                nhanVien.setTenNV(tenNV);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setCmnd(cmnd);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setSoDienThoai(soDienThoai);
                nhanVien.setEmail(email);
                nhanVien.setLoaiNV(loaiNV);
                nhanVien.setHeSoLuong(heSoLuong);
                nhanVien.setSoQuyetDinh(soQuyetDinh);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return nhanVien;
        }
    }
    private String modifyDateLayout(String inputDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh: mm: ss.sssZ").parse(inputDate);
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }
}
