/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainmodels.NhanVien;
import java.util.List;

/**
 *
 * @author virus
 */
public interface NhanVienService {

    List<NhanVien> getAllNhanVien();

    String addNhanVien(NhanVien nv);

    String updateNhanVien(NhanVien nv, String ma);

    String deleteNhanVien(String ma);
    
}
