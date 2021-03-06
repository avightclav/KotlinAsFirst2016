@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import java.io.File

var primeNumbersFile = File("src/lesson4/task1/numbers.txt")
var guaranteedToWork = File("src/lesson4/task1/guaranteed.txt")

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        if (y < 0) listOf()
        else if (y == 0.0) listOf(0.0)
        else {
            val root = Math.sqrt(y)
            // Результат!
            listOf(-root, root)
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        if (b == 0.0) return listOf()
        else return sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0..list.size - 1) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    if (v.isEmpty()) return 0.0
    var abs = 0.0

    for (i in 0..v.size - 1) {
        abs += v[i] * v[i]
    }
    return Math.sqrt(abs)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) return 0.0
    return list.sum() / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()) return list

    val average = list.sum() / list.size

    for (i in 0..list.size - 1) {
        list[i] -= average
    }

    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var C = 0.0
    for (i in 0..a.size - 1) {
        C += a[i] * b[i]
    }
    return C
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var pX = 0.0
    for (i in 0..p.size - 1) {
        pX += p[i] * Math.pow(x, i.toDouble())
    }
    return pX
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    for (i in 1..list.size - 1) {
        list[i] = list.subList(i - 1, i + 1).sum()
    }
    return list
}


/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */

fun factorize(n: Int): List<Int> {
    if (n / 2 > guaranteedToWork.readText().toInt() / 2) {
        makePrimes(guaranteedToWork.readText().toInt(), n / 2)
        return trueFactorize(n)
    } else {
        return trueFactorize(n)
    }
}

fun trueFactorize(n: Int): List<Int> {
    var nCopy = n
    var i = 0
    val factorized = mutableListOf<Int>()
    val primes = primeNumbersReader().filter { n % it == 0 }
    if (primes.size != 0) {
        while (nCopy != 1) {
            if (nCopy % primes[i] == 0) {
                nCopy /= primes[i]
                factorized.add(primes[i])
            } else {
                i++
            }
        }
    } else factorized.add(n)
    print(factorized)
    return factorized
}

fun makePrimes(from: Int, to: Int) {

    val primeNumbers = primeNumbersReader()
    var numbers = mutableMapOf<Int, Boolean>()

    for (i in from..to / 2) numbers.put(i, true)

    for (i in primeNumbers) {
        numbers = numbers.filter { it.key % i != 0 } as MutableMap<Int, Boolean>
    }
    primeNumbersWriter(numbers)
    guaranteedToWorkWriter(to)
}


fun guaranteedToWorkWriter(n: Int) = guaranteedToWork.writeText("$n")

fun primeNumbersWriter(numbers: Map<Int, Boolean>) {
    numbers.forEach {
        primeNumbersFile.appendText("\n${it.key}")
    }
}

fun primeNumbersReader(): List<Int> {
    val lines = primeNumbersFile.readLines()
    val numbers = mutableListOf<Int>()
    lines.forEach { numbers.add(it.toInt()) }
    return numbers
}


/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести заданное натуральное число n в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное натуральное число n в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val num = n.toString()
    val digits = listOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять")
    val teens = listOf("", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val decades = listOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто")
    val hundreds = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var tho = ""
    when (n) {
        in 0..10 -> return digits[n]
        in 11..19 -> return teens[n % 10]
        in 20..99 -> return decades[n / 10] + if (n%10 != 0) " " + digits[n % 10] else ""
        in 100..999 -> return hundreds[n / 100] + " " +
                if (cInt(num[1]) == 1) teens[cInt(num[2])] else russian((num[1].toString() + num[2].toString()).toInt())
        in 1000..999999 -> {
            for (i in 0..num.length - 4) tho += num[i].toString()
            return forThousand(tho.toInt()) + " " + whatThousandExactly(tho) +
                    if (num.subSequence(num.length-3, num.length).toString().toInt() != 0) " " +
                    russian(num.subSequence(num.length - 3, num.length).toString().toInt()) else ""
        }
        else -> return "Ошибка"
    }

}

fun forThousand(n: Int): String {
    val num = n.toString()
    val digits = listOf("", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять")
    val teens = listOf("", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val decades = listOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто")
    val hundreds = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    when (n) {
        in 0..10 -> return digits[n]
        in 11..19 -> return teens[n % 10]
        in 20..99 -> return decades[n / 10] + if (n%10 != 0) " " + digits[n % 10] else ""
        in 100..999 -> return hundreds[n / 100] + if (num.subSequence(1, num.length).toString().toInt() != 0) " " +
                if (cInt(num[1]) == 1) teens[cInt(num[2])]
                else forThousand((num[1].toString() + num[2].toString()).toInt())
            else digits[n % 10]
        else -> return "Ошибка"
    }
}

fun whatThousandExactly(s: String): String {
    if (s.toInt() in 0..999) {
        return when {
            (s.toInt() % 100 !in 10..20) && s.toInt() % 10 in 2..4 -> "тысячи"
            (s.toInt() % 100 !in 10..20) && s.toInt() % 10 == 1 -> "тысяча"
            else -> "тысяч"

        }
    }
    return ""
}

fun cInt(c: Char): Int = c.toString().toInt()
