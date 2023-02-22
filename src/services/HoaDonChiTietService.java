/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.HoaDonChiTietViewModel;

/**
 *
 * @author virus
 */
public interface HoaDonChiTietService {

    List<String> getAllMaHoaDon();

    List<String> getAllMaCTSP();

    List<HoaDonChiTietViewModel> getAllHoaDon();

    HoaDonChiTietViewModel getOneHoaDon(String ma);

    String addHoaDon(HoaDonChiTietViewModel hd);

    String updateHoaDon(HoaDonChiTietViewModel hd, String ma);

    String removeHoaDon(String ma);
}
