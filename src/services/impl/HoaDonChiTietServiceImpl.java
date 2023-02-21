/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repositorys.HoaDonChiTietRepository;
import services.HoaDonChiTietService;
import viewmodels.HoaDonChiTietViewModel;

/**
 *
 * @author virus
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    HoaDonChiTietRepository repository = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTietViewModel> getAllHoaDon() {
        List<HoaDonChiTiet> list = repository.getAllHoaDon();
        List<HoaDonChiTietViewModel> listViewModel = new ArrayList<>();
        for (HoaDonChiTiet hd : list) {
            listViewModel.add(new HoaDonChiTietViewModel(hd.getIdHoaDon(),
                    hd.getIdChiTietSP(), hd.getSoLuong(), hd.getDonGia()));
        }
        return listViewModel;
    }

    @Override
    public HoaDonChiTietViewModel getOneHoaDon(String ma) {
        HoaDonChiTiet hd = repository.getOneHoaDon(ma);
        return new HoaDonChiTietViewModel(hd.getIdHoaDon(), hd.getIdChiTietSP(),
                hd.getSoLuong(), hd.getDonGia());
    }

    @Override
    public String addHoaDon(HoaDonChiTietViewModel hd) {
        boolean check = repository.addHoaDon(new HoaDonChiTiet(hd.getIdHoaDon(),
                hd.getIdChiTietSanPham(), hd.getSoLuong(), hd.getDonGia()));
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateHoaDon(HoaDonChiTietViewModel hd, String ma) {
        boolean check = repository.updateHoaDon(new HoaDonChiTiet(hd.getIdHoaDon(),
                hd.getIdChiTietSanPham(), hd.getSoLuong(), hd.getDonGia()), ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String removeHoaDon(String ma) {
        boolean check = repository.deleteHoaDon(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

}
