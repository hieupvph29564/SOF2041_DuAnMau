/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import repositorys.NhanVienRepository;
import services.NhanVienService;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author virus
 */
public class NhanVienServiceImpl implements NhanVienService {

    NhanVienRepository repository = new NhanVienRepository();

    @Override
    public List<NhanVienViewModel> getAllNhanVien() {
        return repository.getAllNhanVien();
    }

    @Override
    public String addNhanVien(NhanVienViewModel nv) {
        boolean check = repository.addNhanVien(nv);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateNhanVien(NhanVienViewModel nv, String ma) {
        boolean check = repository.updateNhanVien(nv, ma);
        if (check == true) {
            return "Update successful";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String deleteNhanVien(String ma) {
        boolean check = repository.deleteNhanVien(ma);
        if (check == true) {
            return "Delete successful";
        } else {
            return "Delete failed";
        }
    }

    @Override
    public NhanVienViewModel getOne(String ma) {
        return repository.getOne(ma);
    }

}
