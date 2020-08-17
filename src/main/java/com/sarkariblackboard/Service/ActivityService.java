package com.sarkariblackboard.Service;

import com.sarkariblackboard.Entity.Activity;

import java.util.List;

public interface ActivityService {
    Activity findFirst();


 Activity save(Activity activity);

    List<Activity> findAll();
//
//    Activity findFirst();
//
//    Activity findLast(User user);
//
//    Page<Activity> findByUser(User user, int page, int size);
//
//
//    void delete(Long id);
}