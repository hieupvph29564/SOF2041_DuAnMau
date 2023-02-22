/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.GioHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.IGioHangRepository;
import repositorys.impl.GioHangRepository;
import services.GioHangService;
import viewmodels.GioHangViewModel;

/**
 *
 * @author virus
 */
public class GioHangServiceImpl implements GioHangService {

    IGioHangRepository repository = new GioHangRepository();

    @Override
    public List<GioHangViewModel> getAllGioHang() {
        List<GioHang> list = repository.getAllGioHang();
        List<GioHangViewModel> listViewModel = new ArrayList<>();
        for (GioHang gh : list) {
            listViewModel.add(new GioHangViewModel(gh.getMa(), gh.getIdKH(),
                    gh.getTenNguoiNhan(), gh.getTinhTrang()));
        }
        return listViewModel;
    }

    @Override
    public String addGioHang(GioHangViewModel gh) {
        UUID uuid = UUID.randomUUID();
        boolean check = repository.addGioHang(new GioHang(uuid.toString(),
                gh.getIdKH(), uuid.toString(), gh.getMa(), null,
                null, gh.getTenNguoiNhan(), null, null, gh.getTinhTrang()));;
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateGioHang(GioHangViewModel gh, String ma) {
        UUID uuid = UUID.randomUUID();
        boolean check = repository.updateGioHang(new GioHang(uuid.toString(),
                gh.getIdKH(), uuid.toString(), gh.getMa(), null,
                null, gh.getTenNguoiNhan(), null, null, gh.getTinhTrang()), ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteGioHang(String ma) {
        boolean check = repository.deleteGioHang(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

    @Override
    public List<String> getAllIDKH() {
        return repository.getAllIdKH();
    }

}
