/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.MauSac;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IMauSacRepository {

    List<MauSac> getAllMauSac();

    MauSac getOneMauSac(String ma);

    boolean addMauSac(MauSac sp);

    boolean updateMauSac(MauSac sp, String ma);

    boolean removeMauSac(String ma);
}
