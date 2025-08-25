import random as r

ans = [r.randint(0,9) for i in range(4)]
print(ans)
def guess(usr_ans):
    A = 0
    B = 0
    for digit in usr_ans:
        if int(digit) in ans:
            if usr_ans.index(digit) == ans.index(int(digit)):
                A+=1
            else:
                B+=1
    if A == 4:
        print("You win!!")
        return True
    else:
        print(f"{A} A (Bulls) {B} B (Cows)")
        return False

while True:
    usr_ans = input("Please input 4 digits:")
    isDigit = True
    for i in usr_ans:
        if type(i) != type(1):
            isDigit = False
    if len(usr_ans) != 4 or isDigit == False:
        print("Enter 4 DIGITS!")
        continue

    isCorrect = guess(usr_ans)
    if isCorrect == True or usr_ans == "quit":
        break
