/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainmodels.ChiTietSP;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repositorys.IChiTietSPRepository;
import repositorys.impl.ChiTietSPRepository;
import services.ChiTietSPService;
import viewmodels.ChiTietSPViewModel;

/**
 *
 * @author virus
 */
public class ChiTietSPServiceImpl implements ChiTietSPService {

    IChiTietSPRepository repository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSPViewModel> getAllChiTietSP() {
        List<ChiTietSP> list = repository.getAllChiTietSP();
        List<ChiTietSPViewModel> listViewModel = new ArrayList<>();
        for (ChiTietSP sp : list) {
            listViewModel.add(new ChiTietSPViewModel(sp.getIdSP(),
                    sp.getIdNSX(), sp.getIdMauSac(), sp.getIdDongSP(), sp.getSoLuongTon()));
        }
        return listViewModel;
    }

    @Override
    public ChiTietSPViewModel getOneChiTietSP(String ma) {
        ChiTietSP ctDomain = repository.getOneChiTietSP(ma);
        return new ChiTietSPViewModel(ctDomain.getIdSP(),
                ctDomain.getIdNSX(), ctDomain.getIdMauSac(), ctDomain.getIdDongSP(),
                ctDomain.getSoLuongTon());
    }

    @Override
    public String addChiTietSP(ChiTietSPViewModel ctsp) {
        UUID uuid = UUID.randomUUID();
        boolean check = repository.addChiTietSP(new ChiTietSP(uuid.toString(), ctsp.getIdSP(),
                ctsp.getIdNSX(), ctsp.getIdMauSac(), ctsp.getIdDongSP(), 0, null, ctsp.getSoLuongTon(), null, null));
        return check == true ? "Add thành công" : "Add thất bại";
    }

    @Override
    public String updateChiTietSP(ChiTietSPViewModel ctsp, String ma) {
        UUID uuid = UUID.randomUUID();
        boolean check = repository.updateChiTietSP(new ChiTietSP(uuid.toString(), ctsp.getIdSP(),
                ctsp.getIdNSX(), ctsp.getIdMauSac(), ctsp.getIdDongSP(), 0, null, ctsp.getSoLuongTon(), null, null), ma);
        return check == true ? "Update thành công" : "Update thất bại";
    }

    @Override
    public String removeChiTietSP(String ma) {
        boolean check = repository.deleteChiTietSP(ma);
        return check == true ? "Delete thành công" : "Delete thất bại";
    }

    @Override
    public List<String> getAllIdSP() {
        return repository.getAllIdSP();
    }

    @Override
    public List<String> getAllIdNSX() {
        return repository.getAllIdNSX();
    }

    @Override
    public List<String> getAllIdMauSac() {
        return repository.getAllIdMauSac();
    }

    @Override
    public List<String> getAllIdDongSP() {
        return repository.getAllIdDongSP();
    }

}
