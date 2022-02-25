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
public class StorageService {
    @Autowired
    private StorageRepo storageRepo;

    public Storage addStorage(Storage storage) {
        return storageRepo.save(storage);
    }

    public List<StorageModel> convertStorageToModel(Iterable<Storage> storages) {
        List<StorageModel> storageModelList = new ArrayList<>();
        for (Storage storage : storages)
        {
            storageModelList.add(StorageModel.toModel(storage));
        }
        return storageModelList;
    }

    public List<StorageModel> getAllStorages() {
        return convertStorageToModel(storageRepo.findAll());
    }

    public StorageModel findOneStorage(Integer id) throws NotFoundException {
        Storage storage = storageRepo.findById(id).get();
        if (storage == null) {
            throw new NotFoundException("Storage не найден");
        }
        return StorageModel.toModel(storage);
    }

    public int deleteStorage(Integer id) throws NotFoundException {
        if (!storageRepo.existsById(id)) {
            throw new NotFoundException("storage не найден");
        }
        storageRepo.deleteById(id);
        return id;
    }

    public Storage updateStorage(Integer id, Storage model) throws NotFoundException {
        if (!storageRepo.existsById(id)) {
            throw new NotFoundException("storage не найден");
        }
        Storage storage = storageRepo.findById(id).get();
        storage.setBookId(model.getBookId());
        storage.setCount(model.getCount());
        storage.setBookId(model.getBookId());
        return storageRepo.save(storage);
    }

}
