package pl.doz.DoZproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.doz.DoZproject.model.SaleSummary;
import pl.doz.DoZproject.service.SaleSummaryService;

import java.util.List;

@RestController
@RequestMapping("/doz/salesummary")
@RequiredArgsConstructor
public class SaleSummaryController {
    private final SaleSummaryService saleSummaryService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<SaleSummary> getSummary(@RequestParam String date){   //date {yyyy-mm}
        return saleSummaryService.getSummary(date);
    }
}
