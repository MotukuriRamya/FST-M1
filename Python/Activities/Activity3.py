
import random


print("Rock,papper and scissors game")

#rr = input("Rock")
#p = input("Papper")
#s = input("Scissors")
player = input("Enter your choice Rock,Paper,Scissors : ")
choices  = ["Rock", "Paper", "Scissors"]
computer = random.choice(choices)
print("Computer choice: " + computer)
if(player == computer):
    print("Tie")
if (player == "Rock"):
    if (computer == "Paper") :
        print("Computer got point - paper rolls rock")
    else:
        print("Player1 got point - rock wins")
elif (player == "Paper"):
    if (computer == "Scissors") :
        print("Computer got point - scissors cuts paper")
    else:
        print("Player got point - paper rolls rocks")
elif (player == "Scissors"):
    if (computer == "Rock") :
        print("Computer got point - rocks breaks scissors")
    else:
        print("Player got point - scissors cuts paper")

