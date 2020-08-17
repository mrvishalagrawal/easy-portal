package com.sarkariblackboard.ServiceImpl;

import com.sarkariblackboard.Entity.Activity;
import com.sarkariblackboard.Repository.ActivityRepository;
import com.sarkariblackboard.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private final ActivityRepository activityRepo;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepo) {
        this.activityRepo = activityRepo;
    }

    public Activity save(Activity activity) {
        if (activity.getId() == null) { // new activity (user logged in)
            Activity firstActivity = this.findFirst();
            if (firstActivity != null) {
                long total = firstActivity.getTotalVisitors();
                activity.setTotalVisitors(++total);
                firstActivity.setTotalVisitors(total);
                this.activityRepo.save(firstActivity);
            }
        }
        return this.activityRepo.save(activity);
    }

    @Override
    public List<Activity> findAll() {
        return this.activityRepo.findAll();

    }

    @Override
    public Activity findFirst() {
        return this.activityRepo.findFirstBy();
    }

}