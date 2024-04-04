import math
import numpy as np
import matplotlib.pyplot as plt


def exp(x, n):
    return sum(x ** k / math.factorial(k) for k in range(0, n + 1))


def exp2(x, n):
    return sum(x ** (n - k) / math.factorial(n - k) for k in range(0, n + 1))


for x in [0.1, 0.5, 1, 2, 5, 10, 20]:
    res = np.array([exp(x, n) for n in range(1, 50)])
    res_alt = np.array([exp2(x, n) for n in range(1, 50)])

    plt.plot(range(1, 50), res, label=f"exp", linewidth=4)
    plt.plot(range(1, 50), res_alt, label=f"exp2")
    plt.legend()
    plt.title(f"{x=}")
    plt.xlabel("n")
    plt.ylabel("y")
    plt.show()
