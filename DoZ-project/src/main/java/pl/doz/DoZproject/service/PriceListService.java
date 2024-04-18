package pl.doz.DoZproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.repository.PriceListRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceListService {
    private final PriceListRepository priceListRepository;

    public PriceList create(PriceList priceList) {
        validateNewPrice(priceList);
        validateExistingPrice(priceList);
        priceListRepository.save(priceList);
        return priceList;
    }

    private void validateExistingPrice(PriceList priceList) {
        Optional<PriceList> existingPrice = priceListRepository.findPriceListByProductId(priceList.getProduct().getId());
        if(existingPrice.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private void validateNewPrice(PriceList priceList) {
        if(ObjectUtils.isEmpty(priceList.getProduct()) || ObjectUtils.isEmpty(priceList.getPrice()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
