/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IHoaDonChiTietRepository {

    List<String> getAllMaHoaDon();

    List<String> getAllMaChiTietSP();

    List<HoaDonChiTiet> getAllHoaDon();

    HoaDonChiTiet getOneHoaDon(String ma);

    boolean addHoaDon(HoaDonChiTiet gh);

    boolean updateHoaDon(HoaDonChiTiet gh, String ma);

    boolean deleteHoaDon(String ma);
}
