import scala.annotation.tailrec

object AddTwoNumbers {

  class ListNode(_x: Int, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  object ListNode {

    @tailrec
    final def toList(ln: ListNode, acc: List[Int]): List[Int] = {
      if (ln == null) acc
      else toList(ln.next, acc :+  ln.x)
    }

    def reverse(listNode: ListNode): ListNode = {

      @tailrec
      def loop(ln: ListNode, acc: ListNode): ListNode =
        if (ln == null) acc
        else loop(ln.next, new ListNode(ln.x, acc))

      loop(listNode.next, new ListNode(listNode.x))
    }

    def show(listNode: ListNode): String =
      toList(listNode, List.empty).mkString(" -> ")
  }

  def helper(n: Int): (Int, Int) = {
    if (n >= 10) {
      val r = n % 10
      (1, r)
    } else (0, n)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    @tailrec
    def loop(as: ListNode, bs: ListNode, acc: ListNode, r: Int): ListNode = {

      (as, bs) match {
        case (null, null) if r > 0 => new ListNode(r, acc)
        case (null, null)          => acc
        case (_, null) =>
          val (nr, a) = helper(as.x + r)
          val nAcc = new ListNode(a, acc)
          loop(
            as.next,
            bs = null,
            acc = nAcc,
            nr
          )
        case (null, _) =>
          val (nr, b) = helper(bs.x + r)
          val nAcc = new ListNode(b, acc)
          loop(
            as = null,
            bs.next,
            nAcc,
            nr
          )
        case (_, _) =>
          val a = as.x
          val b = bs.x
          val (nr, c) = helper(a + b + r)
          val nAcc = new ListNode(c, acc)
          loop(
            as.next,
            bs.next,
            nAcc,
            nr
          )
      }
    }

    val a = l1.x
    val b = l2.x
    val (r, c) = helper(a + b)
    ListNode.reverse(
      loop(
        l1.next,
        l2.next,
        acc = new ListNode(c),
        r
      )
    )
  }

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2, new ListNode(4, new ListNode(3)))
    val l2 = new ListNode(5, new ListNode(6, new ListNode((4))))

    val listNode = addTwoNumbers(l1, l2)
    println("original = " ++ ListNode.show(listNode))

    val reversed = ListNode.reverse(listNode)
    println("reversed = " ++ ListNode.show(reversed))
  }
}
