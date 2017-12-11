package eu.sim642.adventofcode2017

import Day11._
import org.scalatest.FunSuite
import org.scalatest.prop.PropertyChecks

class Day11Test extends FunSuite with PropertyChecks {

  test("Part 1 examples") {
    val inputSteps = Table(
      ("input", "steps"),
      ("ne,ne,ne", 3),
      ("ne,ne,sw,sw", 0),
      ("ne,ne,s,s", 2),
      ("se,sw,se,sw,sw", 3)
    )

    forAll (inputSteps) { (input, steps) =>
      assert(fewestSteps(input) == steps)
    }
  }

  test("Part 1 input answer") {
    assert(fewestSteps(input) == 675)
  }
}
