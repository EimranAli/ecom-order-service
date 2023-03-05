package com.ecom.order.utilities;

import com.ecom.order.dto.OrderDTO;
import com.ecom.order.entity.Order;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EntityDTOConverter {

    public OrderDTO entityToDTO(Order order) {
        ModelMapper mapper = new ModelMapper();

        OrderDTO orderDTO = mapper.map(order, OrderDTO.class);
        return orderDTO;
    }

    public List<OrderDTO> entityToDTO(List<Order> orderList) {
        return orderList.stream().map(entity -> entityToDTO(entity)).collect(Collectors.toList());
    }
}
