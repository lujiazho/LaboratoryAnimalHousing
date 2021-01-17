package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.WelfareFeedingTask;
import org.lah.WelfareFeeding.service.UserService;
import org.lah.WelfareFeeding.service.WelfareFeedingTaskService;
import org.lah.WelfareFeeding.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/welfare-feeding/welfare-feeding-task")
public class WelfareFeedingTaskController {
    private final UserService userService;
    private final WelfareFeedingTaskService welfareFeedingTaskService;

    @Autowired
    public WelfareFeedingTaskController(UserService userService, WelfareFeedingTaskService welfareFeedingTaskService) {
        this.userService = userService;
        this.welfareFeedingTaskService = welfareFeedingTaskService;
    }

    @GetMapping("/all")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    PageResult<WelfareFeedingTask> getByStaffing(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return welfareFeedingTaskService.queryByStaffing(userService.getUserIdString(), page, limit);
    }

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    WelfareFeedingTask getByAnimalNumber(@RequestParam("animal_number") String animalNumber) {
        return RestUtil.CheckResult(
                welfareFeedingTaskService.queryByAnimalAndStaffing(
                        animalNumber, userService.getUserIdString())
        );
    }

    @PostMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "*")
    void post(@RequestBody WelfareFeedingTask welfareFeedingTask) {
        welfareFeedingTask.setMaintenancestaff(userService.getUserIdString());
        welfareFeedingTask.setLastupdated(new Date());
        welfareFeedingTaskService.save(welfareFeedingTask);
    }
}
