import math
import numpy as np
import matplotlib.pyplot as plt


# Aufgabe01
def pq_solve(p, q):
    z = np.sqrt(p ** 2 + q)
    return -p + z


def pq_solve2(p, q):
    x1 = -p - math.sqrt(p ** 2 + q)
    x2 = -q / x1
    return x2


def eval_pq(p, q, x):
    return x ** 2 + 2 * p * x - q


for p in [10 ** 2, 10 ** 4, 10 ** 6, 10 ** 7, 10 ** 8]:
    res = pq_solve(p, 1)
    res2 = pq_solve2(p, 1)
    # print("when p=", p, ":", eval_pq(p, 1, res[0]))
    print("when p=", p, ":", eval_pq(p, 1, res))

    # print("when p=", p, ":", eval_pq(p, 1, res2[0]))
    print("when p=", p, ":", eval_pq(p, 1, res2))
