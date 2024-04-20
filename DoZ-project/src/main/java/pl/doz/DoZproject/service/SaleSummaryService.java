package pl.doz.DoZproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import pl.doz.DoZproject.model.PriceList;
import pl.doz.DoZproject.model.Product;
import pl.doz.DoZproject.model.SaleSummary;
import pl.doz.DoZproject.repository.SaleSummaryRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class SaleSummaryService {
    private final SaleSummaryRepository saleSummaryRepository;
    private final ProductService productService;


    public List<SaleSummary> getSummary(String date) {

        Pattern pattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])$");
        Matcher matcher = pattern.matcher(date);
        if(!matcher.find())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return saleSummaryRepository.findSaleSummaryBySaleDate(date);


    }

    public SaleSummary addSaleSummary(SaleSummary saleSummary){
        saleSummary.setPriceSale(saleSummary.getProducts().get(1).getPriceList().getPrice() * saleSummary.getAmount());
        validateNewSaleSummary(saleSummary);
        return saleSummaryRepository.save(saleSummary);
    }


    private void validateNewSaleSummary(SaleSummary saleSummary) {
        if(ObjectUtils.isEmpty(saleSummary.getProducts()) || ObjectUtils.isEmpty(saleSummary.getAmount()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
