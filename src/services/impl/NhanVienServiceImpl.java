/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NhanVien;
import java.util.List;
import repositorys.NhanVienRepository;
import services.NhanVienService;

/**
 *
 * @author virus
 */
public class NhanVienServiceImpl implements NhanVienService {

    NhanVienRepository repository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAllNhanVien() {
        return repository.getAllNhanVien();
    }

    @Override
    public String addNhanVien(NhanVien nv) {
        boolean check = repository.addNhanVien(nv);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateNhanVien(NhanVien nv, String ma) {
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

}
