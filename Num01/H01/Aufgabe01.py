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


# zweite Verfahren ist genauer


# Aufgabe 2
def exp(x, n):
    return sum(x ** k / math.factorial(k) for k in range(0, n + 1))


def exp2(x, n):
    return sum(x ** (n - k) / math.factorial(n - k) for k in range(0, n + 1))


for x in [0.1, 0.5, 1, 2, 5, 10, 15]:
    res = np.array([exp(x, n) for n in range(1, 50)])
    res_alt = np.array([exp2(x, n) for n in range(1, 50)])

    plt.plot(range(1, 50), res, label=f"exp", linewidth=4)
    plt.plot(range(1, 50), res_alt, label=f"exp2")
    plt.legend()
    plt.title(f"{x=}")
    plt.xlabel("n")
    plt.ylabel("y")
    plt.show()


# Aufgabe03
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


# Aufgabe5


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
