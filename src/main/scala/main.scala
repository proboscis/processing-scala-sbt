package kuhn

import processing.core._
import PConstants._
import PApplet._
import scala.collection.mutable.ArrayBuffer

class Main extends PApplet {
  val records = ArrayBuffer[PVector]()
  val points = Array[Float](10,10,10,200,200,10,200,200)

  override def setup {
    size(800, 800)
    set(0,0,2)
    frameRate(60)
    background(0)
    noLoop
  }
  def drawLines(array:Array[Float]){
    var i = 0
    val l = array.length/2
    while(i < l-1){
      val ii = i*2
      val x = array(ii)
      val y = array(ii+1)
      val nx = array(ii+2)
      val ny = array(ii+3)
      line(x,y,nx,ny)

      i += 1
    }
  }
  def drawLines(buf:IndexedSeq[PVector]){
    var i = 0
    val L = buf.length
    while(i < L -1){
      val I = i*2
      val a = buf(I)
      val b = buf(I+1)
      line(a.x,a.y,b.x,b.y)
      i += 1
    }
  }


  override def mouseDragged(e: Nothing): Unit = {
    super.mouseDragged(e)
    println("dragged:Nothing")
  }

  override def mouseDragged(){
    super.mouseDragged()
    println("dragged:Unit")
    records += new PVector(mouseX,mouseY)
  }

  override def draw {
    color(255,0,0)
    stroke(255,0,0)
    drawLines(records)
    bezier(10,10,10,200,200,10,200,200)
  }
}

object Main {
  def main(args:Array[String]) {
    PApplet.main(Array("kuhn.Main","--display=1"))
  }
}