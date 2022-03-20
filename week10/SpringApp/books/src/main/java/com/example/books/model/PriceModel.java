package com.example.books.model;

import com.example.books.entity.Price;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriceModel {
    private Integer priceId;
    private Double priceSale;

    public PriceModel() {}

    public static PriceModel toModel(Price price) {
        PriceModel priceModel = new PriceModel();
        priceModel.setPriceId(price.getPriceId());
        priceModel.setPriceSale(price.getPriceSale());
        return priceModel;
    }

    public PriceModel(Integer priceId, Double priceSale) {
        this.priceId = priceId;
        this.priceSale = priceSale;
    }
}

