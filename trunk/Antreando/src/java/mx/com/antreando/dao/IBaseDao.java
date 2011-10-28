/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.antreando.dao;

import java.util.List;
import mx.com.antreando.dto.IBaseDto;

/**
 *
 * @author Arizmendi
 */
public interface IBaseDao {
    
    List<IBaseDto> selectAll(); //seleccionamos por un dto
    IBaseDto selectById(Integer id);
    int insert(IBaseDto dto);
    int updateById(IBaseDto dto);
    //int updateByCriteria(IBaseDto dto, String criterio);
    int deleteById(Integer id);
    //int deleteByCriteria(String criterio);
    IBaseDto selectLogin(IBaseDto dto);
    
}
