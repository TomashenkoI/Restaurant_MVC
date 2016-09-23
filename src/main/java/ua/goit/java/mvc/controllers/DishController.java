package ua.goit.java.mvc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.mvc.Dao.DishDao;
import ua.goit.java.mvc.Model.Dish;
import ua.goit.java.mvc.Model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 7 on 04.09.2016.
 */
public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish(){

        Dish dish = new Dish();
        dish.setName("Plov");
        dish.setCategory(DishCategory.SECOND);
        dish.setPrice(5.00f);
        dish.setWeight(300f);

        Set<Dish> dishes = new HashSet<Dish>(dishDao.findAll());
        if (!dishes.contains(dish)) {
            dishDao.save(dish);
        }
    }

    @Transactional
    public List<Dish> getAllDishes(){
        return dishDao.findAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
