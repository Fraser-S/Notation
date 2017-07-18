import org.scalatest._

class NumberTest extends FlatSpec with Matchers {
  val notation = new Notation()
  "The notation function with short" should "follow the correct notation for less than 10^3" in {
    assert(notation.numberNotation(22, true) === "22")
  }

  it should "follow the correct notation for 10^3" in {
    assert(notation.numberNotation(2222, true) === "2 thousand 222")
  }

  it should "follow the correct notation for 10^6" in {
    assert(notation.numberNotation(2222222, true) === "2 million 222 thousand 222")
  }

  it should "follow the correct notation for 10^9" in {
    assert(notation.numberNotation(222222222222L, true) === "222 billion 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^12" in {
    assert(notation.numberNotation(22222222222222L, true) === "22 trillion 222 billion 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^15" in {
    assert(notation.numberNotation(22222222222222222L, true) === "22 quadrillion 222 trillion 222 billion 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^18" in {
    assert(notation.numberNotation(9223372036854775807L, true) === "9 quintillion 223 quadrillion 372 trillion 036 billion 854 million 775 thousand 807")
  }

  "The notation function with long " should "follow the correct notation for less than 10^3" in {
    assert(notation.numberNotation(22, false) === "22")
  }

  it should "follow the correct notation for 10^3" in {
    assert(notation.numberNotation(2222, false) === "2 thousand 222")
  }

  it should "follow the correct notation for 10^6" in {
    assert(notation.numberNotation(2222222, false) === "2 million 222 thousand 222")
  }

  it should "follow the correct notation for 10^9" in {
    assert(notation.numberNotation(222222222222L, false) === "222 milliard 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^12" in {
    assert(notation.numberNotation(22222222222222L, false) === "22 billion 222 milliard 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^15" in {
    assert(notation.numberNotation(22222222222222222L, false) === "22 billiard 222 billion 222 milliard 222 million 222 thousand 222")
  }
  it should "follow the correct notation for 10^18" in {
    assert(notation.numberNotation(9223372036854775807L, false) === "9 trillion 223 billiard 372 billion 036 milliard 854 million 775 thousand 807")
  }
}