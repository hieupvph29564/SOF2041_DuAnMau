/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repositorys.INhanVienRepository;
import repositorys.impl.NhanVienRepository;
import services.NhanVienService;
import viewmodels.NhanVienViewModel;

/**
 *
 * @author virus
 */
public class NhanVienServiceImpl implements NhanVienService {

    INhanVienRepository repository;
    List<NhanVienViewModel> listNhanVienViewModels;
    List<NhanVien> listNhanVienDomains;
    public NhanVienServiceImpl() {
        repository = new NhanVienRepository(); 
        listNhanVienDomains = new ArrayList<>();
    }

    @Override
    public List<NhanVienViewModel> getAllNhanVien() {
        listNhanVienViewModels = new ArrayList<>();
        listNhanVienDomains = repository.getAllNhanVien();
        for (NhanVien nv : listNhanVienDomains) {
            listNhanVienViewModels.add(new NhanVienViewModel(nv.getMa(), nv.getHo(), nv.getTenDem(), nv.getTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getTrangThai()));
        }
        return listNhanVienViewModels;
    }

    @Override
    public String addNhanVien(NhanVienViewModel nv) {
        NhanVien nvDomain = new NhanVien();
        nvDomain.setMa(nv.getMa());
        nvDomain.setHo(nv.getHo());
        nvDomain.setTenDem(nv.getTenDem());
        nvDomain.setTen(nv.getTen());
        nvDomain.setGioiTinh(nv.getGioiTinh());
        nvDomain.setDiaChi(nv.getDiaChi());
        nvDomain.setTrangThai(nv.getTrangThai());
        boolean check = repository.addNhanVien(nvDomain);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateNhanVien(NhanVienViewModel nv, String ma) {
        NhanVien nvDomain = new NhanVien();
        nvDomain.setMa(nv.getMa());
        nvDomain.setHo(nv.getHo());
        nvDomain.setTenDem(nv.getTenDem());
        nvDomain.setTen(nv.getTen());
        nvDomain.setGioiTinh(nv.getGioiTinh());
        nvDomain.setDiaChi(nv.getDiaChi());
        nvDomain.setTrangThai(nv.getTrangThai());
        boolean check = repository.updateNhanVien(nvDomain, ma);
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
        NhanVien nvDomain = repository.getOne(ma);
        NhanVienViewModel nv = new NhanVienViewModel(nvDomain.getMa(), nvDomain.getHo(), nvDomain.getTenDem(), nvDomain.getTen(), nvDomain.getGioiTinh(), nvDomain.getDiaChi(), nvDomain.getTrangThai());
        return nv;
    }

}
