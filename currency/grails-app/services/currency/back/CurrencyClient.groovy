package currency.back

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient(name = "currency-data")
public interface CurrencyClient {

    @RequestMapping("/data")
    Object getCurrency();

}