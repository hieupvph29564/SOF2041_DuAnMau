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

    public GioHangChiTietViewModel() {
    }

    public GioHangChiTietViewModel(String idGioHang, String idChiTietSP, int soLuong) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
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

    public Object[] toRowData() {
        return new Object[]{this.idGioHang, this.idChiTietSP, this.soLuong};
    }
}
