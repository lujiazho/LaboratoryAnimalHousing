package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.TempAnimalrecordlnfo;
import org.lah.WelfareFeeding.mapper.ExtendedBoarestruslnfoDao;
import org.lah.WelfareFeeding.mapper.ExtendedSowsestruslnfoDao;
import org.lah.WelfareFeeding.service.TempAnimalRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welfare-feeding/estrus")
public class EstrusRestController {
    private final ExtendedBoarestruslnfoDao extendedBoarestruslnfoDao;
    private final ExtendedSowsestruslnfoDao extendedSowsestruslnfoDao;
    private final TempAnimalRecordInfoService tempAnimalRecordInfoService;

    @Autowired
    public EstrusRestController(ExtendedBoarestruslnfoDao extendedBoarestruslnfoDao, ExtendedSowsestruslnfoDao extendedSowsestruslnfoDao, TempAnimalRecordInfoService tempAnimalRecordInfoService) {
        this.extendedBoarestruslnfoDao = extendedBoarestruslnfoDao;
        this.extendedSowsestruslnfoDao = extendedSowsestruslnfoDao;
        this.tempAnimalRecordInfoService = tempAnimalRecordInfoService;
    }

    @GetMapping("")
    @UserAuthority(department = "*", position = "*")
    Object get(@RequestParam(value = "animal_number") String animalNumber) {
        TempAnimalrecordlnfo tempAnimalrecordlnfo = tempAnimalRecordInfoService.queryByAnimalNumber(animalNumber);
        if (tempAnimalrecordlnfo.getPigsex().equals("sow")) {
            return extendedSowsestruslnfoDao.selectByAnimalNumber(tempAnimalrecordlnfo.getAnimalnumber());
        } else {
            return extendedBoarestruslnfoDao.selectByAnimalNumber(tempAnimalrecordlnfo.getAnimalnumber());
        }
    }
}
