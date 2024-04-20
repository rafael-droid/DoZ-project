package pl.doz.DoZproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.model.Product;
import pl.doz.DoZproject.repository.PriceListRepository;
import pl.doz.DoZproject.repository.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceListService {

    private final PriceListRepository priceListRepository;

    private final ProductRepository productRepository;

    public PriceList create(PriceList priceList) {
        validateNewPrice(priceList);
        priceListRepository.save(priceList);
        return priceList;
    }


    private void validateNewPrice(PriceList priceList) {
        if(ObjectUtils.isEmpty(priceList.getPrice()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


}
