package com.yrInternship.controller

import java.awt.event.ActionEvent

import com.yrInternship.view.{TablePanel, TicketsPanel}
import play.api.libs.json.{JsObject, JsValue}

import scala.util.{Failure, Success, Try}

case class UIComponents() extends Actions {

  val ticketsPanel = TicketsPanel()
  val tablePanel = TablePanel()

  //loads by default 25 tickets per page when the page starts

  def loadDefault() = {
    val response = requester.getAllTickets(25, 1)
    response match {
      case Success(value) =>
        val tickets = value("tickets").as[IndexedSeq[JsObject]].map(parseTicket)
        tablePanel.loadDataToTable(tickets)
      case Failure(exception) => throwError(exception)
    }
  }

  def responseHandler(response:Try[JsValue])={
    response match {
      case Success(value) =>
        val tickets = value("tickets").as[IndexedSeq[JsObject]].map(parseTicket)
        tablePanel.loadDataToTable(tickets)
      case Failure(exception) => throwError(exception)
    }
  }


  //performs action for search button

  def applySearchListener(e: ActionEvent)={
    val spinnerValue = ticketsPanel.getSpinnerValue

    val response = requester.getTicketById(spinnerValue)
    response match {
      case Success(value) =>
        val ticket = parseTicket(value("ticket"))
        tablePanel.loadDataToTableById(ticket)
      case Failure(exception) => {
        tablePanel.displayNothing
        throwError(exception)
      }
    }
  }

  //performs action for the next button

  def applyNextListener(e: ActionEvent) = {
    val pageNumber = incrementPageNumber
    val response = requester.getAllTickets(25, pageNumber)
    responseHandler(response)
  }

  //performs an action for previous button
  def applyPrevListener(e: ActionEvent) = {
    val pageNumber = decrementPageNumber
    val response = requester.getAllTickets(25, pageNumber)
    responseHandler(response)

  }

  ticketsPanel.searchButton.addActionListener(applySearchListener)
  ticketsPanel.nextButton.addActionListener(applyNextListener)
  ticketsPanel.prevButton.addActionListener(applyPrevListener)


}
