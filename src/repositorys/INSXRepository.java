/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import domainmodels.NSX;
import java.util.List;

/**
 *
 * @author virus
 */
public interface INSXRepository {

    List<NSX> getAllNSX();

    NSX getOneNSX(String ma);

    boolean addNSX(NSX sp);

    boolean updateNSX(NSX sp, String ma);

    boolean removeNSX(String ma);
}
