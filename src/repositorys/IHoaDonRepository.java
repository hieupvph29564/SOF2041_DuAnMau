/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.HoaDon;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IHoaDonRepository {

    List<HoaDon> getAllHoaDon();

    HoaDon getOneHoaDon(String ma);

    boolean addHoaDon(HoaDon hd);

    boolean updateHoaDon(HoaDon hd, String ma);

    boolean deleteHoaDon(String ma);
}
