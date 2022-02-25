package com.example.books.service;

import com.example.books.entity.Price;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.PriceModel;
import com.example.books.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepo priceRepo;

    public Price addPrice(Price price) {
        return priceRepo.save(price);
    }

    public List<PriceModel> convertPriceToModel(Iterable<Price> prices) {
        List<PriceModel> priceModelList = new ArrayList<>();
        for (Price price : prices)
        {
            priceModelList.add(PriceModel.toModel(price));
        }
        return priceModelList;
    }

    public List<PriceModel> getAllPrices() {
        return convertPriceToModel(priceRepo.findAll());
    }

    public PriceModel findOnePrice(Integer id) throws NotFoundException {
        Price price = priceRepo.findById(id).get();
        if (price == null) {
            throw new NotFoundException("Цена не найдена");
        }
        return PriceModel.toModel(price);
    }

    public int deletePrice(Integer id) throws NotFoundException {
        if (!priceRepo.existsById(id)) {
            throw new NotFoundException("Цена не найдена");
        }
        priceRepo.deleteById(id);
        return id;
    }

    public Price updatePrice(Integer id, Price model) throws NotFoundException {
        if (!priceRepo.existsById(id)) {
            throw new NotFoundException("Цена не найдена");
        }
        Price price = priceRepo.findById(id).get();
        price.setPriceId(model.getPriceId());
        price.setPriceSale(model.getPriceSale());
        return priceRepo.save(price);
    }

}

