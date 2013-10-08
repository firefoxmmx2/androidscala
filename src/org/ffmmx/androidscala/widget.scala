package org.ffmmx.androidscala

import android.app._
import android.view._
import android.widget._

trait TraitButton[T <: Button] extends RView[T] {

}

class RichButton(button: Button) extends TraitButton[Button] {
  def self = button
}

trait RView[T <: View] {
  def self: T

  def onClick(handler: => Unit) = {
    self.setOnClickListener(new View.OnClickListener() {
      override def onClick(view: View) {
        handler
      }
    })
    this
  }

  def onClick(handler: View => Unit) = {
    self.setOnClickListener(new View.OnClickListener() {
      override def onClick(v: View) {
        handler(v)
      }
    })
    this
  }

}

class RichView(view: View) extends RView[View] {
  def self = view
}

object Widgets {
  implicit def view2RichView(v: View) = new RichView(v)
  implicit def activity2RichActivity(activity: Activity) = new RichActivity(activity)
}