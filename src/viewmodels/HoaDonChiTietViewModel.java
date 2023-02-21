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
public class HoaDonChiTietViewModel {

    private String idHoaDon;
    private String idChiTietSanPham;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String idHoaDon, String idChiTietSanPham, int soLuong, BigDecimal donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSanPham = idChiTietSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(String idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
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
        return new Object[]{this.idHoaDon, this.idChiTietSanPham, this.soLuong, this.donGia};
    }
}
