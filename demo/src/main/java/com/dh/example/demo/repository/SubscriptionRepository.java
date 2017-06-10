package com.dh.example.demo.repository;

import com.dh.example.demo.domain.Subscription;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Lucho on 10/06/2017.
 */
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
