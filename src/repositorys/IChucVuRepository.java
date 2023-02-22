/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author virus
 */
public interface IChucVuRepository {

    List<ChucVu> getAllChucVu();

    ChucVu getOneChucVu(String ma);

    boolean addChucVu(ChucVu cv);

    boolean updateChucVu(ChucVu cv, String ma);

    boolean deleteChucVu(String ma);
}
