package fr.noether.kata.polish.notation

import fr.noether.kata.polish.notation

object Operator extends Enumeration {
  protected case class Val(symbol: String, operation: (Int, Int) => Int) extends super.Val {
    def applyOn(x: Int, y: Int) = operation.apply(x, y)

  }

  implicit  def valueToOperation(x: Value): notation.Operator.Operator = x.asInstanceOf[Val]

  type Operator = Val

  val sum: Val = Val("+", (x,y) => x + y)
  val product: Val = Val("x", (x,y) => x * y)
  val subtract: Val = Val("-", (x, y) => x - y)

  def bySymbol(symbol: String): Operator = Operator.values.find(_.symbol == symbol).get
  def isOperatorSymbol(symbol: String): Boolean = !Operator.values.filter(_.symbol == symbol).isEmpty

}
