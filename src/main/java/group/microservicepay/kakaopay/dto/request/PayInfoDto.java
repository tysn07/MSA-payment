package group.microservicepay.kakaopay.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayInfoDto {
    private Long price;
    private String itemName;
}