package com.hellothrift.handlers

import com.hellothrift.thrift.{ HelloServices, UserParam }
import com.twitter.finagle.{ Thrift, Service }
import com.twitter.finagle.http.{ Status, Response, Request }
import com.twitter.util.Future

/**
 * Created by ebottabi on 4/9/16.
 */
object HelloHandler {

  val client = Thrift.newIface[HelloServices.FutureIface]("zk!127.0.0.1:2181!/helloService")

  def indexAction = new Service[Request, Response] {
    override def apply(req: Request): Future[Response] = {
      val rep = Response(req.getProtocolVersion(), Status.Ok)
      val content = req.getContentString()
      client.sayHelloTo(UserParam(name = "Samklr :p")).map {
        data =>
          rep.setContentString(data.msg.getOrElse("message", ""))
          rep
      }
    }
  }

}
