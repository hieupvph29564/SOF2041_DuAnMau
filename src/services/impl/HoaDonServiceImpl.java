/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.HoaDon;
import java.util.ArrayList;
import java.util.List;
import repositorys.HoaDonRepository;
import services.HoaDonService;
import viewmodels.HoaDonViewModel;

/**
 *
 * @author virus
 */
public class HoaDonServiceImpl implements HoaDonService {

    HoaDonRepository repository = new HoaDonRepository();

    @Override
    public List<HoaDonViewModel> getAllHoaDon() {
        List<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDon sp : repository.getAllHoaDon()) {
            list.add(new HoaDonViewModel(sp.getMa(), sp.getTinhTrang()));
        }
        return list;
    }

    @Override
    public HoaDonViewModel getOneHoaDon(String ma) {
        HoaDon hd = repository.getOneHoaDon(ma);
        return new HoaDonViewModel(hd.getMa(), hd.getTinhTrang());
    }

    @Override
    public String addHoaDon(HoaDonViewModel hd) {
        HoaDon hdDomain = new HoaDon();
        hdDomain.setMa(hd.getMa());
        hdDomain.setTinhTrang(hd.getTinhTrang());
        boolean check = repository.addHoaDon(hdDomain);
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateHoaDon(HoaDonViewModel hd, String ma) {
        HoaDon hdDomain = new HoaDon();
        hdDomain.setMa(hd.getMa());
        hdDomain.setTinhTrang(hd.getTinhTrang());
        boolean check = repository.updateHoaDon(hdDomain, ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteHoaDon(String ma) {
        boolean check = repository.deleteHoaDon(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

}
