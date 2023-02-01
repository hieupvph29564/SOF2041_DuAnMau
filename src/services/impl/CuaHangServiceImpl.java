/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import repositorys.CuaHangRepository;
import services.CuaHangService;
import viewmodels.CuaHangViewModel;

/**
 *
 * @author virus
 */
public class CuaHangServiceImpl implements CuaHangService {

    CuaHangRepository repository = new CuaHangRepository();

    @Override
    public List<CuaHangViewModel> getAllCuaHang() {
        return repository.getAllCuaHang();
    }

    @Override
    public String addCuaHang(CuaHangViewModel ch) {
        boolean check = repository.addCuaHang(ch);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateCuaHang(CuaHangViewModel ch, String ma) {
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

    @Override
    public CuaHangViewModel getOneCuaHang(String ma) {
        return repository.getOneCuaHang(ma);
    }

}
