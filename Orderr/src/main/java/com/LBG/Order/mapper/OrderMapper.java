package com.LBG.Order.mapper;

import com.LBG.Order.dto.OrderDTO;
import com.LBG.Order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDTO orderDTO);

    OrderDTO toDto(Order order);
}
