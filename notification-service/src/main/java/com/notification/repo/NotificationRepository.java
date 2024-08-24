package com.notification.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.object_jars.entity.Notification;


public interface NotificationRepository extends JpaRepository<Notification, String> {

}
