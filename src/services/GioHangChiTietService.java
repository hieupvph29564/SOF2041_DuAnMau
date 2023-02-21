/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.GioHangChiTietViewModel;

/**
 *
 * @author virus
 */
public interface GioHangChiTietService {

    List<GioHangChiTietViewModel> getAllGioHang();

    GioHangChiTietViewModel getOneGioHang(String ma);

    String addGioHang(GioHangChiTietViewModel gh);

    String updateGioHang(GioHangChiTietViewModel gh, String ma);

    String removeGioHang(String ma);
}
