package com.yrInternship.view

import java.awt.GridLayout

import javax.swing.border.EmptyBorder
import javax.swing.{JButton, JLabel, JPanel, JSpinner}


//Ui for ticket layouts
case class TicketsPanel() extends JPanel {
  val perPageLabel = new JLabel("Search Id:")
  val searchButton = new JButton("Search")
  val prevButton = new JButton("Prev")
  val nextButton = new JButton("Next")
  val ticketsPerPageSpinner = new JSpinner()

  add(perPageLabel)
  add(ticketsPerPageSpinner)
  add(searchButton)
  add(prevButton)
  add(nextButton)
  setLayout(new GridLayout(1,8))
  setBorder(new EmptyBorder(0, 0, 10, 5))


  def getSpinnerValue: Int = Integer.parseInt(ticketsPerPageSpinner.getValue.toString)
}
