package lectures.l2

import scala.annotation.tailrec

/**
  * Цель упражнения: вычислить 9 - е число Фибоначчи
  * Для этого раскомментируйте строчку в методе fibs и исправьте ошибку компиляции.
  *
  * Данная реализация вычисления чисел фибоначчи крайне не оптимальна (имеет показатеьную сложность O(a.pow(n)) )
  * Для того, что бы в этом убедиться, Вы можете раскомментировать
  * строчку с вычислением 1000-ого числа фибоначчи
  *
  */
object Fibonacci extends App {

  // Task 2
  def fibs(num: Int): Int = {
    if (num == 1) return 1
    if (num == 2) return 1
    fibs(num - 1) + fibs(num - 2)
  }

  println(fibs(9))
  //println(fibs(1000))
}

/**
  * Цель упражнения: используя приемы динамического программирования,
  * реализовать более оптимальный алгоритм подсчета чисел фибоначчи
  * Для этого нужно реализовать функцию fibsImpl.
  * Сигнатуру функции Вы можете расширять по своему усмотрению,
  * но реализация должна удовлетворять следующим требованиям
  * * * * метод fibsImpl - должен быть tail recursive
  * * * * параметр acc - аккумулятор посчитанных значений
  *
  */
object Fibonacci2 extends App {

  def fibs2(num: Int): Int =
    if (num <= 3) Array(1, 1, 2)(num - 1)
    else fibsImpl(num, Array(1, 1, 2))(num - 1)

  @tailrec
  def fibsImpl(num: Int, acc: Array[Int]): Array[Int] = {
    if (num == 0) acc
    else {
      val last = acc.last + acc(acc.length - 2)
      fibsImpl(num - 1, Array(acc :+ last: _*))
    }
  }

  println(fibs2(16))
  //println(fibs(1000))
}




