import scala.annotation.tailrec

object ValidParentheses {

  private def isOpeningBracket(char: Char): Boolean = "{[(".contains(char)

  @tailrec
  private def go(string: String, stack: List[Char], flag: Boolean): Boolean = {

    if (string.isEmpty) flag && stack.isEmpty
    else {

      val char = string.head

      if (isOpeningBracket(char)) go(string.tail, char :: stack, flag)
      else {

        stack match {
          case head :: next =>
            (head, char) match {
              case ('(', ')') => go(string.tail, next, flag)
              case ('[', ']') => go(string.tail, next, flag)
              case ('{', '}') => go(string.tail, next, flag)
              case _          => false
            }

          case Nil => false
        }
      }
    }
  }

  def isValid(s: String): Boolean = go(s, List.empty[Char], flag = true)
}
