package group.microservicepay.kakaopay.controller;


import group.microservicepay.kakaopay.dto.response.CancelResDto;
import group.microservicepay.kakaopay.dto.response.PayApproveResDto;
import group.microservicepay.kakaopay.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @GetMapping("/ready/{orderId}")
    public ResponseEntity<?> getRedirectUrl(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(kakaoPayService.getRedirectUrl(orderId));
    }

    @GetMapping("/success/{orderId}")
    public RedirectView afterGetRedirectUrl(@PathVariable Long orderId, @RequestParam("pg_token") String pgToken) throws Exception {
        PayApproveResDto kakaoApprove = kakaoPayService.getApprove(pgToken,orderId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://son7shop.com");
        return redirectView;
    }

    @GetMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancel(@PathVariable Long orderId) throws Exception {
        CancelResDto cancelResDto = kakaoPayService.kakaoCancel(orderId);
       // orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cancelResDto);
    }

    @GetMapping("")
    public String testconnection(){
          return "OK";

    }

}

