package fr.noether.kata.polish.notation

import org.scalatest.FlatSpec

class PolishNotation extends FlatSpec {
  val polish: Polish = Polish()

  "+ opérator" should "yield 0 when 0 sum with 0" in {
    assert(polish.resolve("+ 0 0") === 0)
  }

  it should "have 0 as neutral element" in {
    assert(polish.resolve("+ 0 5") === 5)
    assert(polish.resolve("+ 0 7") === 7)
  }

  it should "be commutative" in {
    assert(polish.resolve("+ 7 8") === 15)
    assert(polish.resolve("+ 8 7") === 15)
  }

  "x operator" should "yield 0 when 0" in {
    assert(polish.resolve("x 0 5") === 0)
  }

  it should "multiply two number" in {
    assert(polish.resolve("x 7 5") === 35)
  }

  "x + a b c operation" should "yield (a + b) x c" in {
    assert(polish.resolve("x + 3 5 6") === 48)
    assert(polish.resolve("x + 3 6 6") === 54)
  }

  "various operation" should "give a valid result" in {
    assert(polish.resolve("x + x 3 5 7 2") === 44)
    assert(polish.resolve("x + x 11 25 3 2") === 556)
    assert(polish.resolve("- x + x - 11 25 2 3 2 5") === -55)
  }


}
