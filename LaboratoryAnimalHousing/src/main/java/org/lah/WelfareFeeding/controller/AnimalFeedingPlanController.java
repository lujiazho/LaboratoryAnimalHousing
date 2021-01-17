package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.AnimalFeedingPlan;
import org.lah.WelfareFeeding.domain.WelfareFeedingTask;
import org.lah.WelfareFeeding.service.AnimalFeedingPlanService;
import org.lah.WelfareFeeding.service.UserService;
import org.lah.WelfareFeeding.service.WelfareFeedingTaskService;
import org.lah.WelfareFeeding.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welfare-feeding/animal-feeding-plan")
public class AnimalFeedingPlanController {
    private final AnimalFeedingPlanService animalFeedingPlanService;
    private final WelfareFeedingTaskService welfareFeedingTaskService;
    private final UserService userService;

    @Autowired
    public AnimalFeedingPlanController(AnimalFeedingPlanService animalFeedingPlanService, WelfareFeedingTaskService welfareFeedingTaskService, UserService userService) {
        this.animalFeedingPlanService = animalFeedingPlanService;
        this.welfareFeedingTaskService = welfareFeedingTaskService;
        this.userService = userService;
    }

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    AnimalFeedingPlan get(@RequestParam(value = "animal_number") String animalNumber) {
        return RestUtil.CheckResult(animalFeedingPlanService.queryByAnimalNumber(animalNumber));
    }

    @PostMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "FeedingPlanner")
    void post(@RequestBody AnimalFeedingPlan animalFeedingPlan) {
        animalFeedingPlan.setStaffing(userService.getUserIdString());
        welfareFeedingTaskService.saveFinishTask(animalFeedingPlan.getAnimalnumber(), userService.getUserIdString(), "feeding_plan");
        animalFeedingPlanService.save(animalFeedingPlan);
    }
}
