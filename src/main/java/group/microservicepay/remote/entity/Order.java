package group.microservicepay.remote.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String address;

    @Column
    private String KakaoTid;

    @Enumerated(value = EnumType.STRING)
    private OrderState state;

    public void updateTid(String tid){
        this.KakaoTid=tid;
    }

    public void changeState(OrderState state){this.state = state;}
}
