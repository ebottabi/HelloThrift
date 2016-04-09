package com.hellothrift.services

import com.hellothrift.thrift._
import scala.collection.mutable
import com.twitter.util.Future
/**
 * Created by ebottabi on 4/9/16.
 */
object HelloImpl {

  def apply(): HelloServices[Future] = new HelloServices[Future] {

    def sayHelloTo(param: UserParam): Future[Response] = {
      val msg = new mutable.HashMap[String, String]()
      msg.put("message", "Hello World From thrift")
      Future.value(Response(msg = msg.toMap))
    }

  }

}
