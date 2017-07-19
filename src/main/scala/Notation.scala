
class Notation {
  val useShort = true
  val useLong = false

    def getTerms(useShort: Boolean):List[String]={
      if(useShort) {
        List(" thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
      } else {
        List(" thousand ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " trilliard ")
      }
    }

  val thousand = 0
  val million = 1
  val billion = 2
  val trillion = 3
  val quadrillion = 4
  val quintillion = 5
  val sextillion = 6

  def convertNumber(number :BigInt, useShortNotation: Boolean): String ={

    def getCurrentString(numberString: String, notation: List[String], position: Int):String ={
      numberString.take(1) + notation(position) + iter(numberString.tail, notation)
    }

    def iter(numberString: String, notation :List[String]): String = numberString.length.toString match{
      case "0" => ""
      case "4" => getCurrentString(numberString, notation, thousand)
      case "7" => getCurrentString(numberString, notation, million)
      case "10" => getCurrentString(numberString, notation, billion)
      case "13" => getCurrentString(numberString, notation, trillion)
      case "16" => getCurrentString(numberString, notation, quadrillion)
      case "19" => getCurrentString(numberString, notation, quintillion)
      case "22" => getCurrentString(numberString, notation, sextillion)
      case _ =>  numberString.take(1) + iter(numberString.tail, notation)
    }
    iter(number.toString(), getTerms(useShortNotation))
  }

    def display(number :Long): Unit ={
      print("Short Notation:\n" + convertNumber(number, useShort) + "\n")
      print("Long Notation:\n" + convertNumber(number, useLong) + "\n")
    }
}
