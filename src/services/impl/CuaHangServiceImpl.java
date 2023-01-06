/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.CuaHang;
import java.util.List;
import repositorys.CuaHangRepository;
import services.CuaHangService;

/**
 *
 * @author virus
 */
public class CuaHangServiceImpl implements CuaHangService {

    CuaHangRepository repository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAllCuaHang() {
        return repository.getAllCuaHang();
    }

    @Override
    public String addCuaHang(CuaHang ch) {
        boolean check = repository.addCuaHang(ch);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateCuaHang(CuaHang ch, String ma) {
        boolean check = repository.updateCuaHang(ch, ma);
        if (check == true) {
            return "Update successful";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String deleteCuaHang(String ma) {
        boolean check = repository.deleteCuaHang(ma);
        if (check == true) {
            return "Delete successful";
        } else {
            return "Delete failed";
        }
    }

}
