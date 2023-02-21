/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.math.BigDecimal;

/**
 *
 * @author virus
 */
public class GioHangChiTietViewModel {

    private String idGioHang;
    private String idChiTietSP;
    private int soLuong;
    private BigDecimal donGia;

    public GioHangChiTietViewModel() {
    }

    public GioHangChiTietViewModel(String idGioHang, String idChiTietSP, int soLuong, BigDecimal donGia) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Object[] toRowData() {
        return new Object[]{this.idGioHang, this.idChiTietSP, this.soLuong, this.donGia};
    }
}
