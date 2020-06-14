package fr.noether.kata.polish.notation

import fr.noether.kata.polish.notation.Operator.Operator


case class Polish() {

  val splitPolish: String => (List[Operator], List[Int]) = expression => {
    val brutSplit = expression.split(" ").toList
      .partition(symbol => Operator.isOperatorSymbol(symbol))
    val tuple = (brutSplit._1.map(Operator.bySymbol).reverse, brutSplit._2.map(Integer.parseInt))
    print(tuple)
    tuple
  }

  val solve: ((List[Operator], List[Int])) => Int = {
    case (List(op), List(a, b)) => op.applyOn(a, b)
    case (op1 :: ops, a :: b :: left) => solve(ops, List(op1.applyOn(a, b)) ++ left)
  }

  val resolve: String => Int = splitPolish andThen solve
}
