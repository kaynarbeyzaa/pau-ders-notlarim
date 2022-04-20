import math
import os
import random
import re
import sys

if __name__ == '__main__':
    s = input()

    occu_dict = {}
    for i in range(len(s)):
        if s[i] in occu_dict:
            occu_dict[s[i]] = (s[i], occu_dict[s[i]][1]+1)
            print("if: ",occu_dict)
        else:
            occu_dict[s[i]] = (s[i], 1)
            print("else:",occu_dict)

    order_dict = sorted(occu_dict.values(), key=lambda x:(-x[1],x[0]))

    print('\n'.join(list(map(lambda x: x[0]+' '+str(x[1]), order_dict[:3]))))