/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.DongSP;
import java.util.ArrayList;
import java.util.List;
import repositorys.IDongSPRepository;
import repositorys.impl.DongSPRepository;
import services.DongSPService;
import viewmodels.DongSPViewModel;

/**
 *
 * @author virus
 */
public class DongSPServiceImpl implements DongSPService {

    IDongSPRepository repository = new DongSPRepository();

    @Override
    public List<DongSPViewModel> getAllDongSP() {
        List<DongSPViewModel> lists = new ArrayList<>();
        for (DongSP ms : repository.getAllDongSP()) {
            lists.add(new DongSPViewModel(ms.getMa(), ms.getTen()));
        }
        return lists;
    }

    @Override
    public DongSPViewModel getOneDongSP(String ma) {
        DongSP ms = repository.getOneDongSP(ma);
        return new DongSPViewModel(ms.getMa(), ms.getTen());
    }

    @Override
    public String addDongSP(DongSPViewModel sp) {
        DongSP dsp = new DongSP();
        dsp.setMa(sp.getMa());
        dsp.setTen(sp.getTen());
        boolean check = repository.addDongSP(dsp);
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateDongSP(DongSPViewModel sp, String ma) {
        DongSP dsp = new DongSP();
        dsp.setMa(sp.getMa());
        dsp.setTen(sp.getTen());
        boolean check = repository.updateMauSac(dsp, ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteDongSP(String ma) {
        boolean check = repository.removeDongSP(ma);
        return check == true ? "Remove thành công" : "Remove thất bại";
    }

}
