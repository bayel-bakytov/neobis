import dao.StorageDao;
import entity.Storage;
import util.ConnectionManager;
import java.util.List;

public class DaoRunner {
    public static void main(String[] args) {
        try {
              StorageDao storageDao = StorageDao.getInstance();
              Storage storage = new Storage();
              storage.setBookId(5);
              storage.setCountBook(10);
              Storage saveStorage = storageDao.save(storage);
              System.out.println(saveStorage);
              boolean deleteResult = storageDao.delete(9);
              System.out.println(deleteResult);
              var maybeStorage = storageDao.findById(10);
              maybeStorage.ifPresent(strg -> {
                  strg.setCountBook(Integer.valueOf(55));
                  storageDao.update(strg);
              });
            List<Storage> storageList = storageDao.getInstance().findAll();
            System.out.println(storageList);

        } finally {
            ConnectionManager.closePool();
        }
    }
}
