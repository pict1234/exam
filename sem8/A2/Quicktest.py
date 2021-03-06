import unittest
from Quicksort import *

class Mytest(unittest.TestCase):
	def testfun(self):
		try:
			a = getdata('input.xml')
			if a==None:
				self.fail('failed')
		except:
			self.fail('Failed... Cannot Load file')

	def testfun1(self):
		self.assertEqual(getdata('input.xml'), [23, 2, 21])

	def testfun2(self):
		a = getdata('input.xml')
		self.assertEqual(quicksort(a, 0, len(a)-1), [2, 21, 23])

unittest.main()

