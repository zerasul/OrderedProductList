package es.ind.ordercriteria.domain.products.entity.converter;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderColumnConverter implements AttributeConverter<List<OrderColumnItem>,String> {


    @Override
    public String convertToDatabaseColumn(List<OrderColumnItem> orderColumnItems) {


        return orderColumnItems.stream().map(
                orderColumnItem ->
                    orderColumnItem.getName() +
                            ":" +
                            orderColumnItem.getDirection()
        ).collect(Collectors.joining(","));
    }

    @Override
    public List<OrderColumnItem> convertToEntityAttribute(String s) {
        return Arrays.stream(s.split(","))
                .map(s1 -> {
                    String [] values= s1.split(":");
                    return OrderColumnItem.builder()
                            .name(values[0])
                            .direction(values[1])
                            .build();
                }).collect(Collectors.toList());
    }
}
