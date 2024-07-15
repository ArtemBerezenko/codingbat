package com.company.leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class TrafficLightControlledIntersection {

    class TrafficLight {
        boolean green;
        ReentrantLock lock;

        public TrafficLight() {
            this.green = true;
            this.lock = new ReentrantLock();
        }

        public void carArrived(
                int carId,           // ID of the car
                int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                int direction,       // Direction of the car
                Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
                Runnable crossCar    // Use crossCar.run() to make car cross the intersection
        ) {
            lock.lock();

            if(green != (roadId == 1)) { // when arriving car's road is closed, open it
                turnGreen.run();
                green = !green;
            }
            crossCar.run();
            lock.unlock();
        }
    }
}
