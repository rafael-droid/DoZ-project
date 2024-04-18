package pl.doz.DoZproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.service.PriceListService;

@RestController
@RequestMapping("/doz/pricelist")
@RequiredArgsConstructor
public class PriceListController {
    private final PriceListService priceListService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PriceList createPrice(@RequestBody PriceList priceList){
        return priceListService.create(priceList);
    }
}
