/*
 * Copyright 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.uber.cadence.samples.periodicworkflow;

import com.uber.cadence.activity.Activity;

import java.util.Random;

public class PeriodicWorkflowActivitiesImpl implements PeriodicWorkflowActivities {

    /**
     * Activity takes random time to execute to show that it is waited if workflow parameter waitForActivityCompletion
     * is set to true
     */
    @Override
    public void doSomeWork(String parameter) {
        String runId = Activity.getWorkflowExecution().getRunId();
        Random r = new Random();
        long delay = r.nextInt(3000);
        System.out.println("Run Id: " + runId + ", Do some periodic task here for " + delay + " milliseconds with parameter="
                + parameter);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }

    }

}
