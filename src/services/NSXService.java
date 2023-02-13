/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import viewmodels.NSXViewModel;

/**
 *
 * @author virus
 */
public interface NSXService {

    List<NSXViewModel> getAllNSX();

    NSXViewModel getOneNSX(String ma);

    String addNSX(NSXViewModel nsx);

    String updateNSX(NSXViewModel nsx, String ma);

    String deleteNSX(String ma);
}
