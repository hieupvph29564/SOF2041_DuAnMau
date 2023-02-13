/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author virus
 */
public interface SanPhamService {

    List<SanPhamViewModel> getAllSanPham();

    SanPhamViewModel getOneSanPham(String ma);

    String addSanPham(SanPhamViewModel sp);

    String updateSanPham(SanPhamViewModel sp, String ma);

    String deleteSanPham(String ma);
}
