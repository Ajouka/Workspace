import math
import numpy as np
import matplotlib.pyplot as plt


def rechtekSumme(f, a, b, n):
    h = (b - a) / n
    return h * sum(f(a + i * h) for i in range(0, n))


def trapezium(f, a, b, n):
    h = (b - a) / n

    return h / 2 * (f(a) + 2 * sum(f(a + i * h) for i in range(1, n)) + f(b))


def trapezium_vec(f, a, b, n):
    h = (b - a) / n
    vec = np.linspace(a + h, b - h, n - 2)

    return h / 2 * (f(a) + 2 * sum(f(vec)) + f(b))


f1x = lambda x: x ** -2  # man kan das als normaler funktion implemntieren siehe unten

# def f2(x):
#     return math.log(x)


f2x = lambda x: math.log(x)

f1_res_rechteck = np.array([rechtekSumme(f1x, 1 / 10, 10, n) for n in range(10, 200)])
f1_res_trapez = np.array([trapezium(f1x, 1 / 10, 10, n) for n in range(10, 200)])

plt.plot(range(10, 200), f1_res_rechteck, label="rechteck")
plt.plot(range(10, 200), f1_res_trapez, label="trapez")

plt.plot(range(10, 200), np.zeros(190) + 9.9, label="tatsächlicher Wert", linestyle="--", linewidth=1)
plt.title('f(x)1')
plt.xlabel("n")
plt.ylabel("y")
plt.legend()
plt.show()

f2_res_rechteck = np.array([rechtekSumme(f2x, 1, 2, n) for n in range(10, 200)])
f2_res_trapez = np.array([trapezium(f2x, 1, 2, n) for n in range(10, 200)])

plt.plot(range(10, 200), f2_res_rechteck, label="rechteck")
plt.plot(range(10, 200), f2_res_trapez, label="trapez")

plt.plot(range(10, 200), np.zeros(190) + math.log(4) - 1, label="tatsächlicher Wert", linestyle="--", linewidth=1)
plt.title('f(x)2')
plt.xlabel("n")
plt.ylabel("y")
plt.legend()
plt.show()

print(f1x(2))
