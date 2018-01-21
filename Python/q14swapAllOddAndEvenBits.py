'''
Q14. Given an unsigned integer, swap all odd bits with even bits. For example,
if the given number is 23 (00010111), it should be converted to 43 (00101011).
Every even position bit is swapped with adjacent bit on right side (even
position bits are highlighted in binary representation of 23), and every
odd position bit is swapped with adjacent on left side.
'''

def swapBits(n):
    e_bits = n & 0xAAAAAAAA
    o_bits = n & 0x55555555
    e_bits >>= 1
    o_bits <<= 1
    return e_bits | o_bits
    # return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1)

print(swapBits(23))
