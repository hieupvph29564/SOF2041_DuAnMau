/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author virus
 */
public class HoaDonViewModel {

    private String ma;
    private int tinhTrang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String ma, int tinhTrang) {
        this.ma = ma;
        this.tinhTrang = tinhTrang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Object[] toRowData() {
        return new Object[]{this.ma, this.tinhTrang};
    }
}
