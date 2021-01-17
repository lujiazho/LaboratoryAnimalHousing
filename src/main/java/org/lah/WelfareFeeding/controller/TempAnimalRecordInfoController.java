package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.TempAnimalrecordlnfo;
import org.lah.WelfareFeeding.service.TempAnimalRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welfare-feeding/temp-animal-record-info")
public class TempAnimalRecordInfoController {
    private final TempAnimalRecordInfoService tempAnimalRecordInfoService;

    @Autowired
    public TempAnimalRecordInfoController(TempAnimalRecordInfoService tempAnimalRecordInfoService) {
        this.tempAnimalRecordInfoService = tempAnimalRecordInfoService;
    }

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    public PageResult<TempAnimalrecordlnfo> get(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return tempAnimalRecordInfoService.queryOrderByAnimalNumber(page, limit);
    }

    @GetMapping("animalNumber")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    public TempAnimalrecordlnfo getByAnimalNumber(@RequestParam("animal_number") String animalNumber){
        return tempAnimalRecordInfoService.queryByAnimalNumber(animalNumber);
    }
}
