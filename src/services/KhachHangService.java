/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.KhachHangViewModel;

/**
 *
 * @author virus
 */
public interface KhachHangService {

    List<KhachHangViewModel> getAllKhachHang();

    KhachHangViewModel getOneKhachHang(String ma);

    String addKhachHang(KhachHangViewModel kh);

    String updateKhachHang(KhachHangViewModel kh, String ma);

    String removeKhachHang(String ma);

}
