package Controller.item;

import java.util.List;

public interface ItemService {
    boolean addItem();
    boolean updateItem();
    boolean deleteItem();
     item searchcode(String Code);
    List<item> getAll();
}
