/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author virus
 */
public interface ChucVuService {

    List<ChucVu> getAllChucVu();

    String addNChucVu(ChucVu cv);

    String updateChucVu(ChucVu cv, String ma);

    String deleteChucVu(String ma);
    
}
