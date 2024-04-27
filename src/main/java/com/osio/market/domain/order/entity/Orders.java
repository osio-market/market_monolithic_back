package com.osio.market.domain.order.entity;

import com.osio.market.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Timestamp orderDate;
    private Timestamp cancledDate;
    private Long orderTotalPrice;
    private Status status;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "orders")
    private List<OrderProducts> orderProducts;

    public void updateOrderStatus(Status orderStatus) {
        this.status = orderStatus;
    }

}
