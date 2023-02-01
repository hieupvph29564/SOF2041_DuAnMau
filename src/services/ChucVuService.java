/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.ChucVuViewModel;

/**
 *
 * @author virus
 */
public interface ChucVuService {

    List<ChucVuViewModel> getAllChucVu();

    String addNChucVu(ChucVuViewModel cv);

    String updateChucVu(ChucVuViewModel cv, String ma);

    String deleteChucVu(String ma);

    ChucVuViewModel getOneChucVu(String ma);

}
