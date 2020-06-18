package ntu.edu.vn.quangloc.controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import ntu.edu.vn.quangloc.model.AppDatabase;
import ntu.edu.vn.quangloc.model.DAOProduct;
import ntu.edu.vn.quangloc.model.Product;

public class CartControllerDB implements ICartController{

    AppDatabase database;
    List<Product> cartList = new ArrayList<>();
    DAOProduct daoProduct;

    public CartControllerDB(Context context) {
        database = Room.databaseBuilder(context,
                AppDatabase.class, "appdb")
                .allowMainThreadQueries()
                .build();
        daoProduct = database.getProductDAO();
    }
    @Override
    public List<Product> getAllProduct() {
        return daoProduct.getListProduct();
    }

    @Override
    public boolean addToCart(Product product) {
        if (cartList.contains(product)) return false;
        cartList.add(product);
        return true;
    }

    @Override
    public List<Product> getCart() {
        return cartList;
    }

    @Override
    public boolean addProduct(Product product) {
        daoProduct.insertProduct(product);
        return true;
    }
}
