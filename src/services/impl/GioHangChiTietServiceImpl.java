/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.GioHangChiTiet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repositorys.GioHangChiTietRepository;
import services.GioHangChiTietService;
import viewmodels.GioHangChiTietViewModel;

/**
 *
 * @author virus
 */
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    GioHangChiTietRepository repository = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTietViewModel> getAllGioHang() {
        List<GioHangChiTiet> list = repository.getAllGioHang();
        List<GioHangChiTietViewModel> listViewModel = new ArrayList<>();
        for (GioHangChiTiet sp : list) {
            listViewModel.add(new GioHangChiTietViewModel(sp.getIdGioHang(),
                    sp.getIdChiTietSP(), sp.getSoLuong(), sp.getDonGia()));
        }
        return listViewModel;
    }

    @Override
    public GioHangChiTietViewModel getOneGioHang(String ma) {
        GioHangChiTiet ctDomain = repository.GetOneGioHang(ma);
        return new GioHangChiTietViewModel(ctDomain.getIdGioHang(),
                ctDomain.getIdChiTietSP(), ctDomain.getSoLuong(), ctDomain.getDonGia());
    }

    @Override
    public String addGioHang(GioHangChiTietViewModel gh) {
        boolean check = repository.addGioHang(new GioHangChiTiet(gh.getIdGioHang(),
                gh.getIdChiTietSP(), gh.getSoLuong(), gh.getDonGia(), null));
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateGioHang(GioHangChiTietViewModel gh, String ma) {
        boolean check = repository.updateGioHang(new GioHangChiTiet(gh.getIdGioHang(),
                gh.getIdChiTietSP(), gh.getSoLuong(), gh.getDonGia(), null), ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String removeGioHang(String ma) {
        boolean check = repository.deleteGioHang(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

}
