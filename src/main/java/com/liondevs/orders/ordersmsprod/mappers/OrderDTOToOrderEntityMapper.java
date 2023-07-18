package com.liondevs.orders.ordersmsprod.mappers;

import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import com.liondevs.orders.ordersmsprod.persistence.entities.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.*;


@Component
public class OrderDTOToOrderEntityMapper implements iMapper<OrderDTO, OrderEntity>{
    private static final  double iva = 19;
    private   Map<String, Double> validateTotal(List<Product> productList){
        Map<String, Double> totals = new HashMap<>();
        double total;
        double subTotal = 0;
        double totalTaxes  = 0;

        for (Product product : productList){
            double price =  product.getPrice();
            int quantity = product.getQuantity();
            totalTaxes = price * iva / 100;
            subTotal+=price*quantity;

        }
        total = subTotal + totalTaxes;
        totals.put("total",total );
        totals.put("subtotal",subTotal );
        totals.put("iva",totalTaxes );
        return  totals;
    }
    List<Product> evaluateProductTaxes(List<Product> productList){
        return new ArrayList<>(
                productList.stream().peek(product -> {
                    double tax = product.getPrice() * iva / 100;
                    product.setIva(tax);
                }).toList()
        );


    }

    @Override
    public OrderEntity map(OrderDTO orderDTO) {
        Type objectType = new TypeToken<OrderEntity>() {}.getType();
        OrderEntity  returnValue = new ModelMapper().map(orderDTO, objectType);
        List<Product> products = returnValue.getProducts();
        Map<String, Double> totals = validateTotal(products);
        returnValue.setId(UUID.randomUUID().toString());
        returnValue.setPlaceId(orderDTO.getPlaceId());
        returnValue.setRiderId(orderDTO.getRiderId());
        returnValue.setIva(totals.get("iva"));
        returnValue.setSubtotal(totals.get("subtotal"));
        returnValue.setTotal(totals.get("total"));
        returnValue.setProducts(evaluateProductTaxes(products));
        returnValue.setState(OrderStates.CREATED);
        return  returnValue;
    }
}
