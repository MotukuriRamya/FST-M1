import numbers


number_list = list(input("Enter number using comma: ").split(','))

sum = 0

#for i in number_list:
 #   sum = int(i) +sum
#print(sum)

for i in range(0,(len(number_list))):
   number_list[i]  = int(number_list[i]) 
   sum = sum + number_list[i]
print(sum)
