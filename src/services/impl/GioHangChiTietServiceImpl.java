/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import repositorys.IGioHangChiTietRepository;
import repositorys.impl.GioHangChiTietRepository;
import services.GioHangChiTietService;
import viewmodels.GioHangChiTietViewModel;

/**
 *
 * @author virus
 */
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    IGioHangChiTietRepository repository = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTietViewModel> getAllGioHang() {
        List<GioHangChiTiet> list = repository.getAllGioHang();
        List<GioHangChiTietViewModel> listViewModel = new ArrayList<>();
        for (GioHangChiTiet sp : list) {
            listViewModel.add(new GioHangChiTietViewModel(sp.getIdGioHang(), sp.getIdChiTietSP(), sp.getSoLuong()));
        }
        return listViewModel;
    }

    @Override
    public String addGioHang(GioHangChiTietViewModel gh) {
        boolean check = repository.addGioHang(new GioHangChiTiet(gh.getIdGioHang(),
                gh.getIdChiTietSP(), gh.getSoLuong(), null, null));
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateGioHang(GioHangChiTietViewModel gh, String ma) {
        boolean check = repository.updateGioHang(new GioHangChiTiet(gh.getIdGioHang(),
                gh.getIdChiTietSP(), gh.getSoLuong(), null, null), ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String removeGioHang(String ma) {
        boolean check = repository.deleteGioHang(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

    @Override
    public List<String> getAllMaGioHang() {
        return repository.getAllMaGioHang();
    }

    @Override
    public List<String> getAllMaSanPham() {
        return repository.getAllMaSanPham();
    }

}
