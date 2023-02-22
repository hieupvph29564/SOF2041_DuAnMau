/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.ChiTietSP;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IChiTietSPRepository {

    ChiTietSP getOneChiTietSP(String ma);

    List<String> getAllIdSP();

    List<String> getAllIdNSX();

    List<String> getAllIdMauSac();

    List<String> getAllIdDongSP();

    List<ChiTietSP> getAllChiTietSP();

    boolean addChiTietSP(ChiTietSP sp);

    boolean updateChiTietSP(ChiTietSP sp, String ma);

    boolean deleteChiTietSP(String ma);
}
