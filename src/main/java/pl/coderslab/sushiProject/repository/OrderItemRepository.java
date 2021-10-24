package pl.coderslab.sushiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.sushiProject.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Modifying
    @Transactional
//    @Query(value = "update OrderItem o set o.orderId = :orderId where o.id = :orderItemId")
    @Query(value = "UPDATE order_item SET order_id = ?1 WHERE id = ?2", nativeQuery = true)
    void updateOrderId(long orderId, long orderItemId);

    @Query(value = "select * from order_item where order_id=?1", nativeQuery = true)
    List<OrderItem> selectItemOfOrder(long orderId);
}
