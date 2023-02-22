/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IKhachHangRepository {

    List<KhachHang> getAllKhachHang();

    KhachHang getOneKhachHang(String ma);

    boolean addKhachHang(KhachHang kh);

    boolean updateKhachHang(KhachHang kh, String ma);

    boolean removeKhachHang(String ma);
}
