/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.DongSP;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IDongSPRepository {

    List<DongSP> getAllDongSP();

    DongSP getOneDongSP(String ma);

    boolean addDongSP(DongSP sp);

    boolean updateMauSac(DongSP sp, String ma);

    boolean removeDongSP(String ma);
}
