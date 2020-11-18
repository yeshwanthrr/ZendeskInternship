package com.yrInternship

import com.yrInternship.controller.UIComponents
import com.yrInternship.model.TicketsRequester
import org.scalatest.FunSuite
import play.api.libs.json.JsResult.Exception

case class TestPath() extends FunSuite{

  test("TicketsRequester"){
    assert(1 == 1)
  }

  test("Should throw Exception when the tokens is not correct"){
    val url = s"https://yrinternship.zendesk.com/api/v2/tickets.json?per_page=25&page=1"
    val token = ""
    assert(TicketsRequester().getRequest(url,token).getClass.toString == "class scala.util.Failure")
  }

  test("Should receive an response for the ticket Id = 2"){
    assert(TicketsRequester().getTicketById(2).isSuccess)
  }

  test("Should fail for the ticket Id = 30"){
    assert(!TicketsRequester().getTicketById(30).isSuccess)
  }
}
