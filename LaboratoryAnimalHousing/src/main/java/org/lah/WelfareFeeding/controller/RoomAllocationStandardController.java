package org.lah.WelfareFeeding.controller;

import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.domain.RoomAllocationStandard;
import org.lah.WelfareFeeding.service.RoomAllocationStandardService;
import org.lah.WelfareFeeding.service.UserService;
import org.lah.WelfareFeeding.service.WelfareFeedingTaskService;
import org.lah.WelfareFeeding.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welfare-feeding/room-allocation-standard")
public class RoomAllocationStandardController {
    private final RoomAllocationStandardService roomAllocationStandardService;
    private final UserService userService;
    private WelfareFeedingTaskService welfareFeedingTaskService;

    @Autowired
    public RoomAllocationStandardController(RoomAllocationStandardService RoomAllocationStandardService, UserService userService, WelfareFeedingTaskService welfareFeedingTaskService) {
        this.roomAllocationStandardService = RoomAllocationStandardService;
        this.userService = userService;
        this.welfareFeedingTaskService = welfareFeedingTaskService;
    }

    @GetMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "SecurityOfficer")
    RoomAllocationStandard get(@RequestParam(value = "animal_number") String animalNumber) {
        return RestUtil.CheckResult(roomAllocationStandardService.queryByAnimalNumber(animalNumber));
    }

    @PostMapping("")
    @UserAuthority(department = "WelfareFeeding", position = "SecurityOfficer")
    void post(@RequestBody RoomAllocationStandard roomAllocationStandard) {
        roomAllocationStandard.setStaffing(userService.getUserIdString());
        welfareFeedingTaskService.saveFinishTask(roomAllocationStandard.getAnimalnumber(), userService.getUserIdString(), "room_allocation_standard");
        roomAllocationStandardService.save(roomAllocationStandard);
    }

}
