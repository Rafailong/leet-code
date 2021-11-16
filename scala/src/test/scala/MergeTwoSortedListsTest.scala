import MergeTwoSortedLists.{ListNode, mergeTwoLists}
import munit.FunSuite

import scala.annotation.tailrec

class MergeTwoSortedListsTest extends FunSuite {

  @tailrec
  private def show(l: ListNode): Unit = {
    println(s"x = ${l.x}")
    if (l.next == null) ()
    else show(l.next)
  }

  test("mergeTwoLists") {

    val l1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val l2 = new ListNode(1, new ListNode(3, new ListNode(4)))

    val result = mergeTwoLists(l1, l2)
    show(result)
  }
}
