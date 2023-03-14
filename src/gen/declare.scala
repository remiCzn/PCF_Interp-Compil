package gen

object declare {
  val Heap: Code = Code.Ins("(global $HEAP (mut i32) (i32.const 0))")
  val Environnement: Code = Code.Ins("(global $ENV  (mut i32) (i32.const 0))")
  val Accumulator: Code = Code.Ins("(global $ACC  (mut i32) (i32.const 999))")
  val List: Code = Code.Ins("(global $LIST i32 (i32.const 1))")
  val Nil: Code = Code.Ins("(global $NIL  i32 (i32.const 0))")
}

val cons: String = "(func $cons (param $head i32) (param $tail i32) (result i32)\n" +
  "    (local $result i32)\n" +
  "    (local.set $result (global.get $HEAP))\n" +
  "    (i32.store (global.get $HEAP) (global.get $LIST))\n" +
  "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
  "    (i32.store (global.get $HEAP) (local.get $head))\n" +
  "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
  "    (i32.store (global.get $HEAP) (local.get $tail))\n" +
  "    (global.set $HEAP (i32.add (global.get $HEAP) (i32.const 4)))\n" +
  "    (local.get $result)\n" +
  "    return)"

val search: String = "(func $search (param $n i32) (param $list i32) (result i32)\n" +
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
  "    return)"

