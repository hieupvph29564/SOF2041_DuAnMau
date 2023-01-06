/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.CuaHang;
import java.util.List;

/**
 *
 * @author virus
 */
public interface CuaHangService {

    List<CuaHang> getAllCuaHang();

    String addCuaHang(CuaHang ch);

    String updateCuaHang(CuaHang ch, String ma);

    String deleteCuaHang(String ma);
    
}
