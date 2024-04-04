import math
import numpy as np
import matplotlib.pyplot as plt


def rechtekSumme(f, a, b, n):
    h = (b - a) / n
    return h * sum(f(a + i * h) for i in range(0, n))


def trapezium(f, a, b, n):
    h = (b - a) / n

    return h / 2 * f(a) + 2 * sum(f(a + i * h) + f(b) for i in range(1, n))
