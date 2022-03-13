package com.example.books.model;

import com.example.books.entity.Book;
import com.example.books.entity.Storage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageModel {
    private Integer storageId;
    private Book bookId;
    private Integer count;

    public StorageModel() {}

    public static StorageModel toModel(Storage storage) {
        StorageModel storageModel = new StorageModel();
        storageModel.setStorageId(storage.getStorageId());
        storageModel.setBookId(storage.getBookId());
        storageModel.setCount(storage.getCount());
        return storageModel;
    }

    public StorageModel(Integer storageId, Book bookId, Integer count) {
        this.storageId = storageId;
        this.bookId = bookId;
        this.count = count;
    }
}
