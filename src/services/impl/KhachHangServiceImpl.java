/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.KhachHang;
import java.util.ArrayList;
import java.util.List;
import repositorys.KhachHangRepository;
import services.KhachHangService;
import viewmodels.KhachHangViewModel;

/**
 *
 * @author virus
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository repository;

    public KhachHangServiceImpl() {
        repository = new KhachHangRepository();
    }

    @Override
    public List<KhachHangViewModel> getAllKhachHang() {
        List<KhachHangViewModel> listKhachHangViewModels = new ArrayList<>();
        for (KhachHang kh : repository.getAllKhachHang()) {
            listKhachHangViewModels.add(new KhachHangViewModel(kh.getMa(), kh.getTen(),
                    kh.getTenDem(), kh.getHo()));
        }
        return listKhachHangViewModels;
    }

    @Override
    public KhachHangViewModel getOneKhachHang(String ma) {
        KhachHang khDomain = repository.getOneKhachHang(ma);
        return new KhachHangViewModel(khDomain.getMa(), khDomain.getTen(), khDomain.getTenDem(),
                khDomain.getHo());
    }

    @Override
    public String addKhachHang(KhachHangViewModel kh) {
        KhachHang khDomain = new KhachHang();
        khDomain.setMa(kh.getMa());
        khDomain.setTen(kh.getTen());
        khDomain.setTenDem(kh.getTenDem());
        khDomain.setHo(kh.getHo());
        boolean check = repository.addKhachHang(khDomain);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateKhachHang(KhachHangViewModel kh, String ma) {
        KhachHang khDomain = new KhachHang();
        khDomain.setMa(kh.getMa());
        khDomain.setTen(kh.getTen());
        khDomain.setTenDem(kh.getTenDem());
        khDomain.setHo(kh.getHo());
        boolean check = repository.updateKhachHang(khDomain, ma);
        if (check == true) {
            return "Update successful";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String removeKhachHang(String ma) {
        boolean check = repository.removeKhachHang(ma);
        if (check == true) {
            return "Remove successful";
        } else {
            return "Remove failed";
        }
    }

}
