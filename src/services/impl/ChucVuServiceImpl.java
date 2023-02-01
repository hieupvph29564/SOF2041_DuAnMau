/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import java.util.List;
import repositorys.ChucVuRepository;
import services.ChucVuService;
import viewmodels.ChucVuViewModel;

/**
 *
 * @author virus
 */
public class ChucVuServiceImpl implements ChucVuService {

    ChucVuRepository repository = new ChucVuRepository();

    @Override
    public List<ChucVuViewModel> getAllChucVu() {
        return repository.getAllChucVu();
    }

    @Override
    public String addNChucVu(ChucVuViewModel cv) {
        boolean check = repository.addChucVu(cv);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateChucVu(ChucVuViewModel cv, String ma) {
        boolean check = repository.updateChucVu(cv, ma);
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
        return repository.getOneChucVu(ma);
    }

}
