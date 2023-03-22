package gen

object declare {
  private val memory: Code = Code.Ins("(memory 1 10)")
  private val Heap: Code = Code.Ins("(global $HEAP (mut i32) (i32.const 0))")
  private val Environment: Code = Code.Ins("(global $ENV  (mut i32) (i32.const 0))")
  private val Accumulator: Code = Code.Ins("(global $ACC  (mut i32) (i32.const 999))")
  private val dList: Code = Code.Ins("(global $LIST i32 (i32.const 1))")
  private val Nil: Code = Code.Ins("(global $NIL  i32 (i32.const 0))")

  // stores a pair on the heap and returns a pointer to the pair
  private val pair: Code = Code.Ins("(func $pair (param $first i32) (param $second i32) (result i32)\n" +
    "    (local $result i32)\n" +
    "    (local.set $result (global.get $HEAP))\n" +
    "    (i32.store (global.get $HEAP) (local.get $first))\n" +
    "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
    "    (i32.store (global.get $HEAP) (local.get $second))\n" +
    "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
    "    (local.get $result)\n" +
    "    return)")

  //a cons is stored as a block of 3 words: a LIST tag, the head and the tail
  private val cons: Code = Code.Ins("(func $cons (param $head i32) (param $tail i32) (result i32)\n" +
    "    (local $result i32)\n" +
    "    (local.set $result (global.get $HEAP))\n" +
    "    (i32.store (global.get $HEAP) (global.get $LIST))\n" +
    "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
    "    (i32.store (global.get $HEAP) (local.get $head))\n" +
    "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
    "    (i32.store (global.get $HEAP) (local.get $tail))\n" +
    "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
    "    (local.get $result)\n" +
    "    return)")

  private val head: Code = Code.Ins("(func $head (param $list i32) (result i32)\n" +
    "    (i32.load (i32.add (local.get $list (i32.const 4))))\n" +
    "    return)")

  private val tail: Code = Code.Ins("(func $tail (param $list i32) (result i32)\n" +
    "    (i32.load (i32.add (local.get $list (i32.const 8))))\n" +
    "    return)")

  // retrieves the element $n of the list $list (starting from 0)
  // precondition: the size of the list is greater than $n
  private val search: Code = Code.Ins("(func $search (param $n i32) (param $list i32) (result i32)\n" +
    "    (local.get $n) \n" +
    "    (if (result i32)              \n" +
    "      (then            ;; n is non zero\n" +
    "       (i32.sub (local.get $n) (i32.const 1))\n" +
    "       (local.get $list)\n" +
    "       (call $tail)\n" +
    "       (call $search))\n" +
    "      (else            ;; n is zero\n" +
    "       (local.get $list)\n" +
    "       (call $head)))\n" +
    "    return)")

  private val apply: Code = Code.Ins("(func $apply (param $W i32)(param $C i32)(result i32)\n" +
    "      (local $e i32) ;; the environment e stored in the closure\n" +
    "      (local.get $W) ;; element 0 of the environment\n" +
//    "      (local.get $C) ;; element 1 of the environment\n" +
    "    ;; retrieve the environment in the closure (2nd element of a pair)\n" +
    "      (local.set $e (i32.load (i32.add (local.get $C)(i32.const 4))))\n" +
    "    ;; extend the environment e to <W, <C, e>>\n" +
    "      (local.get $e)\n" +
//    "      (call $cons)\n" +
    "      (call $cons)\n" +
    "      (global.set $ENV)\n" +
    "    ;; retrieve index of closure body and executes the body\n" +
    "    (call_indirect (result i32) (i32.load (local.get $C)))\n" +
    "  )")

  val all: () => Code = () => {
    Code.Seq(List[Code](memory, Heap, Environment, Accumulator, dList, Nil, pair, cons, head, tail, search, apply))
  }
}

def Search(idx: Int, list: Code): Code = {
  Code.Seq(List(Code.Ins(s"(i32.const $idx)"), list, Code.Ins("(call $search)")))
}

def Cons(head: Int, tail: Code): Code = {
  Code.Seq(List(
    Code.Ins(s"(i32.const $head)"),
    tail,
    Code.Ins("(call $cons)")
  ))
}

val PushEnv: Code = Code.Ins("(global.get $ENV)")

val Extend: Code = Code.Seq(List(
  Code.Ins("(global.get $ENV)"),
  Code.Ins("(call $cons)"),
  Code.Ins("(global.set $ENV)")
))

val SaveAcc: Code = Code.Ins("(global.set $ACC)")
val RetrieveAcc: Code = Code.Ins("(global.get $ACC)")
val PopEnv: Code = Code.Ins("(global.set $ENV)")


def MkClos(idx : Int) : Code =
  Code.Seq(
    List(
      Code.Ins(s"(i32.const $idx)"),
      Code.Ins("(global.get $ENV)"),
      Code.Ins("(call $pair)")
    )
  )

def Apply(closure: Code, arg: Code): Code = {
  Code.Seq(List(
    PushEnv,
    arg,
    closure,
    Code.Ins("(call $apply)"),
    SaveAcc,
    PopEnv,
    RetrieveAcc
  ))
}


