import munit._
import AddTwoNumbers.ListNode
import AddTwoNumbers.ListNode.{reverse, show}
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Prop._

class AddTwoNumbersTest extends ScalaCheckSuite {

  val listNodeGen: Gen[(Int, ListNode)] = for {
    size <- Gen.chooseNum(1, 8)
    head <- Gen.chooseNum(1, 9)
    tail <- Gen.listOfN(size - 1, Gen.chooseNum(0, 9))
    _list = head :: tail
    n = _list.mkString.toInt
    listNode = tail.reverse.foldRight(new ListNode(head)) { (i, ln) =>
      new ListNode(i, ln)
    }
  } yield (n, listNode)

  type Input = (ListNode, ListNode, Int)

  val inputGen: Gen[Input] =
    for {
      (n1, l1) <- listNodeGen
      (n2, l2) <- listNodeGen
    } yield (l1, l2, n1 + n2)

  implicit val arb: Arbitrary[Input] = Arbitrary(inputGen)

  property("test generator") {
    forAll { (pair: Input) =>
      val (l1, l2, n) = pair

      println(s"n = $n")
      println(s"l1 = ${ListNode.show(l1)}")
      println(s"l2 = ${ListNode.show(l2)}")

      val result = AddTwoNumbers.addTwoNumbers(l1, l2)
      val reversed = reverse(result)

      val nn = ListNode.toList(reversed, List.empty).mkString.toInt

      println(s"result = ${show(result)}")
      println(s"reversed = ${show(reversed)}")
      println(s"nn = $nn")

      println("-" * 50)

      n == nn
    }
  }
}
