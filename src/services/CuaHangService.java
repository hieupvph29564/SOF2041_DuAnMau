/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.CuaHangViewModel;

/**
 *
 * @author virus
 */
public interface CuaHangService {

    List<CuaHangViewModel> getAllCuaHang();

    String addCuaHang(CuaHangViewModel ch);

    String updateCuaHang(CuaHangViewModel ch, String ma);

    String deleteCuaHang(String ma);

    CuaHangViewModel getOneCuaHang(String ma);
    
}
