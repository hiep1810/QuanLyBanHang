/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author hoang minh duong
 */
public interface IDAO <T>{
    List<T> getAll();
    public List<T> timTheoTen(String s);
    public T timTheoMa(int ma);
    public T themMoi(T t);
    public T capNhat(T t);
    public boolean xoa(T t);

    public T hienDongClick(int row);
}
