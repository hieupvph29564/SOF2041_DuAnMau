/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.CuaHang;
import java.util.ArrayList;
import java.util.List;
import repositorys.ICuaHangRepository;
import repositorys.impl.CuaHangRepository;
import services.CuaHangService;
import viewmodels.CuaHangViewModel;

/**
 *
 * @author virus
 */
public class CuaHangServiceImpl implements CuaHangService {

    ICuaHangRepository repository = new CuaHangRepository();
    List<CuaHang> listCuaHangDomains = new ArrayList<>();

    @Override
    public List<CuaHangViewModel> getAllCuaHang() {
        listCuaHangDomains = repository.getAllCuaHang();
        List<CuaHangViewModel> listCuaHangViewModels = new ArrayList<>();
        for (CuaHang ch : listCuaHangDomains) {
            listCuaHangViewModels.add(new CuaHangViewModel(ch.getMa(), ch.getTen(), ch.getDiaChi(), ch.getThanhPho()));
        }
        return listCuaHangViewModels;
    }

    @Override
    public String addCuaHang(CuaHangViewModel ch) {
        CuaHang chDomain = new CuaHang();
        chDomain.setMa(ch.getMa());
        chDomain.setTen(ch.getTen());
        chDomain.setDiaChi(ch.getDiaChi());
        chDomain.setThanhPho(ch.getThanhPho());
        boolean check = repository.addCuaHang(chDomain);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateCuaHang(CuaHangViewModel ch, String ma) {
        CuaHang chDomain = new CuaHang();
        chDomain.setMa(ch.getMa());
        chDomain.setTen(ch.getTen());
        chDomain.setDiaChi(ch.getDiaChi());
        chDomain.setThanhPho(ch.getThanhPho());
        boolean check = repository.updateCuaHang(chDomain, ma);
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
        CuaHang chDomain = repository.getOneCuaHang(ma);
        CuaHangViewModel chViewModel = new CuaHangViewModel(chDomain.getMa(), chDomain.getTen(), chDomain.getDiaChi(), chDomain.getThanhPho());
        return chViewModel;
    }

}
