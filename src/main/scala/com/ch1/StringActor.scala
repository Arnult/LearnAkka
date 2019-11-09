package com.ch1

import akka.actor.Actor
import akka.event.Logging

class StringActor extends Actor{
  val message = new StringBuffer()
  val log = Logging(context.system,this)
  override def receive: Receive = {
    case SetStringRequset(value) =>{
      log.info("Received SetStringRequest :"+value)
      message.delete(0,message.length())
      message.append(value)
    }
    case "world" =>{
      log.info("Received String")
      message.delete(0,message.length())
      message.append("world")
    }
  }
}
