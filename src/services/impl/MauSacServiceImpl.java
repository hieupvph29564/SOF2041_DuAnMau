/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.MauSac;
import java.util.ArrayList;
import java.util.List;
import repositorys.MauSacRepository;
import services.MauSacService;
import viewmodels.MauSacViewModel;

/**
 *
 * @author virus
 */
public class MauSacServiceImpl implements MauSacService {

    MauSacRepository repository = new MauSacRepository();

    @Override
    public List<MauSacViewModel> getAllMauSac() {
        List<MauSacViewModel> lists = new ArrayList<>();
        for (MauSac ms : repository.getAllMauSac()) {
            lists.add(new MauSacViewModel(ms.getMa(), ms.getTen()));
        }
        return lists;
    }

    @Override
    public MauSacViewModel getOneMauSac(String ma) {
        MauSac ms = repository.getOneMauSac(ma);
        return new MauSacViewModel(ms.getMa(), ms.getTen());
    }

    @Override
    public String addMauSac(MauSacViewModel ms) {
        MauSac msDomain = new MauSac();
        msDomain.setMa(ms.getMa());
        msDomain.setTen(ms.getTen());
        boolean check = repository.addMauSac(msDomain);
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateMauSac(MauSacViewModel ms, String ma) {
        MauSac msDomain = new MauSac();
        msDomain.setMa(ms.getMa());
        msDomain.setTen(ms.getTen());
        boolean check = repository.updateMauSac(msDomain, ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String deleteMauSac(String ma) {
        boolean check = repository.removeMauSac(ma);
        return check == true ? "Remove thành công" : "Remove thất bại";
    }

}
