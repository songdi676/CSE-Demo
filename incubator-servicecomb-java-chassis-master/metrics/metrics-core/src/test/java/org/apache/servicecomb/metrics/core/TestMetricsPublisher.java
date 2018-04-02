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

package org.apache.servicecomb.metrics.core;

import java.util.Map;

import org.apache.servicecomb.metrics.core.publish.MetricsPublisher;
import org.junit.Assert;
import org.junit.Test;

public class TestMetricsPublisher {
  @Test
  public void testMeasure() {
    System.getProperties().setProperty(MetricsConfig.METRICS_WINDOW_TIME, "2000");

    MetricsPublisher publisher = new MetricsPublisher();
    Map<String, Double> metrics = publisher.measure();
    //10 jvm metrics get
    Assert.assertEquals(10, metrics.size());
  }
}
