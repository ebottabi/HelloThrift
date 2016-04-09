#!/usr/bin/env bash
sbt 'run-main com.hellothrift.HelloMain -admin.port=:3040 -log.level=INFO -com.twitter.finagle.netty3.numWorkers=8'
