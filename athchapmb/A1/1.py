# -*- coding : utf-8 -*-
import unittest

def binary_search(arr,size,key):

	low = 0
	high = size-1
	mid = (int(low+high)/2)
	print 'The sorted array is\n ',arr,'\nEnter the element you wish to search\n',key

	while low<=high:
		temp=0
		if key == int(arr[mid]):
			print 'found at position',mid+1
			return mid+1
			temp=1
			break

		elif key > int(arr[mid]):
			low = mid+1
			mid = (int(low+high)/2)

		else:
			high = mid-1
			mid = (int(low+high)/2)

	if temp == 0:
		print 'not found\n'
		return 0


class myTestcases(unittest.TestCase): # he visarlo hoto TestCase

	def test_positive(self):
		self.assertEqual(binary_search([10,20,30,40,50],5,20),2) # args chukiche takle

	def test_negative(self):
		self.assertEqual(binary_search([10,20,30,40,50],5,70),0)
			

arr = []
size = int(input("Enter arr size\n"))

for i in range (0,size):

	print "Enter the elements\n"
	arr.append(input())


print '---------------Testing----------------\n'	

print arr

arr.sort()
print arr

key = int(input("Enter element to be searched\n"))

position = binary_search(arr,size,key)

unittest.main()


















