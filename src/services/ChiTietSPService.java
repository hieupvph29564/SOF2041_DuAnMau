/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.ChiTietSPViewModel;

/**
 *
 * @author virus
 */
public interface ChiTietSPService {

    List<ChiTietSPViewModel> getAllChiTietSP();

    ChiTietSPViewModel getOneChiTietSP(String ma);

    String addChiTietSP(ChiTietSPViewModel ctsp);

    String updateChiTietSP(ChiTietSPViewModel ctsp, String ma);

    String removeChiTietSP(String ma);
}
