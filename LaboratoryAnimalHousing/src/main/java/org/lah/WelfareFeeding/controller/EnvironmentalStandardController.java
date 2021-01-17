package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.EnvironmentalStandard;
import org.lah.WelfareFeeding.service.EnvironmentalStandardService;
import org.lah.WelfareFeeding.service.UserService;
import org.lah.WelfareFeeding.service.WelfareFeedingTaskService;
import org.lah.WelfareFeeding.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/welfare-feeding/environmental-standard")
public class EnvironmentalStandardController {
    private final EnvironmentalStandardService environmentalStandardService;
    private final UserService userService;
    private WelfareFeedingTaskService welfareFeedingTaskService;

    @Autowired
    public EnvironmentalStandardController(EnvironmentalStandardService environmentalStandardService, UserService userService, WelfareFeedingTaskService welfareFeedingTaskService) {
        this.environmentalStandardService = environmentalStandardService;
        this.userService = userService;
        this.welfareFeedingTaskService = welfareFeedingTaskService;
    }

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "SecurityOfficer")
    EnvironmentalStandard get(@RequestParam(value = "animal_number") String animalNumber) {
        return RestUtil.CheckResult(environmentalStandardService.queryByAnimalNumber(animalNumber));
    }

    @PostMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "SecurityOfficer")
    void post(@RequestBody EnvironmentalStandard environmentalStandard) {
        environmentalStandard.setStaffing(userService.getUserIdString());
        environmentalStandard.setEstablishmentdate(new Date());
        welfareFeedingTaskService.saveFinishTask(environmentalStandard.getAnimalnumber(), userService.getUserIdString(), "environmental_standard");
        environmentalStandardService.save(environmentalStandard);
    }

}
