/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.df.dao;

import java.util.List;

/**
 *
 * @author LAKHE
 */
public interface GenericDAO<T> {
    boolean insert(T t);
    boolean update(T t);
    boolean delete(int id);
    T getById(int id);
    List<T> getAll();
}
