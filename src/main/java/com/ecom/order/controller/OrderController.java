package com.ecom.order.controller;

import com.ecom.order.dto.OrderDTO;
import com.ecom.order.entity.Order;
import com.ecom.order.service.OrderService;
import com.ecom.order.utilities.EntityDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOrders() {
        List<Order> orders = orderService.getOrders();

        ModelMapper modelMapper = new ModelMapper();
        List<OrderDTO> orderDTOS = orders.stream().map(entity -> modelMapper.map(entity, OrderDTO.class)).toList();

        return orderDTOS.toString();
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);

        EntityDTOConverter entityDTOConverter = new EntityDTOConverter();
        return entityDTOConverter.entityToDTO(order).toString();
    }

    @PutMapping("/update")
    public HttpStatus updateOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return HttpStatus.OK;

    }


    @PostMapping("/post")
    public HttpStatus addOrder(@RequestBody OrderDTO orderDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Order order = modelMapper.map(orderDTO, Order.class);
        orderService.addOrder(order);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/delete/{orderId}")
    public HttpStatus deleteCustomerById(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return HttpStatus.OK;
    }
}
