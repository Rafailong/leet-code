import scala.annotation.tailrec

object MergeTwoSortedLists {

  // there is no way to construct empty instances of this
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {

    if (l1 == null) return l2
    if (l2 == null) return l1

    val lesser1 = l1.x
    val lesser2 = l2.x

    if (lesser1 <= lesser2) new ListNode(lesser1, mergeTwoLists(l1.next, l2))
    else new ListNode(lesser2, mergeTwoLists(l1, l2.next))
  }

  @tailrec
  def show(l: ListNode): Unit = {
    println(s"x = ${l.x}")
    if (l.next == null) ()
    else show(l.next)
  }

  def main(args: Array[String]): Unit = {

    val l1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val l2 = new ListNode(1, new ListNode(3, new ListNode(4)))

    val result = mergeTwoLists(l1, l2)
    show(result)
  }
}
