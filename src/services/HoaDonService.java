/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author virus
 */
public interface HoaDonService {

    List<HoaDonViewModel> getAllHoaDon();

    HoaDonViewModel getOneHoaDon(String ma);

    String addHoaDon(HoaDonViewModel hd);

    String updateHoaDon(HoaDonViewModel hd, String ma);

    String deleteHoaDon(String ma);
    
}
