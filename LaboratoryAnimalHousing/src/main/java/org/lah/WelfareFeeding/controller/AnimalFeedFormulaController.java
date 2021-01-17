package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.AnimalFeedFormula;
import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.exception.NotFoundException;
import org.lah.WelfareFeeding.service.AnimalFeedFormulaService;
import org.lah.WelfareFeeding.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welfare-feeding/animal-feed-formula")
public class AnimalFeedFormulaController {
    private final AnimalFeedFormulaService animalFeedFormulaService;

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    public AnimalFeedFormula get(@RequestParam(value="feed_number") String feedNumber){
        return RestUtil.CheckResult(animalFeedFormulaService.queryByFeedNumber(feedNumber));
    }

    @GetMapping("/all")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    public PageResult<AnimalFeedFormula> getAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return animalFeedFormulaService.queryOrderByFeedNumber(page, limit);
    }

    @PostMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "FeedingPlanner")
    public void post(@RequestBody AnimalFeedFormula animalFeedFormula){
        animalFeedFormulaService.save(animalFeedFormula);
    }

    @Autowired
    public AnimalFeedFormulaController(AnimalFeedFormulaService animalFeedFormulaService) {
        this.animalFeedFormulaService = animalFeedFormulaService;
    }
}
