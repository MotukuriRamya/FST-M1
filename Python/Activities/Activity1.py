from lib2to3.pytree import convert
from threading import current_thread


name = input("Enter Name:")
age = int(input("Enter age"))
years = str((2022 - age) +100)

print(years)