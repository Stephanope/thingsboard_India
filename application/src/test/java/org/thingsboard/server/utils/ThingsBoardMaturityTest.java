/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.utils;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ThingsBoardMaturityTest extends Simulation {

    String deviceToken = "TEST_MATURITY_TOKEN_" + System.currentTimeMillis();

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("http://localhost:9090")
        .contentTypeHeader("application/json")
        .acceptHeader("application/json");

    {
        System.out.println("Provisioning device with token: " + deviceToken);
    }

    ScenarioBuilder scn = scenario("ThingsBoard Maturity Test")
        .exec(http("Post Telemetry")
            .post("/api/v1/" + deviceToken + "/telemetry")
            .body(StringBody("{\"temperature\": 25, \"humidity\": 40}"))
            .check(status().is(200))
        );

    {
        setUp(
            scn.injectOpen(constantUsersPerSec(30).during(60))
        ).protocols(httpProtocol);
    }
}