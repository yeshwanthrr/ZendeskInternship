package com.yrInternship.view

import java.awt.{BorderLayout, Dimension}

import com.yrInternship.controller.{Actions, UIComponents}
import javax.swing.JFrame

case class BaseFrame(){

  // Outline for the UI frame

  val uiComponents = UIComponents()
  val frame = new JFrame()

  frame.add(uiComponents.ticketsPanel, BorderLayout.NORTH)
  frame.add(uiComponents.tablePanel, BorderLayout.CENTER)
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.setTitle("Ticket Details")
  frame.setVisible(true)
  frame.setSize(new Dimension(800, 400))
  frame.pack()

  uiComponents.loadDefault


}
