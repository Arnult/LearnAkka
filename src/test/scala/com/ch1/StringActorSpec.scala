package com.ch1

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{FunSpecLike, Matchers}

class StringActorSpec extends FunSpecLike with Matchers{
    implicit val system = ActorSystem()
  describe("StringActor"){
    describe("get String message"){
      it("should store string message"){
        val actorRef = TestActorRef(new StringActor)
        actorRef ! SetStringRequset("hello")
        val stringActor = actorRef.underlyingActor
        stringActor.message.toString should equal("hello")
        actorRef ! "world"
        stringActor.message.toString should equal("world")
      }
    }
  }
}
