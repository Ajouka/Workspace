import math
import numpy as np
import matplotlib.pyplot as plt


# taylorverfahren
def sqrt_tylor(x0, x, n):
    ak = yk = math.sqrt(x0)
    for k in range(1, n):
        ak = (3 / (2 * k) - 1) * (x / x0 - 1) * ak
        yk += ak

    return yk


# x0=1
res_tylor_1 = np.array([sqrt_tylor(1, 2, n) for n in range(1, 11)])
# x0=4
res_tylor_2 = np.array([sqrt_tylor(4, 2, n) for n in range(1, 11)])




# Heron-verfahren

def sqrt_heron(yo, x, n):
    yk = yo
    for k in range(1, n):
        yk = 1 / 2 * (yk + x / yk)

    return yk


res_heron_1 = np.array([sqrt_heron(1, 2, n) for n in range(1, 11)])
res_heron_2 = np.array([sqrt_heron(2, 2, n) for n in range(1, 11)])



plt.plot(range(1, 11), res_tylor_1, label="x0 = 1 (Taylor)")
plt.plot(range(1, 11), res_tylor_2, label="x0 = 4 (Taylor)")
plt.plot(range(1, 11), res_heron_1, label="x0 = 1 (Heron)")
plt.plot(range(1, 11), res_heron_2, label="x0 = 2 (Heron)")
plt.plot(range(1, 11), np.zeros(10) + math.sqrt(2), label="tatsächlicher Wert", linestyle="--", linewidth=1)
plt.title('$\sqrt{2}$ mit beiden Verfahren')
plt.legend()
plt.show()
