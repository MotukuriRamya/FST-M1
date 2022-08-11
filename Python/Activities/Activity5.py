#multiplication table of numbers

from lib2to3.pytree import convert


number = int(input("Enter number: "))

for  i in range(1,11):{
    #2*1 = 2
    print(number, ' x ', i, ' = ', number*i)
}