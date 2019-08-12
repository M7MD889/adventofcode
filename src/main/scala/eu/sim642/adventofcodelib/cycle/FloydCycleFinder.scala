package eu.sim642.adventofcodelib.cycle

object FloydCycleFinder {
  def find[A](x0: A, f: A => A): Cycle[A] with Indexing[A] = {
    // https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare
    var tortoise = f(x0)
    var hare = f(f(x0))
    while (tortoise != hare) {
      tortoise = f(tortoise)
      hare = f(f(hare))
    }

    var μ = 0
    tortoise = x0
    while (tortoise != hare) {
      tortoise = f(tortoise)
      hare = f(hare)
      μ += 1
    }

    var λ = 1
    hare = f(tortoise)
    while (tortoise != hare) {
      hare = f(hare)
      λ += 1
    }


    FunctionCycle(
      stemLength = μ,
      cycleLength = λ,
      cycleHead = tortoise
    )(x0, f)
  }


  def findBy[A, B](x0: A, f: A => A)(m: A => B): CycleBy[A] = {
    var tortoise = f(x0)
    var hare = f(f(x0))
    while (m(tortoise) != m(hare)) {
      tortoise = f(tortoise)
      hare = f(f(hare))
    }

    var μ = 0
    tortoise = x0
    while (m(tortoise) != m(hare)) {
      tortoise = f(tortoise)
      hare = f(hare)
      μ += 1
    }

    var λ = 1
    hare = f(tortoise)
    while (m(tortoise) != m(hare)) {
      hare = f(hare)
      λ += 1
    }


    SimpleCycleBy(
      stemLength = μ,
      cycleLength = λ,
      cycleHead = tortoise,
      cycleHeadRepeat = hare
    )
  }
}
