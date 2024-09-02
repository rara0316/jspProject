package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private  static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //id만 반환
    public Item findById(Long id) {
        return store.get(id);
    }

    //모든정보 반환
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, UpdateParamDTO updateParam) {
        Item findItem = findById(itemId);

        //정석으로는 UpdateParamDTO를 만들어서 사용해야한다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    //정보 초기화
    public void clearStore() {
        store.clear();
    }
}
