/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.DongSPViewModel;

/**
 *
 * @author virus
 */
public interface DongSPService {

    List<DongSPViewModel> getAllDongSP();

    DongSPViewModel getOneDongSP(String ma);

    String addDongSP(DongSPViewModel sp);

    String updateDongSP(DongSPViewModel sp, String ma);

    String deleteDongSP(String ma);
}
