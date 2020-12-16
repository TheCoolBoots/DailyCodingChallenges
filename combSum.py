from typing import List
import unittest
import itertools


def romanToInt(s):
    """
    :type s: str
    :rtype: int
    """
    sum = 0
    index = 0
    while index < len(s):
        cur = s[index]
        if cur == "M":
            sum += 1000
        elif cur == "D":
            sum += 500
        elif cur == "C":
            if index < len(s) - 1:
                if s[index + 1] == "D":
                    sum += 400
                    index += 1
                elif s[index + 1] == "M":
                    sum += 900
                    index += 1
                else:
                    sum += 100
            else:
                sum += 100
        elif cur == "L":
            sum += 50
        elif cur == "X":
            if index < len(s) - 1:
                if s[index + 1] == "L":
                    sum += 40
                    index += 1
                elif s[index + 1] == "C":
                    sum += 90
                    index += 1
                else:
                    sum += 10
            else:
                sum += 10
        elif cur == "V":
            sum += 5
        elif cur == "I":
            if index < len(s) - 1:
                if s[index + 1] == "V":
                    sum += 4
                    index += 1
                elif s[index + 1] == "X":
                    sum += 9
                    index += 1
                else:
                    sum += 1
            else:
                sum += 1
        index += 1
    return sum


if __name__ == '__main__':
    print(romanToInt("MCMXCIV"))
