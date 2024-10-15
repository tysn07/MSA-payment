package group.microservicepay.remote.feign;

import group.microservicepay.remote.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "microservice-order", url = "http://localhost:8082/external")
public interface OrderFeignClient {

    @GetMapping("/orders/{orderId}")
    Order getOrder(@PathVariable("orderId") Long orderId);

    @GetMapping("/orders/total/{orderId}")
    Long getTotalPrice(@PathVariable("orderId") Long orderId);

}
