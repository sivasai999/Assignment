package com.LBG.Order.mapper;

import com.LBG.Order.dto.OrderDTO;
import com.LBG.Order.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-08T01:33:56+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setCreatedAt( orderDTO.getCreatedAt() );
        order.setId( orderDTO.getId() );
        order.setOrderNumber( orderDTO.getOrderNumber() );
        order.setStatus( orderDTO.getStatus() );
        order.setTotalAmount( orderDTO.getTotalAmount() );
        order.setUserId( orderDTO.getUserId() );

        return order;
    }

    @Override
    public OrderDTO toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setCreatedAt( order.getCreatedAt() );
        orderDTO.setId( order.getId() );
        orderDTO.setOrderNumber( order.getOrderNumber() );
        orderDTO.setStatus( order.getStatus() );
        orderDTO.setTotalAmount( order.getTotalAmount() );
        orderDTO.setUserId( order.getUserId() );

        return orderDTO;
    }
}
