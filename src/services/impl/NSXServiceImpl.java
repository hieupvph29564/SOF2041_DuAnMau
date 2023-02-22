/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.NSX;
import java.util.ArrayList;
import java.util.List;
import repositorys.INSXRepository;
import repositorys.impl.NSXRepository;
import services.NSXService;
import viewmodels.NSXViewModel;

/**
 *
 * @author virus
 */
public class NSXServiceImpl implements NSXService {

    INSXRepository repository = new NSXRepository();

    @Override
    public List<NSXViewModel> getAllNSX() {
        List<NSXViewModel> list = new ArrayList<>();
        for (NSX sp : repository.getAllNSX()) {
            list.add(new NSXViewModel(sp.getMa(), sp.getTen()));
        }
        return list;
    }

    @Override
    public NSXViewModel getOneNSX(String ma) {
        NSX nsx = repository.getOneNSX(ma);
        return new NSXViewModel(nsx.getMa(), nsx.getTen());
    }

    @Override
    public String addNSX(NSXViewModel nsx) {
        NSX spDomain = new NSX();
        spDomain.setMa(nsx.getMa());
        spDomain.setTen(nsx.getTen());
        boolean check = repository.addNSX(spDomain);
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateNSX(NSXViewModel nsx, String ma) {
        NSX spDomain = new NSX();
        spDomain.setMa(nsx.getMa());
        spDomain.setTen(nsx.getTen());
        boolean check = repository.updateNSX(spDomain, ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteNSX(String ma) {
        boolean check = repository.removeNSX(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

}
