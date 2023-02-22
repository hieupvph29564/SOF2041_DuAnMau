/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;


/**
 *
 * @author virus
 */
public class HoaDonChiTietViewModel {

    private String idHoaDon;
    private String idChiTietSP;
    private int soLuong;

    public HoaDonChiTietViewModel(String idHoaDon, String idChiTietSP, int soLuong) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
    }

    public HoaDonChiTietViewModel() {
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
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
        return new Object[]{this.idHoaDon, this.idChiTietSP, this.soLuong};
    }
}
