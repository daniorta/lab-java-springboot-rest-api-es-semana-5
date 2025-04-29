package org.ironhack.labsemana_6springboot.service;

import org.ironhack.labsemana_6springboot.exception.ProductNotFoundException;
import org.ironhack.labsemana_6springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> productsList = new ArrayList<>();

    //Crear producto
    public Product createProduct(Product product){
        productsList.add(product);
        return product;
    }

    //listar todos los productos
    public List<Product> getAllProduct(){
        return productsList;
    }

    //Filtrar producto po nombre
    public Product filterProductName(String name){

        for(Product product : productsList){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        throw new ProductNotFoundException(name); //nos retorna el mensaje de error que hemos creado
    }

    //Actualiza un producto
    public Product updateProduct(String name, Product product ){
        //Recordar que ya tenemos un metodo que busca por nombre
        Product productFromArrayList = filterProductName(name);

        if (productFromArrayList != null) {
            productFromArrayList.setName(product.getName());
            productFromArrayList.setPrice(product.getPrice());
            productFromArrayList.setCategory(product.getCategory());
            productFromArrayList.setQuantity(product.getQuantity());
            // Opcionalmente, aquí podrías agregar más lógica, como guardar el estado actualizado
        }
        return productFromArrayList;
    }

    //Eliminar un producto.
    public void deleteProduct(String name){

        for( int i = 0; i < productsList.size(); i++) {
            Product product = productsList.get(i);

            if (product.getName().equalsIgnoreCase(name)) {
                productsList.remove(i);
                break;
            }
        }
    }

    //Obtener productos pr categorias.
    public List<Product>  getProductCategory(String category){
        List<Product> newProduct = new ArrayList<>();

        for(Product product : productsList){
            boolean searchCategory = category == null || product.getCategory().equalsIgnoreCase(category);

            if(searchCategory){
                newProduct.add(product);
            }
        }
        return newProduct;
    }

    public List<Product> filterProductPrice(Integer price, int minPrice, int maxPrice ){
        List<Product> newProduct = new ArrayList<>();

        for(Product product : productsList){

            boolean matchesPrice = price == null || product.getPrice().equals(price);
            boolean matchesPriceRange =  product.getPrice() >= minPrice && product.getPrice() <= maxPrice;

           if( matchesPrice && matchesPriceRange){
               newProduct.add(product);
           }
        }
        return newProduct;
    }




    //Obtener productos por rango de precios.







}
