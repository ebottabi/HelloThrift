package com.hellothrift

import com.hellothrift.handlers.HelloHandler
import com.hellothrift.services.HelloImpl
import com.twitter.finagle.http._
import com.twitter.finagle.{ Http, ThriftMux }
import com.twitter.server.TwitterServer
import com.twitter.util.Await

object HelloMain extends TwitterServer {

  def main() = {

    println("Starting http server on port 8001")

    HttpMuxer.addRichHandler(f"/", HelloHandler.indexAction)
    val httpPort = new java.net.InetSocketAddress(3000)
    val httpService = Http.serve(httpPort, HttpMuxer)

    println("Start internal thrift service on port 3030")

    val thriftPort = new java.net.InetSocketAddress(3030)
    val thriftService = ThriftMux.server.serveIface(thriftPort, HelloImpl())

    thriftService.announce("zk!127.0.0.1:2181!/helloService!0")

    Await.all(httpService, thriftService)

  }

}
