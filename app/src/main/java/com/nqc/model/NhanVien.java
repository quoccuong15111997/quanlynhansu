package com.nqc.model;

import java.io.Serializable;
import java.util.Date;

public class NhanVien implements Serializable {
    private String maNV;
    private String tenNV;
    private Date ngaySinh;
    private boolean gioiTinh;
    private int cmnd;
    private int soDienThoai;
    private String email;
    private String loaiNV;
    private int heSoLuong;
    private String maChucVu;
    private String maLuong;
    private String maPhongBan;
    private String maTrinhDoHocVan;
    private String maCongTac;
    private String maDieuChinhLuong;
    private int soQuyetDinh;
    private String maChuyenMon;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, Date ngaySinh, boolean gioiTinh, int cmnd, int soDienThoai, String email, String loaiNV, int heSoLuong, String maChucVu, String maLuong, String maPhongBan, String maTrinhDoHocVan, String maCongTac, String maDieuChinhLuong, int soQuyetDinh, String maChuyenMon, String matKhau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.loaiNV = loaiNV;
        this.heSoLuong = heSoLuong;
        this.maChucVu = maChucVu;
        this.maLuong = maLuong;
        this.maPhongBan = maPhongBan;
        this.maTrinhDoHocVan = maTrinhDoHocVan;
        this.maCongTac = maCongTac;
        this.maDieuChinhLuong = maDieuChinhLuong;
        this.soQuyetDinh = soQuyetDinh;
        this.maChuyenMon = maChuyenMon;
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getMaTrinhDoHocVan() {
        return maTrinhDoHocVan;
    }

    public void setMaTrinhDoHocVan(String maTrinhDoHocVan) {
        this.maTrinhDoHocVan = maTrinhDoHocVan;
    }

    public String getMaCongTac() {
        return maCongTac;
    }

    public void setMaCongTac(String maCongTac) {
        this.maCongTac = maCongTac;
    }

    public String getMaDieuChinhLuong() {
        return maDieuChinhLuong;
    }

    public void setMaDieuChinhLuong(String maDieuChinhLuong) {
        this.maDieuChinhLuong = maDieuChinhLuong;
    }

    public int getSoQuyetDinh() {
        return soQuyetDinh;
    }

    public void setSoQuyetDinh(int soQuyetDinh) {
        this.soQuyetDinh = soQuyetDinh;
    }

    public String getMaChuyenMon() {
        return maChuyenMon;
    }

    public void setMaChuyenMon(String maChuyenMon) {
        this.maChuyenMon = maChuyenMon;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
