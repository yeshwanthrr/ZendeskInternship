package com.yrInternship.view

import java.awt.{BorderLayout, Color, Component}

import javax.swing.table.{DefaultTableModel, TableCellRenderer}
import javax.swing.{JPanel, JScrollPane, JTable}

case class TablePanel() extends JPanel{


  // UI for Tables

  val tableModel:DefaultTableModel = new DefaultTableModel(0, 0)
  val table: JTable  = new JTable(tableModel) {
    override def prepareRenderer(renderer: TableCellRenderer, row: Int, column: Int): Component = {
      val comp: Component = super.prepareRenderer(renderer, row, column)
      comp.setBackground(if (row % 2 == 0) Color.WHITE else new Color(220, 220, 220))
      comp
    }
  }

  val scrollPane = new JScrollPane(table)
  setLayout(new BorderLayout())
  add(scrollPane)

  tableModel.addColumn("ID")
  tableModel.addColumn("UID")
  tableModel.addColumn("SUBJECT")
  tableModel.addColumn("DESCRIPTION")
  table.getColumnModel.getColumn(0).setPreferredWidth(30)
  table.getColumnModel.getColumn(1).setPreferredWidth(100)
  table.getColumnModel.getColumn(2).setPreferredWidth(200)
  table.getColumnModel.getColumn(3).setPreferredWidth(400)

  // loads data on all records
  def loadDataToTable(tickets: IndexedSeq[TicketFields]): Unit = {
    tableModel.setRowCount(0)
    tickets.foreach(ticket => {
      tableModel.addRow(Array[AnyRef](
        ticket.id,
        ticket.userId,
        ticket.subject,
        ticket.description))
    })
  }

  //filters record when selected
  def loadDataToTableById(ticket: TicketFields): Unit = {
    tableModel.setRowCount(0)
    Vector(ticket).foreach(ticket => {
      tableModel.addRow(Array[AnyRef](
        ticket.id,
        ticket.userId,
        ticket.subject,
        ticket.description))
    })
  }


  //to reset table when id not found
  def displayNothing = {
    tableModel.setRowCount(0)
  }

}
