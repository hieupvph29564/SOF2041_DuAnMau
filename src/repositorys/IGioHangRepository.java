/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.GioHang;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IGioHangRepository {

    List<String> getAllIdKH();

    List<GioHang> getAllGioHang();

    boolean addGioHang(GioHang gh);

    boolean updateGioHang(GioHang gh, String ma);

    boolean deleteGioHang(String ma);
}
