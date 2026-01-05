package edu.gematria

class CalcKt {

    companion object {

        fun calc( /*@org.jetbrains.annotations.NotNull*/
                  str: String
        ): Int {
            var sum = 0
            for (i in 0..<str.length) {
                // vals += String.valueOf((int)str.charAt(i)) + " ";
                // Aleph's unicode
                if (str.get(i).toInt() >= 1488 && str.get(i).toInt() <= (1488 + 10 - 1)) {
                    // vals += "* ";
                    sum += str.get(i).toInt() - (1488 - 1)
                } else if (str.get(i).toInt() == 1488 + 10 || str.get(i).toInt() == 1488 + 11) {
                    sum += 20
                } else if (str.get(i).toInt() == 1488 + 12) {
                    sum += 30
                } else if (str.get(i).toInt() == 1488 + 13 || str.get(i).toInt() == 1488 + 14) {
                    sum += 40
                } else if (str.get(i).toInt() == 1488 + 15 || str.get(i).toInt() == 1488 + 16 || str.get(i)
                        .toInt() == 1487 /* U+05C6 Hebrew Punctuation Nun Hafukha */) {
                    sum += 50
                } else if (str.get(i).toInt() == 1488 + 17) {
                    sum += 60
                } else if (str.get(i).toInt() == 1488 + 18) {
                    sum += 70
                } else if (str.get(i).toInt() == 1488 + 19 || str.get(i).toInt() == 1488 + 20) {
                    sum += 80
                } else if (str.get(i).toInt() == 1488 + 21 || str.get(i).toInt() == 1488 + 22) {
                    sum += 90
                } else if (str.get(i).toInt() >= 1488 + 23 && str.get(i).toInt() <= 1488 + 23 + 4 - 1) {
                    sum += 100 * (str.get(i).toInt() - (1488 + 23) + 1)
                }
            }
            return sum
        }

    }
}