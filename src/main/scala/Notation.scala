
class Notation {
  val useShort = true
  val useLong = false

  val thousand = 0
  val million = 1
  val billion = 2
  val trillion = 3
  val quadrillion = 4
  val quintillion = 5
  val sextillion = 6

    def getTerms(useShort: Boolean):List[String]={
      if(useShort) {
        List(" thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
      } else {
        List(" thousand ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " trilliard ")
      }
    }

    def convertNumber(number :BigInt, useShortNotation: Boolean): String ={
      def iter(numberString: String, notation :List[String]): String = numberString.length.toString match{
        case "0" => ""
        case "4" => numberString.take(1) + notation(thousand) + iter(numberString.tail, notation)
        case "7" => numberString.take(1) + notation(million) + iter(numberString.tail, notation)
        case "10" => numberString.take(1) + notation(billion) + iter(numberString.tail, notation)
        case "13" => numberString.take(1) + notation(trillion) + iter(numberString.tail, notation)
        case "16" => numberString.take(1) + notation(quadrillion) + iter(numberString.tail, notation)
        case "19" => numberString.take(1) + notation(quintillion) + iter(numberString.tail, notation)
        case "22" => numberString.take(1) + notation(sextillion) + iter(numberString.tail, notation)
        case _ =>  numberString.take(1) + iter(numberString.tail, notation)
      }
      iter(number.toString(), getTerms(useShortNotation))
    }

    def display(number :Long): Unit ={
      print("Short Notation:\n" + convertNumber(number, useShort) + "\n")
      print("Long Notation:\n" + convertNumber(number, useLong) + "\n")
    }
}
