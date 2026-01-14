"""Python translation of the `calc` function from docs/index.html.

Usage:
    from calc import calc
    print(calc('דוגמה'))
"""

from __future__ import annotations

def calc(s: str) -> int:
    """Compute gematria value for a Hebrew string.

    Mirrors the character-to-value mapping used in the original JavaScript.
    """
    total = 0
    aleph = 1488
    for ch in s:
        cp = ord(ch)
        if aleph <= cp <= (aleph + 10 - 1):
            total += cp - (aleph - 1)
        elif cp == aleph + 10 or cp == aleph + 11:
            total += 20
        elif cp == aleph + 12:
            total += 30
        elif cp == aleph + 13 or cp == aleph + 14:
            total += 40
        elif cp == aleph + 15 or cp == aleph + 16 or cp == 1487:
            total += 50
        elif cp == aleph + 17:
            total += 60
        elif cp == aleph + 18:
            total += 70
        elif cp == aleph + 19 or cp == aleph + 20:
            total += 80
        elif cp == aleph + 21 or cp == aleph + 22:
            total += 90
        elif (aleph + 23) <= cp <= (aleph + 23 + 4 - 1):
            total += 100 * (cp - (aleph + 23) + 1)
    return total


if __name__ == "__main__":
    import sys
    if len(sys.argv) > 1:
        inp = sys.argv[1]
    else:
        inp = input('Enter Hebrew text: ')
    print(calc(inp))


import unittest


class CalcTests(unittest.TestCase):
    def test_empty(self):
        self.assertEqual(calc(""), 0)

    def test_example(self):
        # Matches the sample shown in docs/index.html
        self.assertEqual(calc("דוגמה"), 58)

    def test_basic_letters(self):
        self.assertEqual(calc("א"), 1)
        self.assertEqual(calc("טוב"), 17)
        self.assertEqual(calc("שח ר"), 508)

