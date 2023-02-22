/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.GioHangChiTiet;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IGioHangChiTietRepository {

    List<String> getAllMaGioHang();

    List<String> getAllMaSanPham();

    List<GioHangChiTiet> getAllGioHang();

    boolean addGioHang(GioHangChiTiet gh);

    boolean updateGioHang(GioHangChiTiet gh, String ma);

    boolean deleteGioHang(String ma);
}
