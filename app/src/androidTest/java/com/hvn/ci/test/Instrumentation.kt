package com.hvn.ci.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(glue = ["com.hvn.ci.test"], tags = ["@smoke"], features = ["features"])
class Instrumentation: CucumberAndroidJUnitRunner()

