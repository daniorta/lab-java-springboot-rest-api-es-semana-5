package org.ironhack.labsemana_6springboot.controller;

import org.ironhack.labsemana_6springboot.exception.InvalidPriceRangeException;
import org.ironhack.labsemana_6springboot.exception.MissingApiKeyException;
import org.ironhack.labsemana_6springboot.model.Product;
import org.ironhack.labsemana_6springboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    //Neceitamos la inyeccion de dependencia del servicio por constructor
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Método que verifica el encabezado API-Key
    private void checkApiKey(String apiKey) {
        if (apiKey == null || !apiKey.equals("123456")) {
            throw new MissingApiKeyException();
        }
    }

    //Crear producto
    @PostMapping
    public Product newProduct(@RequestHeader(value = "Api-Key") String apiKey,
                              @RequestBody Product product){
        checkApiKey(apiKey);
        return productService.createProduct(product);
    }

    //listar todos los productos
    @GetMapping
    public List<Product> getAllProduct(@RequestHeader(value = "API-Key") String apiKey){
        checkApiKey(apiKey);
        return productService.getAllProduct();
    }

    //Filtrar producto po nombre
    @GetMapping("/{name}")
    public Product searchProduct(@RequestHeader(value = "API-Key") String apiKey ,@PathVariable String name){
        checkApiKey(apiKey);
        return productService.filterProductName(name);
    }

    //Actualiza un producto
    @PutMapping("/{name}")//en postman le tenemos que pasar el nombre como variable
    public Product updateProduct(@RequestHeader(value = "API-Key") String apiKey ,
                                 @PathVariable String name,
                                 @RequestBody Product product){
        checkApiKey(apiKey);
        return productService.updateProduct(name, product);
    }

    //Eliminar un producto
    @DeleteMapping("/{name}")
    public void deleteProduct(@RequestHeader(value = "API-Key") String apiKey,
                              @PathVariable String name){
        checkApiKey(apiKey);
        productService.deleteProduct(name);
    }

    @GetMapping("/category/{category}")
    public  List<Product> getProductCategory(@RequestHeader(value = "API-Key") String apiKey,
                                             @PathVariable String category){
        checkApiKey(apiKey);
        return productService.getProductCategory(category);
    }

    @GetMapping("/price")
    //@RequestParam --> extrae parametros desde nuestra url
    public List<Product> filterProductPrice(@RequestHeader(value = "API-Key") String apiKey,
                                            @RequestParam(required = false) Integer price,
                                            @RequestParam(defaultValue = "0") int minPrice,
                                            @RequestParam int maxPrice){
        checkApiKey(apiKey);

        //validadion del rango de precios
        if(minPrice > maxPrice){
            throw new InvalidPriceRangeException();
        }
        return productService.filterProductPrice(price, minPrice, maxPrice);
    }



}
