/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChucVu;
import java.util.ArrayList;
import java.util.List;
import repositorys.IChucVuRepository;
import repositorys.impl.ChucVuRepository;
import services.ChucVuService;
import viewmodels.ChucVuViewModel;

/**
 *
 * @author virus
 */
public class ChucVuServiceImpl implements ChucVuService {

    IChucVuRepository repository = new ChucVuRepository();
    List<ChucVu> listChucVuDomain = new ArrayList<>();

    @Override
    public List<ChucVuViewModel> getAllChucVu() {
        listChucVuDomain = repository.getAllChucVu();
        List<ChucVuViewModel> listChucVuViewModels = new ArrayList<>();
        for (ChucVu cv : listChucVuDomain) {
            listChucVuViewModels.add(new ChucVuViewModel(cv.getMa(), cv.getTen()));
        }
        return listChucVuViewModels;
    }

    @Override
    public String addNChucVu(ChucVuViewModel cv) {
        ChucVu cvDomain = new ChucVu();
        cvDomain.setMa(cv.getMa());
        cvDomain.setTen(cv.getTen());
        boolean check = repository.addChucVu(cvDomain);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateChucVu(ChucVuViewModel cv, String ma) {
        ChucVu cvDomain = new ChucVu();
        cvDomain.setMa(cv.getMa());
        cvDomain.setTen(cv.getTen());
        boolean check = repository.updateChucVu(cvDomain, ma);
        if (check == true) {
            return "Update successful";
        } else {
            return "Update failed";
        }
    }

    @Override
    public String deleteChucVu(String ma) {
        boolean check = repository.deleteChucVu(ma);
        if (check == true) {
            return "Delete successful";
        } else {
            return "Delete failed";
        }
    }

    @Override
    public ChucVuViewModel getOneChucVu(String ma) {
        ChucVu cvDomain = repository.getOneChucVu(ma);
        ChucVuViewModel chucVuViewModel = new ChucVuViewModel(cvDomain.getMa(), cvDomain.getTen());
        return chucVuViewModel;
    }

}
