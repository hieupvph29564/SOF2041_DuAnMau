/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.GioHangViewModel;

/**
 *
 * @author virus
 */
public interface GioHangService {

    List<String> getAllIDKH();

    List<GioHangViewModel> getAllGioHang();

    String addGioHang(GioHangViewModel gh);

    String updateGioHang(GioHangViewModel gh, String ma);

    String deleteGioHang(String ma);
}
