/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChucVu;
import java.util.List;
import repositorys.ChucVuRepository;
import services.ChucVuService;

/**
 *
 * @author virus
 */
public class ChucVuServiceImpl implements ChucVuService {

    ChucVuRepository repository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAllChucVu() {
        return repository.getAllChucVu();
    }

    @Override
    public String addNChucVu(ChucVu cv) {
        boolean check = repository.addChucVu(cv);
        if (check == true) {
            return "Add successful";
        } else {
            return "Add failed";
        }
    }

    @Override
    public String updateChucVu(ChucVu cv, String ma) {
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

}
