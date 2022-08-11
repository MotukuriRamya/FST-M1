from xmlrpc.client import Boolean
def  listcheck(numbers):
    if numbers[0] == numbers[length-1] :
        return True
    else :
        return False

numbers = list(input("Enter list of number with commas: ").split(", "))
length = len(numbers)
sum = 0

result = listcheck(numbers)
print(result)

