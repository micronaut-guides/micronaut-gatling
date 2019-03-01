package example.micronaut

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class WebServiceCallSimulation extends Simulation {

    val rampUpTimeSecs = 5
    val testTimeSecs = 20
    val noOfUsers = 10
    val minWaitMs = 1000 milliseconds
    val maxWaitMs = 3000 milliseconds

    val baseURL = "http://localhost:8080"
    val baseName = "webservice-call-greeting"
    val requestName = baseName + "-request"
    val scenarioName = baseName + "-scenario"
    val URI = "/greeting"

    val httpProtocol = http
            .baseUrl(baseURL)
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
            .doNotTrackHeader("1")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

    val scn = scenario(scenarioName)
            .during(testTimeSecs) {
        exec(
                http(requestName)
                        .get(URI)
                        .check(status.is(200))
        ).pause(minWaitMs, maxWaitMs)
    }
    setUp(scn.inject(atOnceUsers(noOfUsers))).protocols(httpProtocol)
}