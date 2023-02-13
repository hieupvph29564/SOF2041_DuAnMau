/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.MauSacViewModel;

/**
 *
 * @author virus
 */
public interface MauSacService {

    List<MauSacViewModel> getAllMauSac();

    MauSacViewModel getOneMauSac(String ma);

    String addMauSac(MauSacViewModel ms);

    String updateMauSac(MauSacViewModel ms, String ma);

    String deleteMauSac(String ma);
}
