
import unittest
from qwe import *

class mytestcases(unittest.TestCase):
	def f1(self):
		a= getdata('input.xml')
		self.assertEqual(quicksort(a,0,len(a)-1),[1,2,21])

unittest.main()
