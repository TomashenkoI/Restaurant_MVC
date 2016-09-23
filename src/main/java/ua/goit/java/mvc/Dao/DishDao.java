package ua.goit.java.mvc.Dao;

import ua.goit.java.mvc.Model.Dish;

import java.util.List;

/**
 * Created by 7 on 04.09.2016.
 */
public interface DishDao {

    List<Dish> findAll();

    void save(Dish dish);

}
