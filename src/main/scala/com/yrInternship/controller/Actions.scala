package com.yrInternship.controller

import com.yrInternship.model.TicketsRequester
import com.yrInternship.view.TicketFields
import javax.swing.JOptionPane
import play.api.libs.json.JsValue

trait Actions {

  var pageNumber = 1
  val requester: TicketsRequester = TicketsRequester()

  //parses json ticket response
  def parseTicket(ticket: JsValue): TicketFields = {
    val id: String = (ticket \ "id").get.toString()
    val userId: String = (ticket \ "requester_id").get.toString()
    val subject: String = (ticket \ "subject").get.toString()
    val description: String = (ticket \ "description").get.toString()
    TicketFields(id, userId, subject, description)
  }


  def throwError(exception: Throwable): Unit = {
    val optionPane = new JOptionPane(exception.getMessage, JOptionPane.ERROR_MESSAGE)
    val dialog = optionPane.createDialog("Error")
    dialog.setAlwaysOnTop(true)
    dialog.setVisible(true)
  }

  def incrementPageNumber(): Int = {
    pageNumber += 1
    pageNumber
  }

  def decrementPageNumber(): Int = {
    if (pageNumber > 1) pageNumber -= 1
    pageNumber
  }

  def resetPageNumber(): Unit = pageNumber = 1

}
