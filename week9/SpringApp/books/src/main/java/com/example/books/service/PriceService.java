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
public class PriceService implements Crud<Price, PriceModel,Integer> {
    @Autowired
    private PriceRepo priceRepo;

    @Override
    public void add(Price price) {
        priceRepo.save(price);
    }

    @Override
    public List<PriceModel> convertToModel(Iterable<Price> prices) {
        List<PriceModel> priceModelList = new ArrayList<>();
        for (Price price : prices)
        {
            priceModelList.add(PriceModel.toModel(price));
        }
        return priceModelList;
    }

    @Override
    public List<PriceModel> getAll() throws NotFoundException {
        return convertToModel(priceRepo.findAll());
    }

    @Override
    public PriceModel findById(Integer id) throws NotFoundException {
        Price price = priceRepo.findById(id).get();
        if (price == null) {
            throw new NotFoundException("Цена не найдена");
        }
        return PriceModel.toModel(price);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!priceRepo.existsById(id)) {
            throw new NotFoundException("Цена не найдена");
        }
        priceRepo.deleteById(id);
        return id;
    }

    @Override
    public Price updateEntity(Integer id, Price priceChange) throws NotFoundException {
        if (!priceRepo.existsById(id)) {
            throw new NotFoundException("Цена не найдена");
        }
        Price price = priceRepo.findById(id).get();
        price.setPriceId(priceChange.getPriceId());
        price.setPriceSale(priceChange.getPriceSale());
        return priceRepo.save(price);
    }
}

