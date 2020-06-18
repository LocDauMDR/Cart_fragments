package ntu.edu.vn.quangloc.controller;

import java.util.List;

import ntu.edu.vn.quangloc.model.Product;

public interface ICartController {
    public List<Product> getAllProduct();
    public boolean addToCart(Product product);
    public List<Product> getCart();
    public boolean addProduct(Product product);
}
