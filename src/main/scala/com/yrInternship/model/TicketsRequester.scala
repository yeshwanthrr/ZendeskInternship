package com.yrInternship.model

import play.api.libs.json._
import scalaj.http.Http

import scala.util.{Failure, Success, Try}

case class TicketsRequester(){

  private val token: String = "eWVzaHdhbnRocnJAb3V0bG9vay5jb206WWVzaEAyMjk="

  //getHttp responses
  def getRequest(url: String, token: String): Try[JsValue] = {
    val request = Http(url).header("Authorization", s"Basic $token")
    val response = request.asString
    val json = Json.parse(response.body)
    handleResponseError(json)
  }

  def handleResponseError(response: JsValue): Try[JsValue] = {
    (response \ "error").validate[JsObject] match {
      case JsSuccess(value, _) =>
        val errorMsg: String = "Error: "+ value.toString
        Failure(new Exception(errorMsg))

      case JsError(_) =>
        (response \ "error").validate[String] match {
          case JsSuccess(value, _) => {
            val errorMsg: String = "Error: "+ value.toString + " Please provide valid tokens"
            Failure(new Exception(errorMsg))
          }

          case JsError(_) =>
            Success(response)
        }
    }
  }



  def getAllTickets(perPage: Int=25, pageNumber: Int): Try[JsValue] = {
    val url: String = s"https://yrinternship.zendesk.com/api/v2/tickets.json?per_page=$perPage&page=$pageNumber"
    getRequest(url, token)
  }

  def getTicketById(id: Int): Try[JsValue] = {
    val url: String = s"https://yrinternship.zendesk.com/api/v2/tickets/$id.json"
    getRequest(url, token)
  }


}
