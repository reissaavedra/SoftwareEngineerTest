import math

class ES003:
    def __init__(self, money):
        self.COINS = [.2,.5,1,2,5,10,20,50,100,200]
        self.money = money
        
    def compute(self):
        resp = []
        r = self.binary_search(self.COINS, 0, len(self.COINS) - 1 , self.money)
        a = self.coin_combos(self.money, r)
        lenI = len(r)

        for i in a:
            for x in range(lenI):
                if i[x] != 0:
                    b = [r[x] for i in range(i[x])]
                    resp.append(b)
        return resp
        
    def binary_search(self, arr, low, high, x):
        if high >= low:
            mid = int((high + low) // 2)
            if arr[mid] == x:
                return arr[:mid+1]
            elif arr[mid-1] <= x and arr[mid] > x:
                return arr[:mid]
            elif arr[mid] > x:
                return self.binary_search(arr, low, mid - 1, x) 
            else:
                return self.binary_search(arr, mid + 1, high, x)
        else:
            return -1
    
    def coin_combos(self, goal, unit_list):
        if goal == 0:
            return [[0] * len(unit_list)]

        if len(unit_list) == 0:
            return []
        unit = unit_list[0]
        unit_list2 = unit_list[1:]
        max_cnt = math.trunc(goal / unit)
        return [[i] + s for i in range(max_cnt + 1) for s in self.coin_combos(goal - i * unit, unit_list2)]