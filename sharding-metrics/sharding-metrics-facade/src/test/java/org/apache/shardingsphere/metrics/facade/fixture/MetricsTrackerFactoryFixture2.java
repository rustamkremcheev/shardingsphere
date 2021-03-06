/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.metrics.facade.fixture;

import org.apache.shardingsphere.metrics.api.HistogramMetricsTracker;
import org.apache.shardingsphere.metrics.api.MetricsTracker;
import org.apache.shardingsphere.metrics.api.MetricsTrackerFactory;
import org.apache.shardingsphere.metrics.api.SummaryMetricsTracker;
import org.apache.shardingsphere.metrics.enums.MetricsTypeEnum;

import java.util.Optional;

public final class MetricsTrackerFactoryFixture2 implements MetricsTrackerFactory {
    
    @Override
    public Optional<MetricsTracker> create(final String metricsType, final String metricsLabel) {
        if (MetricsTypeEnum.HISTOGRAM.name().equals(metricsType)) {
            return Optional.of((HistogramMetricsTracker) () -> metricsLabel);
        } else if (MetricsTypeEnum.SUMMARY.name().equals(metricsType)) {
            return Optional.of((SummaryMetricsTracker) () -> metricsLabel);
        } else {
            return Optional.empty();
        }
    }
}

