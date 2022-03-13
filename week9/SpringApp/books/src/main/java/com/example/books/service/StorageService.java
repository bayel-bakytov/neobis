package com.example.books.service;

import com.example.books.entity.Storage;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.StorageModel;
import com.example.books.repository.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService implements Crud<Storage,StorageModel,Integer>{
    @Autowired
    private StorageRepo storageRepo;

    @Override
    public void add(Storage storage) {
        storageRepo.save(storage);
    }

    @Override
    public List<StorageModel> convertToModel(Iterable<Storage> storages) {
        List<StorageModel> storageModelList = new ArrayList<>();
        for (Storage storage : storages)
        {
            storageModelList.add(StorageModel.toModel(storage));
        }
        return storageModelList;
    }

    @Override
    public List<StorageModel> getAll() throws NotFoundException {
        return convertToModel(storageRepo.findAll());
    }

    @Override
    public StorageModel findById(Integer id) throws NotFoundException {
        Storage storage = storageRepo.findById(id).get();
        if (storage == null) {
            throw new NotFoundException("Storage не найден");
        }
        return StorageModel.toModel(storage);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!storageRepo.existsById(id)) {
            throw new NotFoundException("storage не найден");
        }
        storageRepo.deleteById(id);
        return id;
    }

    @Override
    public Storage updateEntity(Integer id, Storage storageChange) throws NotFoundException {
        if (!storageRepo.existsById(id)) {
            throw new NotFoundException("storage не найден");
        }
        Storage storage = storageRepo.findById(id).get();
        storage.setBookId(storageChange.getBookId());
        storage.setCount(storageChange.getCount());
        storage.setBookId(storageChange.getBookId());
        return storageRepo.save(storage);
    }
}
