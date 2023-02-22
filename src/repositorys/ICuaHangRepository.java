/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.CuaHang;
import java.util.List;

/**
 *
 * @author virus
 */
public interface ICuaHangRepository {

    List<CuaHang> getAllCuaHang();

    CuaHang getOneCuaHang(String ma);

    boolean addCuaHang(CuaHang ch);

    boolean updateCuaHang(CuaHang ch, String ma);

    boolean deleteCuaHang(String ma);
}
