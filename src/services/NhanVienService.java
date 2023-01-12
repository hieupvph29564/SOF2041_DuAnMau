/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author virus
 */
public interface NhanVienService {

    NhanVienViewModel getOne(String ma);

    List<NhanVienViewModel> getAllNhanVien();

    String addNhanVien(NhanVienViewModel nv);

    String updateNhanVien(NhanVienViewModel nv, String ma);

    String deleteNhanVien(String ma);

}
