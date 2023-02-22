/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author virus
 */
public class GioHangViewModel {

    private String ma;
    private String idKH;
    private String tenNguoiNhan;
    private int tinhTrang;

    public GioHangViewModel() {
    }

    public GioHangViewModel(String ma, String idKH, String tenNguoiNhan, int tinhTrang) {
        this.ma = ma;
        this.idKH = idKH;
        this.tenNguoiNhan = tenNguoiNhan;
        this.tinhTrang = tinhTrang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Object[] toRowData() {
        return new Object[]{this.ma, this.idKH, this.tenNguoiNhan, this.tinhTrang};
    }
}
