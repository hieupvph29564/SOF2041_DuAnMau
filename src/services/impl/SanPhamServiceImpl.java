/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.SanPham;
import java.util.ArrayList;
import java.util.List;
import repositorys.SanPhamRepository;
import services.SanPhamService;
import viewmodels.SanPhamViewModel;

/**
 *
 * @author virus
 */
public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository repository = new SanPhamRepository();

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        List<SanPhamViewModel> list = new ArrayList<>();
        for (SanPham sp : repository.getAllSanPHam()) {
            list.add(new SanPhamViewModel(sp.getMa(), sp.getTen()));
        }
        return list;
    }

    @Override
    public SanPhamViewModel getOneSanPham(String ma) {
        SanPham sp = repository.getOneSanPHam(ma);
        return new SanPhamViewModel(sp.getMa(), sp.getTen());
    }

    @Override
    public String addSanPham(SanPhamViewModel sp) {
        SanPham spDomain = new SanPham();
        spDomain.setMa(sp.getMa());
        spDomain.setTen(sp.getTen());
        boolean check = repository.addSanPham(spDomain);
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateSanPham(SanPhamViewModel sp, String ma) {
        SanPham spDomain = new SanPham();
        spDomain.setMa(sp.getMa());
        spDomain.setTen(sp.getTen());
        boolean check = repository.updateSanPham(spDomain, ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteSanPham(String ma) {
        boolean check = repository.removeSanPham(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

}
