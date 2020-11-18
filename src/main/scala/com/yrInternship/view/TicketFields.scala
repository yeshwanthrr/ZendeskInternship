package com.yrInternship.view

case class TicketFields(
                         val id: String,
                         val userId: String,
                         val subject: String,
                         val description: String
                       ){
  override def toString: String =
    s"$id : $userId\n$subject\n$description"
}
