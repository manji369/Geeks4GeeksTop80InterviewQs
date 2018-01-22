'''
Q45. Given a distance ‘dist, count total number of ways to cover the distance with
1, 2 and 3 steps.

Examples:

Input:  n = 3
Output: 4
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step

Input:  n = 4
Output: 7
'''

def numberOfWays(n):
    fib = [1, 1, 2]
    if n <= 2:
        return fib[n]
    cur = sum(fib)
    for i in range(4, n+1):
        residue = fib[0]
        fib[0], fib[1], fib[2] = fib[1], fib[2], cur
        cur += fib[2]
        cur -= residue
    return cur

for i in range(5):
    print(str(i) + ": " + str(numberOfWays(i)))
